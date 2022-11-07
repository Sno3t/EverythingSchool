package Thermos;

public class User {
    private String name;
    private Location location;

    public User(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public User(String name) {
        this.name = name;
    }

    public boolean isAtLocation(User user) {
        return this.location.distance(user.location.getLatitude(), getLocation().getLongitude()) > 0.01;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
