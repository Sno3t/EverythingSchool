import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Birthday {

    public static ArrayList addBirthday() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> birthday = new ArrayList<>();

        System.out.println("Wie is er jarig?");
//        String name = scanner.nextLine();
        birthday.add(scanner.nextLine());

        System.out.println("Op welke dag?");
//        String day = scanner.nextLine();
        birthday.add(scanner.nextLine());

        System.out.println("Welke maand?");
//        String month = scanner.nextLine();
        birthday.add(scanner.nextLine());

//        newArrayList(name,day,month));

        return birthday;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Verjaardagkalender 0.1");

        ArrayList<String> birthdays = new ArrayList<>();

//        String[][] birthdays = new String[][];

//        for (int i = 0; i < names.length; i++) {
//            for (int j = 0; j < names[i].length; j++) {
//                System.out.println(names[i][j]);
//            }
//        }

        boolean check = true;
        while (check) {
            System.out.println("Kies een optie:");
            System.out.println("1. Verjaardag toevoegen");
            System.out.println("2. Verjaardag verwijderen");
            System.out.println("3. Alle verjaardagen zien");
            int option = Integer.parseInt(scanner.nextLine());

            if (option == 1) {
                birthdays.add(addBirthday());
//                continue;

            } else if (option == 2) {
                System.out.println(birthdays);
                System.out.println("Welke wil je verwijderen?");
                String choice = scanner.nextLine();
                birthdays.remove(choice);

            } else if (option == 3) {
                System.out.println(birthdays);
            }
        }
    }
}
//            else if (option.equals("")) {
//                check = false;
//            }

