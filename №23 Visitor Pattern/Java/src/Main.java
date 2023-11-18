
interface Visitor {
    void visit(MovieBooking movieBooking);
}


class BookingAnalyzer implements Visitor {
    @Override
    public void visit(MovieBooking movieBooking) {
        System.out.println("Analyzing movie booking: " + movieBooking);
    }
}

interface Element {
    void accept(Visitor visitor);
}

class MovieBooking implements Element {
    private final String movieName;
    private final int numberOfTickets;

    public MovieBooking(String movieName, int numberOfTickets) {
        this.movieName = movieName;
        this.numberOfTickets = numberOfTickets;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getMovieName() {
        return movieName;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    @Override
    public String toString() {
        return "Movie: " + movieName + ", Tickets: " + numberOfTickets;
    }
}

public class Main {
    public static void main(String[] args) {
        MovieBooking movieBooking1 = new MovieBooking("Avengers: Endgame", 3);
        MovieBooking movieBooking2 = new MovieBooking("Spider-Man: No Way Home", 5);

        Visitor analyzer = new BookingAnalyzer();
        movieBooking1.accept(analyzer);
        movieBooking2.accept(analyzer);
    }
}
