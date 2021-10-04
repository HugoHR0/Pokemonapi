package com.example.pokemonapi.models;

public class Pokemon {
    private int num;
    private  String name;
    private  String url;

    public int getNum() {
        return num;
    }

    public int setNum(int num) {
        String[] urlParte = url.split("/");
        return Integer.parseInt(urlParte[urlParte.length -1]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
