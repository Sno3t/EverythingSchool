package Ducks;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        RubberDuck rubberDuck = new RubberDuck("RubberDuck");
        ColouredRubberDuck redDuck = new ColouredRubberDuck("RedDuck", "red");
        CostumedRubberDuck fancyDuck = new CostumedRubberDuck("Elegenat Duck", "Tuxedo");

        ArrayList<RubberDuck> duckies = new ArrayList<RubberDuck>();
        duckies.add(rubberDuck);
        duckies.add(redDuck);
        duckies.add(fancyDuck);

        for (RubberDuck duck : duckies) {
            duck.squeeze();
        }
    }
}

