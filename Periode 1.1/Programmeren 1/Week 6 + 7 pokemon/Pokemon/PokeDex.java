import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PokeDex {
    private String name;
    private int level;
    private int experience;
    private int healthPoints;
    private String type;
    private ArrayList<Move> moves = new ArrayList<Move>();

    public PokeDex(String name, int level, int experience, int healthPoints, String type) {
        this.name = name;
        this.level = level;
        this.experience = experience;
        this.healthPoints = healthPoints;
        this.type = type;
    }

    public PokeDex(String name, String type) {
        this(name, 1, 0, 10, type);
    }

    @Override
    public String toString() {
        return "PokeDex{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", experience=" + experience +
                ", healthPoints=" + healthPoints +
                ", type='" + type + '\'' +
                ", moves=" + moves +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }

    public void addMove(Move move) {
        if (moves.size() < 4) {
            this.moves.add(move);
        } else if (moves.size() == 4) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Choose a move to replace, 1 through 4");
            for (int i = 0; i < 4; i++) {
                System.out.println((i + 1) + " " + this.moves.get(i).getName());
            }

            int replace = Integer.parseInt(scanner.nextLine());

            if (replace > 4) {
                System.out.println("Not a valid type");
            } else {
                System.out.println("Congratulations, " + this.moves.get(replace - 1).getName() + " has been replaced with " + move.getName() + "!");
                this.moves.remove(replace - 1);
                this.moves.add(move);
            }
        }
    }

    public void addExperience(int amount) {
        this.experience += amount;
    }

    public void damage(int damage) {
        this.healthPoints -= damage;
    }

    public void useAttackOn(PokeDex opponent, Move move) {
        opponent.setHealthPoints(opponent.getHealthPoints() - move.getPower());
    }

    public void forgetAttack() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose one to remove");
        for (int i = 0; i < this.moves.size(); i++) {
            System.out.println((i + 1) + " " + this.moves.get(i).getName());
        }

        int replace = Integer.parseInt(scanner.nextLine());

        if (replace > this.moves.size()) {
            System.out.println("Not a valid type");
        } else {
            this.moves.remove(replace - 1);
        }
    }

    public boolean isFainted() {
        return this.healthPoints <= 0;
    }

    public void levelUp() {
        if (experience % 20 == 1) {
            this.level++;
            System.out.println(this.name + " leveled up! It is now level " + this.level + ".");
        }
    }

//    public void writeToFile() throws IOException {
//        Scanner scanner = new Scanner(Paths.get("PokeList.txt"));
//
//        try {
//            FileWriter myWriter = new FileWriter("filename.txt");
//            myWriter.write(this.name);
//            myWriter.write(this.type);
//            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//
//    }

    public void readFromFile() throws IOException {
        File f = new File("PokeList.csv");
        Scanner scanner = null;
        if (f.exists() && !f.isDirectory()) {
            scanner = new Scanner(new File("PokeList.csv"));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] splitLine = line.split(",");
                new PokeDex(splitLine[0], splitLine[1]);
            }
            scanner.close();
        }
    }
}
