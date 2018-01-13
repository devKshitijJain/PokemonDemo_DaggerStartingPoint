package in.co.kshitijjain.pokemondemo.api;

import in.co.kshitijjain.pokemondemo.model.PokemonResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokemonService {

    //API Method to get Pokemon
    @GET("/api/v2/pokemon/")
    Call<PokemonResponse> getPokemon(@Query("limit") int limit);
}