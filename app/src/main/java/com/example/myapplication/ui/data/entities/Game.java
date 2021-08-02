package com.example.myapplication.ui.data.entities;

public class Game {
    Long id;
    String name;
    int price;
    String img_link;

    public Game(Long id, String name, int price, String img_link) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img_link = img_link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
