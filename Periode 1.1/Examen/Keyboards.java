import java.sql.Array;
import java.util.*;

public class Keyboards {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> qwerty = new ArrayList<>();
        qwerty.add("QWERTYUIOP");
        qwerty.add("ASDFGHJKL");
        qwerty.add("ZXCVBNM");


        ArrayList<ArrayList<String>> keyboards = new ArrayList<>();
        keyboards.add(qwerty);

        String firstKeys = Arrays.toString(new String[6]);
        System.out.println("Voer de eerste 6 karakters op het toetsenbord naast de TAB toets in");
        firstKeys = scanner.nextLine();

        if (matchKeyboard(firstKeys, keyboards) != null) {
            if (checkKeyboard(matchKeyboard(firstKeys, keyboards))) {
                System.out.println("Je toetsenbord heeft de volgende indeling:");
                printKeyboard(matchKeyboard(firstKeys, keyboards));
                printGameKeys(matchKeyboard(firstKeys, keyboards));

            }

        } else {
            System.out.println("Je keyboard is niet geldig");
        }
    }

    public static String formatLetter(String letter) {
        return (letter + " ");
    }

    public static void printKeyboard(ArrayList<String> letters) {


//        for (int i = 0; i < 3; i++) {
////            for (int j = 0; j < qwerty.get(i).toCharArray().length; j++) {
//            char[] charArray = qwerty.get(i).toCharArray();
//            for (int k = 0; k < charArray.length; k++) {
//                charArray[k] = formatLetter(String.valueOf(charArray[i]));
//            }
//
////                qwerty.set(j, formatLetter(String.valueOf(qwerty.get(i).charAt(j))));
//        }


        System.out.println(letters.get(0));
        System.out.println(" " + letters.get(1));
        System.out.println("  " + letters.get(2));
    }

    public static boolean checkKeyboard(ArrayList<String> letters) {
        Set<Integer> alphabet = new HashSet<>(26);
        int count = 0;

        for (String s : letters) {
            for (char c : s.toCharArray()) {
                int n = c - 'a';
                if (n >= 0 && n < 26) {
                    if (alphabet.add(n)) {
                        count += 1;
                    }
                }
            }
        }

        if (count != 26) {
            return false;
        }


        for (String letter : letters) {
            char[] charArray = letter.toCharArray();
            for (char c : charArray) {
                if (!Character.isAlphabetic(c)) {
                    return false;
                }
            }
        }
        return true;
    }


    public static ArrayList<String> matchKeyboard(String firstKeys, ArrayList<ArrayList<String>> keyboards) {
        if (firstKeys.length() != 6) {
            return null;
        }

        for (ArrayList<String> keyboard : keyboards) {
            for (int j = 0; j < keyboard.size(); j++) {
                if (keyboard.get(j).contains(firstKeys)) {
                    return keyboard;
                }
            }
        }
        return null;
    }

    public static void printGameKeys(ArrayList<String> letters) {

        char[] charArray = letters.get(1).toCharArray();
        char[] charArray2 = letters.get(2).toCharArray();

        System.out.println("Om het spel te besturen gebruik je de volgende toetsen: ");
        System.out.println("Naar voren:" + charArray[2]);
        System.out.println("Naar achteren:" + charArray2[2]);
        System.out.println("Naar Links:" + charArray2[1]);
        System.out.println("Naar rechts:" + charArray2[3]);
    }
}
