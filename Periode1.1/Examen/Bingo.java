import java.util.ArrayList;
import java.util.Scanner;

public class Bingo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> number = new ArrayList<>();
        while (true) {
            int answer = Integer.parseInt(scanner.nextLine());
            if (answer == -1) {
                break;
            }
            number.add(answer);
            indexBingo(number);
        }
    }


    public static void indexBingo(ArrayList<Integer> number) {
        int counter = 0;
        ArrayList<Integer> bingoNumbers = new ArrayList<>();
        int bingoSum = 0;
        for (int i = 0; i < number.size(); i++) {
            if (i == number.get(i)) {
                bingoNumbers.add(i);
                counter++;
            }
            if (counter == 5) {
                break;
            }
        }
        if (counter == 5) {
            for (Integer bingoNumber : bingoNumbers) {
                bingoSum += bingoNumber;
            }

            System.out.print(bingoNumbers.get(0) + ", ");
            System.out.print(bingoNumbers.get(1) + ", ");
            System.out.print(bingoNumbers.get(2) + ", ");
            System.out.print(bingoNumbers.get(3) + ", ");
            System.out.print(bingoNumbers.get(4) + " ");

            System.out.println("BINGO ");
            System.out.println(bingoSum);
            System.exit(0);
        }
    }
}
