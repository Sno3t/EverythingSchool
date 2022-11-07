package Thermos;

import java.util.ArrayList;

public class Room {
    private String name;
    private ArrayList<Button> buttons = new ArrayList<Button>();
    private float temptGoal;

    public Room(String name, float temptGoal) {
        this.name = name;
        this.temptGoal = temptGoal;
    }

    public Room(String name) {
        this.name = name;
        this.temptGoal = 18;
    }

    public void addButton(Button button) {
        this.buttons.add(button);
    }

    public ArrayList<Button> getButtons() {
        return buttons;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {

        return this.name + "ingesteld op " + this.temptGoal + " graden." +
                buttons;
    }
}
