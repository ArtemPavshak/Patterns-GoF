
class Movie {
    private String title;
    private String director;

    public Movie(String title, String director) {
        this.title = title;
        this.director = director;
    }

}

class Booking {
    private Movie movie;
    private int numberOfTickets;

    public Booking(Movie movie, int numberOfTickets) {
        this.movie = movie;
        this.numberOfTickets = numberOfTickets;
    }

}

class BookingController {
    public Booking createBooking(String title, String director, int numberOfTickets) {
        Movie movie = new Movie(title, director);
        Booking booking = new Booking(movie, numberOfTickets);
        return booking;
    }
}

public class Controller {
    public static void main(String[] args) {
        BookingController controller = new BookingController();
        Booking userBooking = controller.createBooking("Inception", "Christopher Nolan", 3);
    }
}
