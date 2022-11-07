package Thermos;

import static java.lang.Math.abs;

public class Location {
    private double latitude;
    private double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double distance(double latitude, double longitude) {
        return abs(latitude - longitude) + abs(this.latitude - this.longitude);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
