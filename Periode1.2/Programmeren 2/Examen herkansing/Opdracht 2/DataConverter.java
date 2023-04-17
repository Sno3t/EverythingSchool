import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DataConverter {
    private String filenameInstraling;
    private Omvormer omvormer;

    public DataConverter(String filenameInstraling, Omvormer omvormer) {
        this.filenameInstraling = filenameInstraling;
        this.omvormer = omvormer;
    }

    public void verwerkData(String fileNameVermogen) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filenameInstraling));
            FileWriter writer = new FileWriter(fileNameVermogen);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                LocalDateTime dateTime = LocalDateTime.parse(parts[0], DateTimeFormatter.ofPattern("d-M-yyyy HH:mm:ss"));
                double straling = Double.parseDouble(parts[1]);

                double vermogen = omvormer.berekenVermogen(straling);
                String formattedDateTime = dateTime.format(DateTimeFormatter.ofPattern("d-M-yyyy HH:mm:ss"));
                String outputLine = formattedDateTime + ";" + vermogen + "\n";
                writer.write(outputLine);
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("Fout bij het verwerken van data: " + e.getMessage());
        }
    }
}

