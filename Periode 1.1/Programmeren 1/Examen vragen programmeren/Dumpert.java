import java.util.ArrayList;

public class Dumpert {

    public static void main(String[] args) {

        User jack = new User("Jack");
        User chen = new User("Chen");
        User yuuka = new User("Yuuka");


        Clip clip1 = new Clip("Doing a backflip", jack);

        ArrayList<String> tags = new ArrayList<>();
        tags.add("Awesomeness");
        tags.add("backflip");
        tags.add("Slight miscalculation");

        clip1.addTags(tags);


        Comment CommentChen = new Comment("You suck at this", chen);
        Comment CommentYuuka = new Comment("Loser", yuuka);
        Comment CommentJack = new Comment("Shut up you people are mean!", jack);

        clip1.addComment(CommentChen);
        clip1.addComment(CommentYuuka);
        clip1.addComment(CommentJack);

        clip1.addKudo(); // Jack
        clip1.removeKudo(); // Chen
        clip1.removeKudo(); // Yuuka

        System.out.println(clip1);

        ArrayList<Clip> clips = new ArrayList<>();
        Clip clip2 = new Clip("Playing with my sketdecks", jack);
        Clip clip3 = new Clip("Jumping in the water", jack);
        clips.add(clip2);
        clips.add(clip3);

        System.out.println(clips);
    }
}
