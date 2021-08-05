package com.example.myapplication.ui.data.entities;

public class Game {
    String name;
    int price;
    String img_link;

    public Game() {}

    public Game(String name, int price, String img_link) {
        this.name = name;
        this.price = price;
        this.img_link = img_link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImg_link() {
        return img_link;
    }

    public void setImg_link(String img_link) {
        this.img_link = img_link;
    }
}
