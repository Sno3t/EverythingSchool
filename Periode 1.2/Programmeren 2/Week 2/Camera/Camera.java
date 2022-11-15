package Camera;

abstract class Camera {
    private boolean on;
    protected int timesTriggered;
    protected int capacity;

    public Camera(int capacity) {
        this.capacity = capacity;
    }

    public boolean power() {
        return this.on;
    }

    public void trigger() {
        this.timesTriggered++;
    }

    public abstract int calculateStorageLeft();
}
