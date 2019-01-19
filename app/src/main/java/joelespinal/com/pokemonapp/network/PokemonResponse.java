package joelespinal.com.pokemonapp.network;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import joelespinal.com.pokemonapp.model.PokeCard;


public class PokemonResponse {

    @SerializedName("cards")
    private List<PokeCardDTO> pokeCardDTOS;

    public PokemonResponse(List<PokeCardDTO> pokeCardDTOS) {
        this.pokeCardDTOS = pokeCardDTOS;
    }

    public List<PokeCardDTO> getPokeCardDTOS() {
        return pokeCardDTOS;
    }

    public List<PokeCard> getPockeCards() {
        List<PokeCard> pokeCards = new ArrayList<>();
        if(pokeCardDTOS==null)
            return pokeCards;
        for (PokeCardDTO pokeCardDTO : pokeCardDTOS) {
            pokeCards.add(pokeCardDTO.getPockeCard());
        }

        return pokeCards;
    }
}
