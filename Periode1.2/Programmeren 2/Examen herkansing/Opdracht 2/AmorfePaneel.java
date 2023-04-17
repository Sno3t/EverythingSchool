public class AmorfePaneel extends Zonnepaneel {
    public AmorfePaneel(int lengthInCm, int widthInCm, int capacityInWattPeak, PaneelType paneelType) {
        super(lengthInCm, widthInCm, capacityInWattPeak, paneelType);
    }

    @Override
    public double berekenVermogen(double stralingWattPerM2) {
        return (0.75 * super.berekenVermogen(stralingWattPerM2));
    }
}