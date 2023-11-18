import java.util.ArrayList;
import java.util.List;

interface MovieBookingSubject {
    void registerObserver(MovieBookingObserver observer);
    void removeObserver(MovieBookingObserver observer);
    void notifyObservers();
}

class MovieBooking implements MovieBookingSubject {
    private String movieName;
    private int numberOfTickets;
    private final List<MovieBookingObserver> observers;

    public MovieBooking() {
        observers = new ArrayList<>();
    }

    public void setMovieAndTickets(String movieName, int numberOfTickets) {
        this.movieName = movieName;
        this.numberOfTickets = numberOfTickets;
        notifyObservers();
    }

    @Override
    public void registerObserver(MovieBookingObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(MovieBookingObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (MovieBookingObserver observer : observers) {
            observer.update(movieName, numberOfTickets);
        }
    }
}

interface MovieBookingObserver {
    void update(String movieName, int numberOfTickets);
}

class User implements MovieBookingObserver {
    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String movieName, int numberOfTickets) {
        System.out.println("Hi " + userName + "! Movie: " + movieName + ", Tickets: " + numberOfTickets);
    }
}

public class Main {
    public static void main(String[] args) {
        MovieBooking movieBooking = new MovieBooking();

        User user1 = new User("Alice");
        User user2 = new User("Bob");

        movieBooking.registerObserver(user1);
        movieBooking.registerObserver(user2);

        movieBooking.setMovieAndTickets("Avengers: Endgame", 5);
        movieBooking.setMovieAndTickets("Spider-Man: No Way Home", 3);
        movieBooking.removeObserver(user2);
        movieBooking.setMovieAndTickets("The Matrix Resurrections", 2);
    }
}
