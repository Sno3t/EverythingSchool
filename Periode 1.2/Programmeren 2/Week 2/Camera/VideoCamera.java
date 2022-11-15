package Camera;

public class VideoCamera extends Camera {
    private int fps;

    public VideoCamera(int capacity) {
        super(capacity);
    }

    @Override
    public void trigger() {
        super.trigger();
    }

    @Override
    public int calculateStorageLeft() {
        return capacity - (super.timesTriggered * 2);
    }
}
