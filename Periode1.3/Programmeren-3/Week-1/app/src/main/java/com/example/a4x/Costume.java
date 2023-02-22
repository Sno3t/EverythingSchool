package com.example.a4x;

public class Costume {

    public Costume(int image, String name, String description, double price, boolean isAvailable) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    private  final String TAG = CostumeListAdaptar.CostumeViewHolder.class.getSimpleName();
    private int image;
    private String name;
    private String description;
    private double price;
    private boolean isAvailable;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
