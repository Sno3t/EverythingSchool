import java.util.ArrayList;
import java.util.List;

public class Omvormer {
    private int maxVermogen;
    private List<Zonnepaneel> panelen;

    public Omvormer(int maxVermogen) {
        this.maxVermogen = maxVermogen;
        this.panelen = new ArrayList<>();
    }

    public void paneelToevoegen(Zonnepaneel zonnepaneel) {
        panelen.add(zonnepaneel);
    }

    public double berekenVermogen(double stralingWattPerM2) {
        double totaalVermogen = 0;
        for (Zonnepaneel paneel : panelen) {
            totaalVermogen += paneel.berekenVermogen(stralingWattPerM2);
        }
        return Math.min(totaalVermogen, maxVermogen);
    }
}
