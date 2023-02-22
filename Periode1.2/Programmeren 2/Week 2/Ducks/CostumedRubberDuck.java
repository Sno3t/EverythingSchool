package Ducks;

public class CostumedRubberDuck extends RubberDuck {

    private String costume;

    public CostumedRubberDuck(String name, String costume) {
        super(name);
        this.costume = costume;
    }

    @Override
    public void squeeze() {
        System.out.println("Kwak");
    }

    @Override
    public String toString() {
        return "Ducky costume: " + costume;
    }
}
