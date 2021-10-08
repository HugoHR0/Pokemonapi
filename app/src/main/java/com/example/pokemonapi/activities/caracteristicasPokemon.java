package com.example.pokemonapi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.pokemonapi.R;
import com.example.pokemonapi.models.PokemonByIdResponse;
import com.example.pokemonapi.models.PokemonLoader;
import com.example.pokemonapi.utils.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class caracteristicasPokemon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caracteristicas_pokemon);

        String pokemonId = getIntent().getStringExtra(Constant.EXTRA_POKEMON_ID);

        PokemonLoader loader = new PokemonLoader();
        Call<PokemonByIdResponse> call = loader.getPokemonById(pokemonId);

        call.enqueue(new Callback<PokemonByIdResponse>() {
            @Override
            public void onResponse(Call<PokemonByIdResponse> call, Response<PokemonByIdResponse> response) {
                Log.e(Constant.DEBUG_POKEMON, response.body().getName());
            }

            @Override
            public void onFailure(Call<PokemonByIdResponse> call, Throwable t) {
                Log.e(Constant.DEBUG_POKEMON, t.getMessage());

            }
        });
    }
}