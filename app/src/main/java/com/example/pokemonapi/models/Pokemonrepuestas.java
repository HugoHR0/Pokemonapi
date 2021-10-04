package com.example.pokemonapi.models;

import java.util.ArrayList;

public class Pokemonrepuestas {
    private ArrayList<Pokemon>results;
    public  ArrayList<Pokemon>getResults(){
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
