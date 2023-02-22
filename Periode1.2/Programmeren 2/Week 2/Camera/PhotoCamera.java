package Camera;

public class PhotoCamera extends Camera {
    private boolean hdrEnabled;

    public PhotoCamera(int capacity, boolean hdrEnabled) {
        super(capacity);
        this.hdrEnabled = hdrEnabled;
    }

    @Override
    public int calculateStorageLeft() {
        return capacity - (super.timesTriggered * 20);
    }
}
