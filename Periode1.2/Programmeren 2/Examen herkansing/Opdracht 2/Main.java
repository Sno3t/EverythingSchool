public class Main {
    public static void main(String[] args) {
        // Aanmaken van zonnepanelen
        Zonnepaneel polyPaneel = new PolykristallijnPaneel(100, 100, 300, PaneelType.GLASGLAS);
        Zonnepaneel amorfPaneel = new AmorfePaneel(100, 50, 150, PaneelType.KUNSTSTOFGLAS);

        // Aanmaken van omvormer
        Omvormer omvormer = new Omvormer(1000);

        // Toevoegen van zonnepanelen aan omvormer
        omvormer.paneelToevoegen(polyPaneel);
        omvormer.paneelToevoegen(amorfPaneel);

        // Verwerken van data en wegschrijven naar bestand
        DataConverter dataConverter = new DataConverter("instraling.txt", omvormer);
        dataConverter.verwerkData("vermogen.txt");
    }
}
