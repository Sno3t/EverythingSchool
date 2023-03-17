package com.example.shareameal.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.List;

@Entity(tableName = "meal_table")
public class Meal implements Serializable, Parcelable {
    @PrimaryKey
    private int id;
    private String name;
    private String description;
    private boolean isActive;
    private boolean isVega;
    private boolean isVegan;
    private boolean isToTakeHome;
    private String dateTime;
    private String createDate;
    private String updateDate;
    private int maxAmountOfParticipants;
    private Double price;
    private String imageUrl;
    @Ignore
    private List<String> allergenes;
    private User cook;
    @Ignore
    private List<User> participants;

    public Meal(int id, String name, String description, boolean isActive, boolean isVega, boolean isVegan, boolean isToTakeHome, String dateTime, String createDate, String updateDate, int maxAmountOfParticipants, Double price, String imageUrl, User cook) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isActive = isActive;
        this.isVega = isVega;
        this.isVegan = isVegan;
        this.isToTakeHome = isToTakeHome;
        this.dateTime = dateTime;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.maxAmountOfParticipants = maxAmountOfParticipants;
        this.price = price;
        this.imageUrl = imageUrl;
//        this.allergenes = allergenes;
        this.cook = cook;
//        this.participants = participants;
    }

    private Meal(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.isActive = builder.isActive;
        this.isVega = builder.isVega;
        this.isVegan = builder.isVegan;
        this.isToTakeHome = builder.isToTakeHome;
        this.dateTime = builder.dateTime;
        this.createDate = builder.createDate;
        this.updateDate = builder.updateDate;
        this.maxAmountOfParticipants = builder.maxAmountOfParticipants;
        this.price = builder.price;
        this.imageUrl = builder.imageUrl;
        this.allergenes = builder.allergenes;
        this.participants = builder.participants;
        this.cook = builder.cook;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeDouble(this.price);
        parcel.writeString(this.dateTime);
        parcel.writeBoolean(this.isVega);
        parcel.writeBoolean(this.isActive);
        parcel.writeBoolean(this.isToTakeHome);
        parcel.writeBoolean(this.isVegan);
//        parcel.writeInt(this.participants);

        parcel.writeInt(this.maxAmountOfParticipants);
        parcel.writeStringList(this.allergenes);
        parcel.writeString(this.imageUrl);
    }

    protected Meal(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.price = in.readDouble();
        this.dateTime = in.readString();
        this.isVega = in.readBoolean();
        this.isActive = in.readBoolean();
        this.isToTakeHome = in.readBoolean();
        this.isVegan = in.readBoolean();
//        this.participants = in.readInt();
        this.maxAmountOfParticipants = in.readInt();
        this.allergenes = in.createStringArrayList();
        this.imageUrl = in.readString();
    }

    public static final Creator<Meal> CREATOR = new Creator<Meal>() {
        @Override
        public Meal createFromParcel(Parcel source) {
            return new Meal(source);
        }

        @Override
        public Meal[] newArray(int size) {
            return new Meal[size];
        }
    };

    public static class Builder {
        private int id;
        private String name;
        private String description;
        private Boolean isActive;
        private Boolean isVega;
        private Boolean isVegan;
        private Boolean isToTakeHome;
        private String dateTime;
        private String createDate;
        private String updateDate;
        private int maxAmountOfParticipants;
        private double price;
        private String imageUrl;
        private List<String> allergenes;
        private List<User> participants;
        private User cook;

        public Builder(String name, String description, double price, User cook) {
            this.name = name;
            this.description = description;
            this.price = price;
            this.cook = cook;
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

        public Builder setAllergenes(List<String> allergenes) {
            this.allergenes = allergenes;
            return this;
        }

        public Builder setParticipants(List<User> participants) {
            this.participants = participants;
            return this;
        }

        public Meal build() {
            return new Meal(this);
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isVega() {
        return isVega;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public boolean isToTakeHome() {
        return isToTakeHome;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public int getMaxAmountOfParticipants() {
        return maxAmountOfParticipants;
    }

    public Double getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<String> getAllergenes() {
        return allergenes;
    }

    public User getCook() {
        return cook;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setVega(boolean vega) {
        isVega = vega;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public void setToTakeHome(boolean toTakeHome) {
        isToTakeHome = toTakeHome;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public void setMaxAmountOfParticipants(int maxAmountOfParticipants) {
        this.maxAmountOfParticipants = maxAmountOfParticipants;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setAllergenes(List<String> allergenes) {
        this.allergenes = allergenes;
    }

    public void setCook(User cook) {
        this.cook = cook;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", name='" + name + '\'' + "\n" +
                ", description='" + description + '\'' + "\n" +
                ", isActive=" + isActive + "\n" +
                ", isVega=" + isVega + "\n" +
                ", isVegan=" + isVegan + "\n" +
                ", isToTakeHome=" + isToTakeHome + "\n" +
                ", dateTime='" + dateTime + '\'' + "\n" +
                ", createDate='" + createDate + '\'' + "\n" +
                ", updateDate='" + updateDate + '\'' + "\n" +
                ", maxAmountOfParticipants=" + maxAmountOfParticipants + "\n" +
                ", price='" + price + '\'' + "\n" +
                ", imageUrl='" + imageUrl + '\'' + "\n" +
                ", allergenes=" + allergenes + "\n" +
                ", cook=" + cook.getFirstName() + " " + cook.getLastName() + "\n" +
                ", participants=" + participants + "\n" +
                '}';
    }
}

