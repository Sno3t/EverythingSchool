import java.util.ArrayList;

public class Flight extends Storage {

    private String flightCode;
    private char[] seatLetters;
    private int numberOfRows;

    private ArrayList<Ticket> tickets;

    private ArrayList<Seat> seats;

    public Flight(String flightCode, char[] seatLetters, int numberOfRows) {
        this.flightCode = flightCode;
        this.seatLetters = seatLetters;
        this.numberOfRows = numberOfRows;

        for (int i = 0; i < seatLetters.length; i++) { // Opdracht e (Stoelen automatisch toevoegen)
            for (int j = 0; j < numberOfRows; j++) {
                seats.add(new Seat(j, seatLetters[i]));
            }
        }


    }

    public int numbersOfSeats() {
        return seatLetters.length * numberOfRows;
    }

    public Seat nextAvailable() {
        for (int i = 0; i < seats.size(); i++) {
            if (!seats.get(i).assigned()) {
                return seats.get(i);
            }
        }
        return null;
    }


    public int availableSeats() {
        return numbersOfSeats() - seats.size();
    }

//    public boolean addTicket(String name) {
//        return seats.get(0).assign(new Ticket(flightCode, name, seats.get(0)));
//    }
}
