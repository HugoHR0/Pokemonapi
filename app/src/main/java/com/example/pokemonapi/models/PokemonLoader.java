package com.example.pokemonapi.models;

import com.example.pokemonapi.api.PokemonService;
import com.example.pokemonapi.models.PokemonByIdResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PokemonLoader implements PokemonService {
    PokemonService pokemonService;
    final String URL_BASE = "https://pokeapi.co/api/v2/";

    public PokemonLoader(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        pokemonService = retrofit.create(PokemonService.class);
    }
    @Override
    public Call<Pokemonrepuestas> obtenerListpokemon(int limit, int offset) {
        return null;
    }

    @Override
    public Call<PokemonByIdResponse> getPokemonById(String id) {

        return pokemonService.getPokemonById(id);
    }


}
