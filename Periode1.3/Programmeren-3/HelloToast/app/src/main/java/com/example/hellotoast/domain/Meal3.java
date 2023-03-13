package com.example.hellotoast.domain;

import java.util.ArrayList;
import java.util.Date;

public class Meal3 {

    private int mId;
    private String mName;
    private String mDescription;

    private Boolean mIsActive;
    private Boolean mIsVega;
    private Boolean mIsVegan;

    // Afhalen ja/nee
    private Boolean mIsToTakeHome;

    // Datum en tijd waarop de Meal beschikbaar is.
    private Date mDateTime;

    // Max aantal deelnemers
    private int mMaxAmountOfParticipants;

    private double mPrice;

    // Url link naar online afbeelding van Meal
    private String mImageUrl;

    // Allergenen
    private ArrayList<String> mAllergenes;

    // Namen van deelnemers
    private ArrayList<String> mParticipants;

    private Meal3(Builder builder){
        this.mId = builder.mId;
        this.mName = builder.mName;
        this.mDescription = builder.mDescription;
        this.mIsActive = builder.mIsActive;
        this.mIsVega = builder.mIsVega;
        this.mIsVegan = builder.mIsVegan;
        this.mIsToTakeHome = builder.mIsToTakeHome;
        this.mDateTime = builder.mDateTime;
        this.mMaxAmountOfParticipants = builder.mMaxAmountOfParticipants;
        this.mPrice = builder.mPrice;
        this.mImageUrl = builder.mImageUrl;
        this.mAllergenes = builder.mAllergenes;
        this.mParticipants = builder.mParticipants;
    }

    /**
     * Interne Builder class - we gebruiken het Builder Pattern.
     */
    public static class Builder {
        private int mId = 0;
        private String mName;
        private String mDescription;
        private Boolean mIsActive = false;
        private Boolean mIsVega = false;
        private Boolean mIsVegan = false;
        private Boolean mIsToTakeHome = false;
        private Date mDateTime = new Date();
        private int mMaxAmountOfParticipants = 0;
        private double mPrice;
        private String mImageUrl = "";
        private ArrayList<String> mAllergenes = new ArrayList<>();
        private ArrayList<String> mParticipants = new ArrayList<>();

        /**
         * Constructor van interne class, heeft beperkt aantal attributen!
         */
        public Builder(String mName, String mDescription, double mPrice) {
            this.mName = mName;
            this.mDescription = mDescription;
            this.mPrice = mPrice;
        }

        public Builder setIsActive(Boolean mIsActive) {
            this.mIsActive = mIsActive;
            return this;
        }

        public Builder setIsVega(Boolean mIsVega) {
            this.mIsVega = mIsVega;
            return this;
        }

        public Builder setIsVegan(Boolean mIsVegan) {
            this.mIsVegan = mIsVegan;
            return this;
        }

        public Builder setIsToTakeHome(Boolean mIsToTakeHome) {
            this.mIsToTakeHome = mIsToTakeHome;
            return this;
        }

        public Builder setMaxAmountOfParticipants(int mMaxAmountOfParticipants) {
            this.mMaxAmountOfParticipants = mMaxAmountOfParticipants;
            return this;
        }

        public Builder setImageUrl(String mImageUrl) {
            this.mImageUrl = mImageUrl;
            return this;
        }

        public Builder setAllergenes(ArrayList<String> mAllergenes) {
            this.mAllergenes = mAllergenes;
            return this;
        }

        public Builder setParticipants(ArrayList<String> mParticipants) {
            this.mParticipants = mParticipants;
            return this;
        }

        public Meal3 build() {
            return new Meal3(this);
        }
    }

    /**
     * Getters, hiermee kun je in je Activity attributen uit de Meal ophalen.
     */
    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public Boolean getIsActive() {
        return mIsActive;
    }

    public Boolean getIsVega() {
        return mIsVega;
    }

    public Boolean getIsVegan() {
        return mIsVegan;
    }

    public Boolean getIsToTakeHome() {
        return mIsToTakeHome;
    }

    public Date getDateTime() {
        return mDateTime;
    }

    public int getMaxAmountOfParticipants() {
        return mMaxAmountOfParticipants;
    }

    public double getPrice() {
        return mPrice;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public ArrayList<String> getAllergenes() {
        return mAllergenes;
    }

    public ArrayList<String> getParticipants() {
        return mParticipants;
    }

    public void setMaxAmountOfParticipants(int mMaxAmountOfParticipants) {
        this.mMaxAmountOfParticipants = mMaxAmountOfParticipants;
    }

    /**
     * Setters om, nadat een object gebuild is, nog attributen te veranderen.
     */


    @Override
    public String toString() {
        return "Meal {" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mMaxAmountOfParticipants=" + mMaxAmountOfParticipants +
                ", mPrice=" + mPrice +
                '}';
    }
}
