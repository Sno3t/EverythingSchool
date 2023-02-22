public class Seat {
    private int row;
    private char letter;

    private Ticket ticket;

    public Seat(int row, char letter) {
        this.row = row;
        this.letter = letter;
    }

    public void assign(Ticket ticket){
        this.ticket.setSeat(ticket.getSeat());
    }

    public boolean assigned(){
        return ticket.isCheckedIn();
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }
}
