import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Meal spaghetti = new Meal("spaghetti", "Long strings", 5.50, Size.size.Medium, Heat.heat.Warm);
        Meal croissant = new Meal("croissant", "French bread", 1.20, Size.size.Small, Heat.heat.Cold);

//        System.out.println(spaghetti.toString());

        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("maaltijden.csv"));

            while (scanner.hasNext()){
                stringBuilder.append(scanner.nextLine()).append("\n");
            }
            System.out.println(stringBuilder.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
