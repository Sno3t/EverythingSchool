public abstract class Zonnepaneel {
    private int lengthInCm;
    private int widthInCm;
    private int capacityInWattPeak;
    private PaneelType paneelType;

    public Zonnepaneel(int lengthInCm, int widthInCm, int capacityInWattPeak, PaneelType paneelType) {
        this.lengthInCm = lengthInCm;
        this.widthInCm = widthInCm;
        this.capacityInWattPeak = capacityInWattPeak;
        this.paneelType = paneelType;
    }

    public double berekenOppervlakteInM2() {
        return (double) (lengthInCm * widthInCm) / 10000;
    }

    public double getRendement() {
        switch (paneelType) {
            case KUNSTSTOFGLAS:
                return 0.19;
            case GLASGLAS:
                return 0.21;
            default:
                return 0.0;
        }
    }

    public double berekenVermogen(double stralingWattPerM2) {
        return (berekenOppervlakteInM2() * capacityInWattPeak * getRendement() * stralingWattPerM2);
    }

    // Getters and setters
    public int getLengthInCm() {
        return lengthInCm;
    }

    public void setLengthInCm(int lengthInCm) {
        this.lengthInCm = lengthInCm;
    }

    public int getWidthInCm() {
        return widthInCm;
    }

    public void setWidthInCm(int widthInCm) {
        this.widthInCm = widthInCm;
    }

    public int getCapacityInWattPeak() {
        return capacityInWattPeak;
    }

    public void setCapacityInWattPeak(int capacityInWattPeak) {
        this.capacityInWattPeak = capacityInWattPeak;
    }
}
