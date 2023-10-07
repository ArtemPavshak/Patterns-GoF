import java.util.ArrayList;
import java.util.List;
class MovieTicketResource {
    private final String movieName;
    private final String theaterName;
    private final String showTime;
    private final int numberOfTickets;

    public MovieTicketResource(String movieName, String theaterName, String showTime, int numberOfTickets) {
        this.movieName = movieName;
        this.theaterName = theaterName;
        this.showTime = showTime;
        this.numberOfTickets = numberOfTickets;
    }

    @Override
    public String toString() {
        return "Movie: " + movieName + "\n" +
                "Theater: " + theaterName + "\n" +
                "Show Time: " + showTime + "\n" +
                "Number of Tickets: " + numberOfTickets;
    }
}

class MovieTicketResourcePool {
    private final List<MovieTicketResource> pool;
    private final int maxPoolSize;

    public MovieTicketResourcePool(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
        this.pool = new ArrayList<>(maxPoolSize);
    }

    public MovieTicketResource acquireResource(String movieName, String theaterName, String showTime, int numberOfTickets) {
        if (pool.isEmpty()) {
            return createResource(movieName, theaterName, showTime, numberOfTickets);
        } else {
            return pool.remove(0);
        }
    }

    public void releaseResource(MovieTicketResource resource) {
        if (pool.size() < maxPoolSize) {
            pool.add(resource);
        }
    }

    private MovieTicketResource createResource(String movieName, String theaterName, String showTime, int numberOfTickets) {
        return new MovieTicketResource(movieName, theaterName, showTime, numberOfTickets);
    }
}

public class MovieBookingSystem {
    public static void main(String[] args) {
        MovieTicketResourcePool resourcePool = new MovieTicketResourcePool(5);

        MovieTicketResource ticket1 = resourcePool.acquireResource("Пірати карибського моря", "Кінотеатр Starmax", "19:00", 2);
        System.out.println("Ticket 1:\n" + ticket1);

        MovieTicketResource ticket2 = resourcePool.acquireResource("Барбі", "Кінотеатр Starmax", "14:30", 3);
        System.out.println("Ticket 2:\n" + ticket2);

        resourcePool.releaseResource(ticket1);
        resourcePool.releaseResource(ticket2);
    }
}
