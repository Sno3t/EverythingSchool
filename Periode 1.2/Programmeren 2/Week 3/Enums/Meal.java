public class Meal {
    private final Heat.heat heat;
    private final Size.size size;
    private String name;
    private String description;
    private double price;

    public Meal(String name, String description, double price, Size.size size, Heat.heat heat) { //, size size, heat heat
        this.name = name;
        this.description = description;
        this.price = price;
        this.heat = heat;
        this.size = size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append("\n");
        stringBuilder.append(description);
        stringBuilder.append("\n");
        stringBuilder.append(price);
        stringBuilder.append("\n");
        stringBuilder.append(this.heat);
        stringBuilder.append("\n");
        stringBuilder.append(this.size);
        return stringBuilder.toString();
    }
}
