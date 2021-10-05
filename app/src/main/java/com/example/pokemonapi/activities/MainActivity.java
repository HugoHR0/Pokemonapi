package com.example.pokemonapi.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.pokemonapi.ListPokemonsAdapter;
import com.example.pokemonapi.R;
import com.example.pokemonapi.api.PokemonService;
import com.example.pokemonapi.models.Pokemon;
import com.example.pokemonapi.models.Pokemonrepuestas;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private static  final String TAG = "POKEMONAPI";
    private RecyclerView recyclerView;
    private ListPokemonsAdapter listPokemonsAdapter;

    private  int offset;
    private boolean listoParaCargar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewM); //verfificar variable?
        listPokemonsAdapter = new ListPokemonsAdapter(this);
        recyclerView.setAdapter(listPokemonsAdapter);
        recyclerView.setHasFixedSize(true);

        final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if(dy > 0){
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisebleItems = layoutManager.findFirstVisibleItemPosition();

                    if(listoParaCargar){
                        if ((visibleItemCount+ pastVisebleItems) >= totalItemCount){
                            Log.i(TAG, ("Has llegado al fina"));
                            listoParaCargar = false;
                            offset+= 20;
                            obtenerDatos(offset);

                        }
                    }

                }
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        listoParaCargar = true;
        offset = 0;
        obtenerDatos(offset);


    }

    private void obtenerDatos(int offset){
        PokemonService service = retrofit.create(PokemonService.class);
        Call<Pokemonrepuestas> pokemonRespuestasCall = service.obtenerListpokemon(20,offset);

        pokemonRespuestasCall.enqueue(new Callback<Pokemonrepuestas>() {
            @Override
            public void onResponse(Call<Pokemonrepuestas> call, Response<Pokemonrepuestas> response) {
                listoParaCargar = true;
                if(response.isSuccessful()){
                    Pokemonrepuestas pokemonrepuestas = response.body();
                    ArrayList<Pokemon>listaPokemon = pokemonrepuestas.getResults();
                    listPokemonsAdapter.adicionaListaPokemon(listaPokemon);
                }else {
                    Log.e(TAG, "on response "+ response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Pokemonrepuestas> call, Throwable t) {
                listoParaCargar = true;
                Log.e(TAG, "on failure"+ t.getMessage());

            }
        });
    }
}