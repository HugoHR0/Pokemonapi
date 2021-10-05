package com.example.pokemonapi.api;

import com.example.pokemonapi.models.Pokemonrepuestas;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokemonService {
    @GET("pokemon")
    Call<Pokemonrepuestas> obtenerListpokemon(@Query("limit")int limit, @Query("offset")int offset);
}
