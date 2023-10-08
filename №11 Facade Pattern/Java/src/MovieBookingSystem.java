import java.util.ArrayList;
import java.util.List;

record Movie(String title) {
}

record Theater(String theaterName) {
}

class PaymentService {
    public boolean makePayment(double amount) {
        return true;
    }
}

class NotificationService {
    public void sendConfirmation(String message) {
        System.out.println("Notification: " + message);
    }
}

class MovieBookingFacade {
    private final PaymentService paymentService;
    private final NotificationService notificationService;

    public MovieBookingFacade() {
        this.paymentService = new PaymentService();
        this.notificationService = new NotificationService();
    }

    public void bookMovieTickets(List<Movie> movies, Theater theater) {
        for (Movie movie : movies) {
            System.out.println("Booking movie ticket for: " + movie.title() + " at " + theater.theaterName());

            double ticketPrice = 12.0;
            boolean paymentSuccessful = paymentService.makePayment(ticketPrice);

            if (paymentSuccessful) {
                notificationService.sendConfirmation("Movie ticket booked for: " + movie.title() + " at " + theater.theaterName());
                System.out.println("Booking successful!");
            } else {
                System.out.println("Payment failed. Booking canceled.");
            }
            System.out.println();
        }
    }
}

public class MovieBookingSystem {
    public static void main(String[] args) {
        List<Movie> moviesToBook = new ArrayList<>();
        moviesToBook.add(new Movie("Пірати карибського моря"));
        moviesToBook.add(new Movie("Матриця"));
        moviesToBook.add(new Movie("Аватар"));

        Theater cinemaCity = new Theater("CinemaCity");
        Theater movieMax = new Theater("MovieMax");

        MovieBookingFacade movieBookingFacade = new MovieBookingFacade();

        System.out.println("Booking movies at CinemaCity:");
        movieBookingFacade.bookMovieTickets(moviesToBook, cinemaCity);

        System.out.println("Booking movies at MovieMax:");
        movieBookingFacade.bookMovieTickets(moviesToBook, movieMax);
    }
}
