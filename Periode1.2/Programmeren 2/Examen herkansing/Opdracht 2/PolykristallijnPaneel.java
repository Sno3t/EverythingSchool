public class PolykristallijnPaneel extends Zonnepaneel {
    public PolykristallijnPaneel(int lengthInCm, int widthInCm, int capacityInWattPeak, PaneelType paneelType) {
        super(lengthInCm, widthInCm, capacityInWattPeak, paneelType);
    }

    @Override
    public double getRendement() {
        return super.getRendement() * 0.85;
    }

    @Override
    public double berekenVermogen(double stralingWattPerM2) {
        return (0.95 * super.berekenVermogen(stralingWattPerM2));
    }
}