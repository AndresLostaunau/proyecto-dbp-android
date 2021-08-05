package com.example.myapplication.ui.data.entities;

public class Inventory {
    String client_name;
    String game_name;

    public Inventory(String client_name, String game_name) {
        this.client_name = client_name;
        this.game_name = game_name;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }
}
