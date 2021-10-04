package com.example.pokemonapi.api;

import com.example.pokemonapi.models.Pokemonrepuestas;

import retrofit2.Call;

public interface PokemonService {
    Call<Pokemonrepuestas> obtenerListpokemon();
}
