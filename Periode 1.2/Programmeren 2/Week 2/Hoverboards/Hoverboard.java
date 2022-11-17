public class Hoverboard implements Product {
    private String id;
    private String type;
    private String brand;
    private final String name = "Hoverboard";

    public Hoverboard(String id, String type, String brand) {
        this.id = id;
        this.type = type;
        this.brand = brand;
    }

    @Override
    public String getIdentifier() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ID: " + getIdentifier() + " Name: " + getName() + " Type: " + getType() + " Brand: " + getBrand();
    }
}

