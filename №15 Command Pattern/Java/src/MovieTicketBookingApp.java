import java.util.ArrayList;
import java.util.List;

interface TicketBookingCommand {
    void execute();
}

class MovieTicketBooking {
    public void bookTicket(String movieName) {
        System.out.println("Ticket booked for the movie: " + movieName);
    }
}

class BookTicketCommand implements TicketBookingCommand {
    private MovieTicketBooking movieTicketBooking;
    private String movieName;

    public BookTicketCommand(MovieTicketBooking movieTicketBooking, String movieName) {
        this.movieTicketBooking = movieTicketBooking;
        this.movieName = movieName;
    }

    @Override
    public void execute() {
        movieTicketBooking.bookTicket(movieName);
    }
}

class TicketBookingSystem {
    private List<TicketBookingCommand> commands = new ArrayList<>();

    public void addCommand(TicketBookingCommand command) {
        commands.add(command);
    }

    public void executeCommands() {
        for (TicketBookingCommand command : commands) {
            command.execute();
        }
        commands.clear();
    }
}

public class MovieTicketBookingApp {
    public static void main(String[] args) {
        MovieTicketBooking movieTicketBooking = new MovieTicketBooking();
        TicketBookingSystem bookingSystem = new TicketBookingSystem();

        TicketBookingCommand bookTicket1 = new BookTicketCommand(movieTicketBooking, "Avengers: Endgame");
        TicketBookingCommand bookTicket2 = new BookTicketCommand(movieTicketBooking, "Inception");

        bookingSystem.addCommand(bookTicket1);
        bookingSystem.addCommand(bookTicket2);

        bookingSystem.executeCommands();
    }
}
