import java.util.ArrayList;

public class Pascal {

    public static void main(String[] args) {
        try {
            ArrayList<Integer> arrayList = new ArrayList<>();
//            System.out.println(formatNumber(3));
            System.out.println(nextRow(nextRow(arrayList)));
//            printPascalTriangle(6);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static String formatNumber(int number) throws Exception {
        return switch (String.valueOf(number).length()) {
            case 1 -> (" " + number + " ");
            case 2 -> (" " + number);
            case 3 -> ("" + number);
            default -> String.valueOf(number);
//            default -> throw new Exception("Too long or short.");
        };
    }

    public static int bottomRowLength(int size) {
        return size * 3 + size - 1;
    }

    public static ArrayList<Integer> nextRow(ArrayList<Integer> previous) {
        ArrayList<Integer> newList = new ArrayList<>();
        newList.add(1);
        for (int j = 0; j < previous.size() - 2; j++) {
            newList.add(previous.get(j + 1) + previous.get(j));
        }
        if (previous.size() > 0) {
            newList.add(1);
        }
        return newList;
    }

//    public static void printPascalTriangle(int size) {
//        ArrayList<Integer> row = new ArrayList<>();
//        for (int i = 0; i < size; i++) {
//            String output = new String();
//            int spaces = (bottomRowLength(i + 1) / 2);
//        }
//
//    }

    public static void printPascalTriangle(int size) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            for (int i = 0; i < size; i++) {
                String output = new String();
                int spaces = (bottomRowLength(size) - bottomRowLength(i + 1) / 2);
                output += " ".repeat(spaces);
                arrayList = nextRow(arrayList);
                for (int j = 0; j < arrayList.size(); j++) {
                    output += formatNumber(arrayList.get(j));
                    if (j < arrayList.size() - 1){
                        output += " ";
                    }
                }
                System.out.println(output);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void printPascalTriangle2(int size) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        String output = "";
        try {
            for (int i = 0; i < size; i++) {
                int spaces = (bottomRowLength(i) - bottomRowLength(i + 1)) / 2;
                output += " ".repeat(spaces);

                System.out.println("");

                arrayList = nextRow(arrayList);
                for (int j = 0; j < size; j++) {
                    output += nextRow(arrayList);
                    for (int e : arrayList) {
//                        System.out.print(formatNumber(e));
                        output += formatNumber(e);
                    }
//                    arrayList.addAll(nextRow(arrayList));

                    System.out.println(output);
                }


            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
