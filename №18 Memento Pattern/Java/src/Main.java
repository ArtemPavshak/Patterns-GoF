
record MovieBookingMemento(String movieName, int numberOfTickets) {
}

class MovieBooking {
    private String movieName;
    private int numberOfTickets;

    public void setMovieAndTickets(String movieName, int numberOfTickets) {
        this.movieName = movieName;
        this.numberOfTickets = numberOfTickets;
    }

    public MovieBookingMemento saveToMemento() {
        return new MovieBookingMemento(movieName, numberOfTickets);
    }

    public void restoreFromMemento(MovieBookingMemento memento) {
        this.movieName = memento.movieName();
        this.numberOfTickets = memento.numberOfTickets();
    }

    public void display() {
        System.out.println("Movie: " + movieName + ", Tickets: " + numberOfTickets);
    }
}

class MovieBookingCareTaker {
    private MovieBookingMemento memento;

    public void saveState(MovieBookingMemento memento) {
        this.memento = memento;
    }

    public MovieBookingMemento retrieveState() {
        return memento;
    }
}

public class Main {
    public static void main(String[] args) {
        MovieBooking movieBooking = new MovieBooking();
        MovieBookingCareTaker careTaker = new MovieBookingCareTaker();
        movieBooking.setMovieAndTickets("Avengers: Endgame", 5);
        movieBooking.display();
        careTaker.saveState(movieBooking.saveToMemento());
        movieBooking.setMovieAndTickets("Spider-Man: No Way Home", 3);
        movieBooking.display();
        movieBooking.restoreFromMemento(careTaker.retrieveState());
        movieBooking.display();
    }
}
