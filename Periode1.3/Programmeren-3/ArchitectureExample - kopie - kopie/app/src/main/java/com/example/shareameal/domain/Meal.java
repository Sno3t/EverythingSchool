package com.example.shareameal.domain;

//import androidx.room.Entity;
//import androidx.room.Ignore;
//import androidx.room.PrimaryKey;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//
//@Entity(tableName = "meal_table")
//public class Meal {
//
//    @PrimaryKey(autoGenerate = true)
//    private int mId;
//    private String mName;
//    private String mDescription;
//    private Boolean mIsActive;
//    private Boolean mIsVega;
//    private Boolean mIsVegan;
//
//    // Afhalen ja/nee
//    private Boolean mIsToTakeHome;
//
//    // Datum en tijd waarop de Meal beschikbaar is.
//
//    private String mDateTime;
////    @Ignore
////    private Date mDateTime;
//
//    // Max aantal deelnemers
//    private int mMaxAmountOfParticipants;
//
//    private double mPrice;
//
//    // Url link naar online afbeelding van Meal
//    private String mImageUrl;
//    // Allergenen
//    @Ignore
//    private ArrayList<String> mAllergenes;
//
//    // Namen van deelnemers
//    @Ignore
//    private ArrayList<String> mParticipants;
//
//    public Meal(String name, String description, Boolean isActive, Boolean isVega, Boolean isVegan, Boolean isToTakeHome, String mDateTime, int maxAmountOfParticipants, double price, String imageUrl) {
//        this.mName = name;
//        this.mDescription = description;
//        this.mIsActive = isActive;
//        this.mIsVega = isVega;
//        this.mIsVegan = isVegan;
//        this.mIsToTakeHome = isToTakeHome;
//        this.mDateTime = mDateTime;
//        this.mMaxAmountOfParticipants = maxAmountOfParticipants;
//        this.mPrice = price;
//        this.mImageUrl = imageUrl;
//    }
//
//
//    public Meal(Builder builder) {
//        this.mId = builder.mId;
//        this.mName = builder.mName;
//        this.mDescription = builder.mDescription;
//        this.mIsActive = builder.mIsActive;
//        this.mIsVega = builder.mIsVega;
//        this.mIsVegan = builder.mIsVegan;
//        this.mIsToTakeHome = builder.mIsToTakeHome;
//        this.mDateTime = builder.mDateTime;
//        this.mMaxAmountOfParticipants = builder.mMaxAmountOfParticipants;
//        this.mPrice = builder.mPrice;
//        this.mImageUrl = builder.mImageUrl;
//        this.mAllergenes = builder.mAllergenes;
//        this.mParticipants = builder.mParticipants;
//    }
//
//    public Meal(String name, String description, Boolean isActive, Boolean isVega, Boolean isVegan, Boolean isToTakeHome,
//                //Date date
//            String date, int maxAmountOfParticipants, double price, String imageUrl, ArrayList<String> allergenes, ArrayList<String> participants) {
//        this.mName = name;
//        this.mDescription = description;
//        this.mIsActive = isActive;
//        this.mIsVega = isVega;
//        this.mIsVegan = isVegan;
//        this.mIsToTakeHome = isToTakeHome;
//        this.mDateTime = date;
//        this.mMaxAmountOfParticipants = maxAmountOfParticipants;
//        this.mPrice = price;
//        this.mImageUrl = imageUrl;
//        this.mAllergenes = allergenes;
//        this.mParticipants = participants;
//
//    }
//
//    public void setId(int id) {
//        this.mId = id;
//    }
//
////    public Meal(String name, String description, Boolean isActive, Boolean isVega, Boolean isVegan, Boolean isToTakeHome, Date date, int maxAmountOfParticipants, double price, String imageUrl, ArrayList<String> allergenes, ArrayList<String> participants) {
////    }
////    private Meal(Builder builder){
////        this.mId = builder.mId;
////        this.mName = builder.mName;
////        this.mDescription = builder.mDescription;
////        this.mIsActive = builder.mIsActive;
////        this.mIsVega = builder.mIsVega;
////        this.mIsVegan = builder.mIsVegan;
////        this.mIsToTakeHome = builder.mIsToTakeHome;
////        this.mDateTime = builder.mDateTime;
////        this.mMaxAmountOfParticipants = builder.mMaxAmountOfParticipants;
////        this.mPrice = builder.mPrice;
////        this.mImageUrl = builder.mImageUrl;
////        this.mAllergenes = builder.mAllergenes;
////        this.mParticipants = builder.mParticipants;
////    }
//
//    /**
//     * Interne Builder class - we gebruiken het Builder Pattern.
//     */
//    public static class Builder {
//        private int mId = 0;
//        private String mName;
//        private String mDescription;
//        private Boolean mIsActive = false;
//        private Boolean mIsVega = false;
//        private Boolean mIsVegan = false;
//        private Boolean mIsToTakeHome = false;
//
//        private String mDateTime;
//        //private Date mDateTime = new Date();
//        private int mMaxAmountOfParticipants = 0;
//        private double mPrice;
//        private String mImageUrl = "";
//        private ArrayList<String> mAllergenes = new ArrayList<>();
//        private ArrayList<String> mParticipants = new ArrayList<>();
//
//        /**
//         * Constructor van interne class, heeft beperkt aantal attributen!
//         */
//        public Builder(String mName, String mDescription, double mPrice) {
//            this.mName = mName;
//            this.mDescription = mDescription;
//            this.mPrice = mPrice;
//        }
//
//        public Builder setIsActive(Boolean mIsActive) {
//            this.mIsActive = mIsActive;
//            return this;
//        }
//
//        public Builder setIsVega(Boolean mIsVega) {
//            this.mIsVega = mIsVega;
//            return this;
//        }
//
//        public Builder setIsVegan(Boolean mIsVegan) {
//            this.mIsVegan = mIsVegan;
//            return this;
//        }
//
//        public Builder setIsToTakeHome(Boolean mIsToTakeHome) {
//            this.mIsToTakeHome = mIsToTakeHome;
//            return this;
//        }
//
//        public Builder setMaxAmountOfParticipants(int mMaxAmountOfParticipants) {
//            this.mMaxAmountOfParticipants = mMaxAmountOfParticipants;
//            return this;
//        }
//
//        public Builder setImageUrl(String mImageUrl) {
//            this.mImageUrl = mImageUrl;
//            return this;
//        }
//
//        public Builder setAllergenes(ArrayList<String> mAllergenes) {
//            this.mAllergenes = mAllergenes;
//            return this;
//        }
//
//        public Builder setParticipants(ArrayList<String> mParticipants) {
//            this.mParticipants = mParticipants;
//            return this;
//        }
//
//        public Meal build() {
//            return new Meal(this);
//        }
//    }
//
//    /**
//     * Getters, hiermee kun je in je Activity attributen uit de Meal ophalen.
//     */
//    public int getId() {
//        return mId;
//    }
//
//    public String getName() {
//        return mName;
//    }
//
//    public String getDescription() {
//        return mDescription;
//    }
//
//    public Boolean getIsActive() {
//        return mIsActive;
//    }
//
//    public Boolean getIsVega() {
//        return mIsVega;
//    }
//
//    public Boolean getIsVegan() {
//        return mIsVegan;
//    }
//
//    public Boolean getIsToTakeHome() {
//        return mIsToTakeHome;
//    }
//
//
//
//    public String getDateTime() {
//        return mDateTime;
//    }
//    //public Date getDateTime() {
//    //    return mDateTime;
//    //}
//
//    public int getMaxAmountOfParticipants() {
//        return mMaxAmountOfParticipants;
//    }
//
//    public double getPrice() {
//        return mPrice;
//    }
//
//    public String getImageUrl() {
//        return mImageUrl;
//    }
//
//    public ArrayList<String> getAllergenes() {
//        return mAllergenes;
//    }
//
//    public ArrayList<String> getParticipants() {
//        return mParticipants;
//    }
//
//
//
//    public void setMaxAmountOfParticipants(int mMaxAmountOfParticipants) {
//        this.mMaxAmountOfParticipants = mMaxAmountOfParticipants;
//    }
//
//    /**
//     * Setters om, nadat een object gebuild is, nog attributen te veranderen.
//     */
//
//
//    @Override
//    public String toString() {
//        return "Meal {" +
//                "mId=" + mId +
//                ", mName='" + mName + '\'' +
//                ", mDescription='" + mDescription + '\'' +
//                ", mMaxAmountOfParticipants=" + mMaxAmountOfParticipants +
//                ", mPrice=" + mPrice +
//                '}';
//    }
//}

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "meal_table")
public class Meal {
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

    private Meal(Builder builder){
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
                ", isActive=" + isActive +"\n" +
                ", isVega=" + isVega +"\n" +
                ", isVegan=" + isVegan +"\n" +
                ", isToTakeHome=" + isToTakeHome +"\n" +
                ", dateTime='" + dateTime + '\'' +"\n" +
                ", createDate='" + createDate + '\'' +"\n" +
                ", updateDate='" + updateDate + '\'' +"\n" +
                ", maxAmountOfParticipants=" + maxAmountOfParticipants +"\n" +
                ", price='" + price + '\'' +"\n" +
                ", imageUrl='" + imageUrl + '\'' +"\n" +
                ", allergenes=" + allergenes +"\n" +
                ", cook=" + cook.getFirstName() + " " + cook.getLastName() +"\n" +
                ", participants=" + participants +"\n" +
                '}';
    }
}

