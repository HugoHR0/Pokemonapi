package com.example.pokemonapi.models;

import com.google.gson.annotations.SerializedName;

public class Sprite {
    @SerializedName("back_default")
    private String image;

    public String getImage() {
        return image;
    }
}
