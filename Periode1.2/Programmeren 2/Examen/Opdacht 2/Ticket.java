public class Ticket implements Incheckable {
    private String ticketNumber;
    private String name;
    private boolean checkedIn;
    private Seat seat;

    public Ticket(String number, String name, Seat seat) {
        this.ticketNumber = number;
        this.name = name;
        this.seat = seat;
    }

    @Override
    public void checkin() { // Opdacht g
        if (checkedIn){
            System.out.println("Error already checked in.");
        } else {
            checkedIn = true;
        }
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

