import java.util.HashMap;
import java.util.Map;

interface MovieFlyweight {
    void bookSeat(int seatNumber);
}

class Movie implements MovieFlyweight {
    private final String title;
    private String genre;
    private int duration;
    private String theater;

    public Movie(String title, String genre, int duration, String theater) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.theater = theater;
    }

    @Override
    public void bookSeat(int seatNumber) {
        System.out.println("Booking seat #" + seatNumber + " for movie: " + title);
    }
}

class MovieFactory {
    private final Map<String, MovieFlyweight> movies = new HashMap<>();

    public MovieFlyweight getMovie(String title, String genre, int duration, String theater) {
        String key = title + theater;
        if (!movies.containsKey(key)) {
            Movie movie = new Movie(title, genre, duration, theater);
            movies.put(key, movie);
        }
        return movies.get(key);
    }
}

public class MovieBookingSystem {
    public static void main(String[] args) {
        MovieFactory factory = new MovieFactory();

        MovieFlyweight movie1 = factory.getMovie("Пірати карибського моря", "Екшен", 150, "CinemaCity");
        MovieFlyweight movie2 = factory.getMovie("Аватар", "Екшен", 150, "SmartCinema");
        MovieFlyweight movie3 = factory.getMovie("Барбі", "Комедія", 162, "StarMax");

        movie1.bookSeat(1);
        movie2.bookSeat(2);
        movie3.bookSeat(3);
    }
}
