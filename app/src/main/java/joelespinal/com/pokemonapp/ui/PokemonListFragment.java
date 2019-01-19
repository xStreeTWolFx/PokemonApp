package joelespinal.com.pokemonapp.ui;


import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import joelespinal.com.pokemonapp.R;
import joelespinal.com.pokemonapp.adapter.PokemonAdapter;
import joelespinal.com.pokemonapp.database.PokeCardDao;
import joelespinal.com.pokemonapp.model.PokeCard;


public class PokemonListFragment extends ListFragment {

    private List<PokeCard> pokeCards = new ArrayList<>();
    private PokemonAdapter pokemonAdapter;
    private PokemonListFragmentCallbacks listener;

    public PokemonListFragment() {
        // Required empty public constructor
    }

    public interface PokemonListFragmentCallbacks {
        void getPokemonId(String pokemonId);
    }

    public void setListener(PokemonListFragmentCallbacks listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pokemon_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pokeCards = PokeCardDao.loadAll();
        pokemonAdapter = new PokemonAdapter(pokeCards, getContext());
        setListAdapter(pokemonAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        PokeCard pokeCard = (PokeCard) pokemonAdapter.getItem(position);
        if (listener != null)
            listener.getPokemonId(pokeCard.getId());
        super.onListItemClick(l, v, position, id);
    }
}
