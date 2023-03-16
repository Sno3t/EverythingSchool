package com.example.hellotoast.domain;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Date;

@Entity(tableName = "meal_table")
public class Meal {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @NonNull
    @ColumnInfo(name = "description")
    private String description;

    @NonNull
    @ColumnInfo(name = "isActive")
    private Boolean isActive;

    @NonNull
    @ColumnInfo(name = "isVega")
    private Boolean isVega;

    @NonNull
    @ColumnInfo(name = "isVegan")
    private Boolean isVegan;

    @NonNull
    @ColumnInfo(name = "isToTakeHome")
    // Afhalen ja/nee
    private Boolean isToTakeHome;

    @NonNull
    @ColumnInfo(name = "dateTime")
    // Datum en tijd waarop de Meal beschikbaar is.
    private Long dateTime;

    @NonNull
    @ColumnInfo(name = "maxAmountOfParticipants")
    // Max aantal deelnemers
    private int maxAmountOfParticipants;

    @NonNull
    @ColumnInfo(name = "price")
    private double price;

    @NonNull
    @ColumnInfo(name = "imageUrl")
    // Url link naar online afbeelding van Meal
    private String imageUrl;

    @NonNull
    @ColumnInfo(name = "allergenes")
    // Allergenen
    private ArrayList<String> allergenes;

    @NonNull
    @ColumnInfo(name = "participants")
    // Namen van deelnemers
    private ArrayList<String> participants;

    public Meal() {

    }

    public Meal(Builder builder) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isActive = isActive;
        this.isVega = isVega;
        this.isVegan = isVegan;
        this.isToTakeHome = isToTakeHome;
        this.dateTime = dateTime;
        this.maxAmountOfParticipants = maxAmountOfParticipants;
        this.price = price;
        this.imageUrl = imageUrl;
        this.allergenes = allergenes;
        this.participants = participants;
    }

    /**
     * Interne Builder class - we gebruiken het Builder Pattern.
     */
    public static class Builder {
        private int id = 0;
        private String name;
        private String description;
        private Boolean isActive = false;
        private Boolean isVega = false;
        private Boolean isVegan = false;
        private Boolean isToTakeHome = false;
        private Date dateTime = new Date();
        private int maxAmountOfParticipants = 0;
        private double price;
        private String imageUrl = "";
        private ArrayList<String> allergenes = new ArrayList<>();
        private ArrayList<String> participants = new ArrayList<>();

        /**
         * Constructor van interne class, heeft beperkt aantal attributen!
         */
        public Builder(String name, String description, double price) {
            this.name = name;
            this.description = description;
            this.price = price;
        }

        public Builder setIsActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder setIsVega(Boolean isVega) {
            this.isVega = isVega;
            return this;
        }

        public Builder setIsVegan(Boolean isVegan) {
            this.isVegan = isVegan;
            return this;
        }

        public Builder setIsToTakeHome(Boolean isToTakeHome) {
            this.isToTakeHome = isToTakeHome;
            return this;
        }

        public Builder setMaxAmountOfParticipants(int maxAmountOfParticipants) {
            this.maxAmountOfParticipants = maxAmountOfParticipants;
            return this;
        }

        public Builder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder setAllergenes(ArrayList<String> allergenes) {
            this.allergenes = allergenes;
            return this;
        }

        public Builder setParticipants(ArrayList<String> participants) {
            this.participants = participants;
            return this;
        }

        public Meal build() {
            return new Meal(this);
        }
    }

    /**
     * Getters, hiermee kun je in je Activity attributen uit de Meal ophalen.
     */
    public int getId() {
        return id;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    public void setActive(@NonNull Boolean active) {
        isActive = active;
    }

    public void setVega(@NonNull Boolean vega) {
        isVega = vega;
    }

    public void setVegan(@NonNull Boolean vegan) {
        isVegan = vegan;
    }

    public void setToTakeHome(@NonNull Boolean toTakeHome) {
        isToTakeHome = toTakeHome;
    }

    public void setDateTime(@NonNull Long dateTime) {
        this.dateTime = dateTime;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImageUrl(@NonNull String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setAllergenes(@NonNull ArrayList<String> allergenes) {
        this.allergenes = allergenes;
    }

    public void setParticipants(@NonNull ArrayList<String> participants) {
        this.participants = participants;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public Boolean getIsVega() {
        return isVega;
    }

    public Boolean getIsVegan() {
        return isVegan;
    }

    public Boolean getIsToTakeHome() {
        return isToTakeHome;
    }

    public Long getDateTime() {
        return dateTime;
    }

    public int getMaxAmountOfParticipants() {
        return maxAmountOfParticipants;
    }

    public double getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ArrayList<String> getAllergenes() {
        return allergenes;
    }

    public ArrayList<String> getParticipants() {
        return participants;
    }

    public void setMaxAmountOfParticipants(int maxAmountOfParticipants) {
        this.maxAmountOfParticipants = maxAmountOfParticipants;
    }

    /**
     * Setters om, nadat een object gebuild is, nog attributen te veranderen.
     */

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Meal {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", maxAmountOfParticipants=" + maxAmountOfParticipants +
                ", price=" + price +
                '}';
    }
}
