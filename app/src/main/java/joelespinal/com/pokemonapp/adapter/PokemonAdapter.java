package joelespinal.com.pokemonapp.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;
import java.util.StringJoiner;

import joelespinal.com.pokemonapp.R;
import joelespinal.com.pokemonapp.model.PokeCard;
import joelespinal.com.pokemonapp.model.Types;

public class PokemonAdapter extends BaseAdapter {

    private List<PokeCard> pokeCards;
    private Context context;

    public PokemonAdapter(@NonNull List<PokeCard> pokeCards, @NonNull Context context) {
        this.pokeCards = pokeCards;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pokeCards.size();
    }

    @Override
    public Object getItem(int position) {
        return pokeCards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_poke_card, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        PokeCard pokeCard = null;
        if (pokeCards != null && !pokeCards.isEmpty()) {
            pokeCard = pokeCards.get(position);
        }
        if (pokeCard != null) {
            viewHolder.nameTextView.setText(pokeCard.getName());
            String pokedexNumber = String.format(Locale.US, "%d", pokeCard.getPokeDexNumber());
            viewHolder.pokedexNumberTextView.setText(pokedexNumber.replace("null", ""));
            String types = "";
            for (Types type : pokeCard.getTypes()) {
                String stringToConcat = String.format(Locale.US, "%s", type.getDescription());
                stringToConcat = stringToConcat.replace("null", "");
                types = types.concat(stringToConcat);
            }
            viewHolder.typesTextView.setText(types);
        }


        return view;
    }

    private class ViewHolder {
        private final TextView nameTextView;
        private final TextView pokedexNumberTextView;
        private final TextView typesTextView;

        private ViewHolder(View view) {
            nameTextView = view.findViewById(R.id.pokemon_name_textView);
            pokedexNumberTextView = view.findViewById(R.id.pokedex_number_textView);
            typesTextView = view.findViewById(R.id.pokemon_types_textView);
        }
    }
}
