package joelespinal.com.pokemonapp.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import joelespinal.com.pokemonapp.R;
import joelespinal.com.pokemonapp.database.AttackDao;
import joelespinal.com.pokemonapp.database.JoinPokeCardAndAttacksDao;
import joelespinal.com.pokemonapp.database.PokeCardDao;
import joelespinal.com.pokemonapp.database.TypesDao;
import joelespinal.com.pokemonapp.database.KeyValueModelDao;
import joelespinal.com.pokemonapp.model.Attack;
import joelespinal.com.pokemonapp.model.JoinPokeCardAndAttacks;
import joelespinal.com.pokemonapp.model.KeyValueModel;
import joelespinal.com.pokemonapp.model.PokeCard;
import joelespinal.com.pokemonapp.model.Types;
import joelespinal.com.pokemonapp.network.ClientUsage;
import joelespinal.com.pokemonapp.network.PokeCardDTO;
import joelespinal.com.pokemonapp.network.PokemonApiService;
import joelespinal.com.pokemonapp.network.PokemonResponse;
import joelespinal.com.pokemonapp.utilities.AppVariableStorage;
import joelespinal.com.pokemonapp.utilities.DateUtil;
import joelespinal.com.pokemonapp.utilities.NetworkUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity implements PokemonListFragment.PokemonListFragmentCallbacks {

    private static final long TWELVE_HOURS = 12;
    private FragmentManager fragmentManager;
    private PokemonListFragment pokemonListFragment;
    private ProgressBar progressBar;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progress_bar);
        toolbar = findViewById(R.id.toolbar);
        setActionBar(toolbar);
        configureToolbar();
    }

    private void configureToolbar() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.pokemon_tittle);
        }
    }

    @Override
    protected void onResume() {
        ((RelativeLayout) progressBar.getParent()).setVisibility(View.VISIBLE);
        Date lastUpdatedDate = AppVariableStorage.getCurrencyLastUpdatedDate(this);
        Date today = Calendar.getInstance().getTime();
        if (dataOutOfDate(lastUpdatedDate, today)) {
            if (!NetworkUtil.isConnected(getApplicationContext())) {
                Toast.makeText(this, R.string.no_connection_error, Toast.LENGTH_LONG).show();
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(0L);
                Toast.makeText(this, R.string.more_than_twelve_hours_refresh, Toast.LENGTH_LONG).show();
                showProgress(true);
                getCards();
            }
        } else {
            startListFragment();
        }
        super.onResume();
    }

    private void startListFragment() {
        if (pokemonListFragment == null)
            pokemonListFragment = new PokemonListFragment();
        if (fragmentManager == null)
            fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container, pokemonListFragment).commit();
    }

    private void getCards() {

        Integer initialPage = 1;
        PokemonApiService service = ClientUsage.getRetrofitInstance().create(PokemonApiService.class);
        Call<PokemonResponse> call = service.getCards(initialPage);
        call.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(@NonNull Call<PokemonResponse> call, @NonNull Response<PokemonResponse> response) {
                if (!response.isSuccessful()) {
                    showProgress(false);
                    Toast.makeText(MainActivity.this, R.string.request_error, Toast.LENGTH_LONG).show();
                } else {
                    PokemonResponse pokemonResponse = response.body();
                    if (pokemonResponse != null) {
                        new SaveCardsAsyncTask(MainActivity.this).execute(pokemonResponse);
                    } else {
                        showProgress(false);
                        Toast.makeText(MainActivity.this, R.string.request_error, Toast.LENGTH_LONG).show();
                    }
                }

            }

            @Override
            public void onFailure(@NonNull Call<PokemonResponse> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, R.string.request_error, Toast.LENGTH_LONG).show();
                showProgress(false);

            }
        });

    }

    @Override
    public void getPokemonId(String pokemonId) {
        startDetailFragment(pokemonId);
    }

    private void startDetailFragment(String pokemonId) {

    }

    protected static class SaveCardsAsyncTask extends AsyncTask<PokemonResponse, Void, Void> {
        WeakReference<Activity> weakActivityReference;
        Integer orientation;

        private SaveCardsAsyncTask(Activity activity) {
            weakActivityReference = new WeakReference<>(activity);
            orientation = activity.getRequestedOrientation();
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        }

        @Override
        protected Void doInBackground(PokemonResponse... pokemonResponses) {
            PokemonResponse response = pokemonResponses[0];
            List<PokeCardDTO> pokeCardDTOS = null;
            if (weakActivityReference != null) {
                if (response != null) {
                    pokeCardDTOS = response.getPokeCardDTOS();
                    if (pokeCardDTOS != null && !pokeCardDTOS.isEmpty())
                        for (PokeCardDTO pokeCard : response.getPokeCardDTOS()) {
                            List<Attack> attacks = pokeCard.getAttacks();
                            if (attacks != null && !attacks.isEmpty())
                                AttackDao.saveAll(attacks);
                            List<Types> types = pokeCard.getTypes();
                            if (types != null && !types.isEmpty())
                                TypesDao.saveAll(types);
                            List<KeyValueModel> weaknesses = pokeCard.getWeaknesses();
                            if (weaknesses != null && !weaknesses.isEmpty())
                                KeyValueModelDao.saveAll(weaknesses);
                            List<KeyValueModel> resistances = pokeCard.getResistances();
                            if (resistances != null && !resistances.isEmpty())
                                KeyValueModelDao.saveAll(resistances);
                            PokeCardDao.save(pokeCard.getPockeCard());
                        }
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            MainActivity activity = (MainActivity) weakActivityReference.get();
            if (activity != null) {
                AppVariableStorage.putCurrencyLastUpdatedDate(activity);
                activity.showProgress(false);
                activity.setRequestedOrientation(orientation);
                activity.startListFragment();
                Toast.makeText(activity, R.string.updated_data, Toast.LENGTH_LONG).show();
            }
        }
    }

    private void showProgress(boolean show) {
        if (progressBar != null)
            progressBar.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
    }

    private boolean dataOutOfDate(Date lastUpdatedDate, Date today) {
        return DateUtil.getHoursBetween(lastUpdatedDate, today) >= TWELVE_HOURS;
    }
}
