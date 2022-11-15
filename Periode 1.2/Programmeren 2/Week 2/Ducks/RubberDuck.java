public class RubberDuck {
    private String name;
    protected String sound;

    public RubberDuck(String name) {
        this.name = name;
    }

    public void squeeze() {
        System.out.println("Squeek");
    }

    @Override
    public String toString() {
        return "Rubberduck name: " + name;
    }
}
