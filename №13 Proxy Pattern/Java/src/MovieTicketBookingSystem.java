
interface MovieTicket {
    void buyTicket();
}

class RealMovieTicket implements MovieTicket {
    private String movieName;

    public RealMovieTicket(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public void buyTicket() {
        System.out.println("Purchased a ticket for the movie: " + movieName);
    }
}

class MovieTicketProxy implements MovieTicket {
    private RealMovieTicket realMovieTicket;
    private int age;

    public MovieTicketProxy(String movieName, int age) {
        this.realMovieTicket = new RealMovieTicket(movieName);
        this.age = age;
    }

    @Override
    public void buyTicket() {
        if (age < 18) {
            System.out.println("Sorry, you are too young to buy a ticket for this movie.");
        } else {
            realMovieTicket.buyTicket();
        }
    }
}

public class MovieTicketBookingSystem {
    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicketProxy("Avengers: Endgame", 16);
        ticket.buyTicket();

        MovieTicket adultTicket = new MovieTicketProxy("Inception", 25);
        adultTicket.buyTicket();
    }
}
