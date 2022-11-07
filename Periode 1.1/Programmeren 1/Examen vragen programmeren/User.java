import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<Clip> clips = new ArrayList<Clip>();

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User " + this.name + ", kudos: " + kudosTotal();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Clip> getClips() {
        return clips;
    }

    public void addClips(Clip clip) {
//        this.clips = clips;
        this.clips.add(clip);
    }

    public int kudosTotal() {
        int kudosTotal = 0;
        for (int i = 0; i < this.clips.size(); i++) {
            kudosTotal += this.clips.get(i).getKudos();

        }
        return kudosTotal;
    }
}

