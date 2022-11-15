public class ColouredRubberDuck extends RubberDuck {
    private String colour;

    public ColouredRubberDuck(String name, String colour) {
        super(name);
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Duck colour: " + colour;
    }
}
