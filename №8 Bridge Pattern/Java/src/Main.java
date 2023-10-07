
interface MovieBooking {
    void bookTicket(int numberOfTickets);
    void cancelBooking();
}

interface MovieBookingSystem {
    void makeBooking(String movie, int numberOfTickets);
    void cancelBooking(String movie);
}

class OnlineBookingSystem implements MovieBookingSystem {
    @Override
    public void makeBooking(String movie, int numberOfTickets) {
        System.out.println("Online booking for " + numberOfTickets + " tickets for " + movie);
    }

    @Override
    public void cancelBooking(String movie) {
        System.out.println("Canceling online booking for " + movie);
    }
}

class BoxOfficeBookingSystem implements MovieBookingSystem {
    @Override
    public void makeBooking(String movie, int numberOfTickets) {
        System.out.println("Box office booking for " + numberOfTickets + " tickets for " + movie);
    }

    @Override
    public void cancelBooking(String movie) {
        System.out.println("Canceling box office booking for " + movie);
    }
}

class MovieBookingImpl implements MovieBooking {
    private MovieBookingSystem bookingSystem;
    private String movie;

    public MovieBookingImpl(MovieBookingSystem bookingSystem, String movie) {
        this.bookingSystem = bookingSystem;
        this.movie = movie;
    }

    @Override
    public void bookTicket(int numberOfTickets) {
        bookingSystem.makeBooking(movie, numberOfTickets);
    }

    @Override
    public void cancelBooking() {
        bookingSystem.cancelBooking(movie);
    }
}

public class Main {
    public static void main(String[] args) {
        MovieBookingSystem onlineBookingSystem = new OnlineBookingSystem();
        MovieBookingSystem boxOfficeBookingSystem = new BoxOfficeBookingSystem();

        MovieBooking onlineBooking = new MovieBookingImpl(onlineBookingSystem, "Пірати карибського моря");
        MovieBooking boxOfficeBooking = new MovieBookingImpl(boxOfficeBookingSystem, "Бетмен");

        onlineBooking.bookTicket(2);
        onlineBooking.cancelBooking();

        boxOfficeBooking.bookTicket(3);
        boxOfficeBooking.cancelBooking();
    }
}
