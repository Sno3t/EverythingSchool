import java.util.Scanner;

public class Sandbox {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the numer 1, 2 or 3");
        int ans = Integer.parseInt(scanner.nextLine());
        if (ans == 1) {
            System.out.println("Computerhacker Thomas A. Anderson komt op een vreemde manier in contact met Morpheus. Hij leidt Thomas binnen in de `echte', maar ongekende wereld. De wereld die we kennen is volgens Morpheus een virtuele wereld, de Matrix genaamd.");
        } else if (ans == 2) {
            System.out.println("Op een nacht wordt het weesmeisje Sophie uit haar bed geplukt en ontvoerd door een reus. Gelukkig voor haar is het de Grote Vriendelijke Reus, de GVR, die geen vlieg kwaad doet. Er zijn echter andere reuzen, die nog veel groter zijn dan de GVR en zij hebben het wel op weeskinderen gemunt om ze op te peuzelen.");

        } else if (ans == 3) {
            System.out.println("Astro Boy is ontworpen door een briljante wetenschapper, die de robot met superkrachten ontwierp na het overlijden van zijn zoon. Astro Boy is dan ook naar zijn gelijkenis ontworpen. Omdat Astro Boy niet kan voorkomen dat zijn geestelijk vader het verdriet van zijn overleden zoon vergeet, loopt hij weg.");
        } else {
            System.out.println("Not the right number");
            System.exit(0);
        }

        System.out.println("Welke film is dit?");
        String movieAns = scanner.nextLine();

        if (ans == 1) {
            if (movieAns.equalsIgnoreCase("Matrix")) {
                System.out.println("You guessed the correct movie");
            } else {
                System.out.println("The correct answer was The Matrix");
            }
        } else if (ans == 2) {
            if (movieAns.equalsIgnoreCase("Big Friendly Giant")) {
                System.out.println("You guessed the correct movie");
            } else {
                System.out.println("The correct answer was The Big Friendly Giant");
            }
        } else if (ans == 3) {
            if (movieAns.equalsIgnoreCase("Astro Boy")) {
                System.out.println("You guessed the correct movie");
            } else {
                System.out.println("The correct answer was Astro Boy");
            }
        }

    }
}
