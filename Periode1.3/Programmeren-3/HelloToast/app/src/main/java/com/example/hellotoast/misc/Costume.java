package com.example.hellotoast.misc;

public class Costume {
    private int image;
    private String name;
    private String description;
    private double price;
    private boolean isAvailable;

    public Costume(int image,
                   String name,
                   String description,
                   double price,
                   boolean isAvailable) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
