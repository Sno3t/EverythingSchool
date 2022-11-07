import java.io.IOException;

public class Pokemon {

    public static void main(String[] args){
//        PokeDex rapidash = new PokeDex("Rapidash", 14, 200, 36, "Fire");
//        rapidash.addMove(new Move("Flamethrower", "Fire", 10, 90));

//        PokeDex haunter = new PokeDex("Haunter", 27, 1400, 120, "Ghost");
//        haunter.addMove(new Move("Shadow Ball", "Ghost", 10, 100));
//        haunter.addMove(new Move("Shadow sneak", "Ghost", 15, 80));
//        haunter.addMove(new Move("Curse", "Ghost", 5, 0));
//        haunter.addMove(new Move("Confuse Ray", "Ghost", 5, 0));
//        haunter.addMove(new Move("Ominous Wind", "Ghost", 25, 60));
//
//        System.out.println(haunter);

//        PokeDex chansey = new PokeDex("Chansey", "Normal");
//        System.out.println(chansey);

        PokeDex pokeDex = new PokeDex("clefairy", "Normal");
        try {
            pokeDex.readFromFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

