package Camera;

public class TestCamera {
    public static void main(String[] args) {
        Camera videoCamera = new VideoCamera(200);
        Camera photoCamera = new PhotoCamera(100, true);

        photoCamera.trigger();
        System.out.println(photoCamera.timesTriggered);
        System.out.println(photoCamera.calculateStorageLeft());
    }


}
