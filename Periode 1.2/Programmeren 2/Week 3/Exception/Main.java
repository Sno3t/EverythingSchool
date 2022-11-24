public class Main {
    static void checkAge(int age) throws Exception{
        if (age < 18){
            throw new Exception("You are not old enough");
        } else {
            System.out.println("You are old enough");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(15);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
