package com.example.pokemonapi.models;

import com.google.gson.annotations.SerializedName;

public class Abilities {
    private Ability ability;
    @SerializedName("is_hiden")
    private boolean isHiden;
    private int slot;

    public Ability getAbility() {
        return ability;
    }

    public boolean isHiden() {
        return isHiden;
    }

    public int getSlot() {
        return slot;
    }

    class Ability {

        private String name;
        private String url;

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
}
