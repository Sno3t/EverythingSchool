public class HydroBottle implements Product {
    private String barcode;
    private double capacity; // mm
    private String colour;
    private final String name = "HydroBottle";

    public HydroBottle(String barcode) {
        this.barcode = barcode;
    }

    public double getCapacity() {
        return capacity;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public String getIdentifier() {
        return barcode;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getBrand() {
        return null;
    }

    @Override
    public String toString() {
        return "ID: " + getIdentifier() + " Name: " + name + " Capacity: " + capacity + "mm Colour: " + getColour();
    }
}
