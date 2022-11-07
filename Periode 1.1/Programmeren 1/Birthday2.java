import java.util.ArrayList;
import java.util.Scanner;

public class Sandbox {
    public static void addBirthday(ArrayList<String>[][] birthdays) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wie is er jarig?");
        String name = scanner.nextLine();

        System.out.println("Op welke dag?");
        int day = Integer.parseInt(scanner.nextLine());

        System.out.println("Welke maand?");
        int month = Integer.parseInt(scanner.nextLine());

        birthdays[month - 1][day - 1] = new ArrayList<>();
        birthdays[month - 1][day - 1].add(name);
    }

    public static void removeBirthday(ArrayList<String>[][] birthdays, String name) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 31; j++) {
                if (birthdays[i][j] != null){
                    birthdays[i][j].remove(name);
                    birthdays[i][j] = null;
                }
            }
        }
    }

    public static void printBirthdays(ArrayList<String>[][] birthdays) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 31; j++) {
                if (birthdays[i][j] != null) {
                    System.out.println(birthdays[i][j]);
                }
            }
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Verjaardagkalender 0.1");

        ArrayList<String>[][] birthdays = new ArrayList[12][31];

        while (true) {
            System.out.println("Kies een optie:");
            System.out.println("1. Verjaardag toevoegen");
            System.out.println("2. Verjaardag verwijderen");
            System.out.println("3. Alle verjaardagen zien");
            int option = Integer.parseInt(scanner.nextLine());

            if (option == 1) {
                addBirthday(birthdays);

            } else if (option == 2) {
                System.out.println("Wie wil je verwijderen?");
                String name = scanner.nextLine();

                removeBirthday(birthdays, name);

            } else if (option == 3) {
                printBirthdays(birthdays);

            } else if (option == 4) {
                break;

            }
        }
    }
}

