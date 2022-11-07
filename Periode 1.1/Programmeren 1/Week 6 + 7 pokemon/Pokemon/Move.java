public class Move {
    private String name;
    private String type;
    private int pp;
    private int power;

    public Move(String name, String type, int pp, int power){
        this.name = name;
        this.type = type;
        this.pp = pp;
        this.power = power;

    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", pp=" + pp +
                ", power=" + power + "";

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
