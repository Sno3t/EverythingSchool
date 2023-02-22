import java.util.ArrayList;
public class Clip {
    private String name;
    private int kudos;
    private User uploader;
    private ArrayList<String> tags = new ArrayList<>();
    private ArrayList<Comment> comments = new ArrayList<Comment>();

    public Clip(String name, User uploader) {
        this.name = name;
        this.uploader = uploader;
        this.kudos = 0;
        uploader.addClips(this);
    }

    @Override
    public String toString() {
        return "Clip name: " + name + ", kudos: " + kudos + ", uploader: " + uploader + ". With the tags: " + tags + ", and comments: " + comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKudos() {
        return kudos;
    }

    public void setKudos(int kudos) {
        this.kudos = kudos;
    }

    public void addKudos(int kudos) {
        this.kudos += kudos;
    }

    public void removeKudos(int kudos) {
        this.kudos -= kudos;
    }

    public void addKudo() {
        this.kudos++;
    }

    public void removeKudo() {
        this.kudos--;
    }

    public User getUploader() {
        return uploader;
    }

    public void setUploader(User uploader) {
        this.uploader = uploader;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    public void addTags(ArrayList<String> tags) {
        this.tags.addAll(tags);
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public void addComments(ArrayList<Comment> comments) {
        this.comments.addAll(comments);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

}
