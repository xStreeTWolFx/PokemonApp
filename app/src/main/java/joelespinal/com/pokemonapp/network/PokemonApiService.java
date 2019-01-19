package joelespinal.com.pokemonapp.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokemonApiService {

    String GET_CARDS = "v1/cards";

    @GET(GET_CARDS)
    Call<PokemonResponse> getCards(@Query("page") Integer page);

}
