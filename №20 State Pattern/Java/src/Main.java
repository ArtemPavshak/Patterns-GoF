
interface BookingState {
    void bookTicket();
    void cancelBooking();
    void refundTicket();
}

class PendingState implements BookingState {
    private final MovieBooking context;

    public PendingState(MovieBooking context) {
        this.context = context;
    }

    @Override
    public void bookTicket() {
        System.out.println("Ticket booked successfully!");
        context.setCurrentState(new ConfirmedState(context));
    }

    @Override
    public void cancelBooking() {
        System.out.println("Booking canceled.");
        context.setCurrentState(new CancelledState());
    }

    @Override
    public void refundTicket() {
        System.out.println("Cannot refund ticket as the booking is pending.");
    }
}

class ConfirmedState implements BookingState {
    private final MovieBooking context;

    public ConfirmedState(MovieBooking context) {
        this.context = context;
    }

    @Override
    public void bookTicket() {
        System.out.println("Ticket already booked.");
    }

    @Override
    public void cancelBooking() {
        System.out.println("Booking canceled.");
        context.setCurrentState(new CancelledState());
    }

    @Override
    public void refundTicket() {
        System.out.println("Refunding ticket...");
        context.setCurrentState(new PendingState(context));
    }
}

class CancelledState implements BookingState {
    public CancelledState() {
    }

    @Override
    public void bookTicket() {
        System.out.println("Cannot book ticket as the booking is cancelled.");
    }

    @Override
    public void cancelBooking() {
        System.out.println("Booking already cancelled.");
    }

    @Override
    public void refundTicket() {
        System.out.println("Ticket is already cancelled, no refund available.");
    }
}

class MovieBooking {
    private BookingState currentState;

    public MovieBooking() {
        currentState = new PendingState(this);
    }

    public void setCurrentState(BookingState state) {
        currentState = state;
    }

    public void bookTicket() {
        currentState.bookTicket();
    }

    public void cancelBooking() {
        currentState.cancelBooking();
    }

    public void refundTicket() {
        currentState.refundTicket();
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        MovieBooking movieBooking = new MovieBooking();

        movieBooking.bookTicket();
        movieBooking.cancelBooking();
        movieBooking.bookTicket();
        movieBooking.refundTicket();
        movieBooking.refundTicket();
        movieBooking.cancelBooking();
    }
}
