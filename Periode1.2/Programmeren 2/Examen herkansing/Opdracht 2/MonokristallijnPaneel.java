public class MonokristallijnPaneel extends Zonnepaneel {
    public MonokristallijnPaneel(int lengthInCm, int widthInCm, int capacityInWattPeak, PaneelType paneelType) {
        super(lengthInCm, widthInCm, capacityInWattPeak, paneelType);
    }

    @Override
    public double getRendement() {
        return super.getRendement() * 0.87;
    }
}