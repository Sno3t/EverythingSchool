package Thermos;

public class Button {
    private float temptNow;
    private Room room;

    public Button(Room room) {
        this.room = room;
    }

    public boolean isOn() {
        return temptNow > room.getTemptGoal();
    }

    
    @Override
    public String toString() {
        if (isOn()){
            return "Verwarming is aan, temperatuur is " + temptNow;
        } else {
            return "Verwarming is uit, temperatuur is " + temptNow;
        }
    }
}
