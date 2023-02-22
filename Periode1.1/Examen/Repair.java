import java.util.ArrayList;
import java.util.Scanner;

public class Repair {
    public static void main(String[] args) {

    }


    public char changeChar(char character) {
        return switch (character) {
            case 'q' -> 'a';
            case 'w' -> 'z';
            case 'a' -> 'q';
            case 'z' -> 'w';
            case 'm' -> ';';
            case ';' -> 'm';
            default -> character;
        };
    }

    public void changeString(String text) {
        char[] charArray = text.toCharArray();
        for (int i = 0; i < text.toCharArray().length; i++) {
            charArray[i] = changeChar(text.charAt(i));
        }
    }

    public void reverse(String text) {
        int length;
        for (length = text.length(); length > 0; --length) {

            System.out.print(text.charAt(length - 1));
        }

    }
}
