abstract class MovieBookingTemplate {
    public void bookTicket() {
        selectMovie();
        selectSeats();
        makePayment();
        confirmBooking();
    }

    protected abstract void selectMovie();

    protected abstract void selectSeats();

    protected abstract void makePayment();

    protected void confirmBooking() {
        System.out.println("Booking confirmed!");
    }
}

class MovieBookingProcess extends MovieBookingTemplate {
    private final String movieName;
    private final int numberOfTickets;

    public MovieBookingProcess(String movieName, int numberOfTickets) {
        this.movieName = movieName;
        this.numberOfTickets = numberOfTickets;
    }

    @Override
    protected void selectMovie() {
        System.out.println("Selected Movie: " + movieName);
    }

    @Override
    protected void selectSeats() {
        System.out.println("Selected " + numberOfTickets + " seats.");
    }

    @Override
    protected void makePayment() {
        System.out.println("Payment successful for " + numberOfTickets + " tickets.");
    }
}

public class Main {
    public static void main(String[] args) {

        MovieBookingTemplate bookingProcess = new MovieBookingProcess("Avengers: Endgame", 5);
        bookingProcess.bookTicket();
    }
}
