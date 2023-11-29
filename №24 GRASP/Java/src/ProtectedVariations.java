//У цьому прикладі використовується інтерфейс TicketBookingSystem, який дозволяє класу Client взаємодіяти
// з різними реалізаціями системи бронювання квитків, забезпечуючи захист від змін в конкретній реалізації.
// Клас Client взаємодіє з інтерфейсом, а не конкретною реалізацією, що дозволяє легко змінювати та
// замінювати реалізації системи бронювання квитків.

interface TicketBookingSystem {
    void bookTicket(String movieTitle, String time, int numSeats);
    void cancelTicket(String movieTitle, String time, int numSeats);
}


class MovieTicketBookingSystems implements TicketBookingSystem {
    @Override
    public void bookTicket(String movieTitle, String time, int numSeats) {
        System.out.println(numSeats + " seats booked for " + movieTitle + " at " + time);
    }

    @Override
    public void cancelTicket(String movieTitle, String time, int numSeats) {
        System.out.println(numSeats + " seats cancelled for " + movieTitle + " at " + time);
    }
}


class Client {
    private TicketBookingSystem ticketBookingSystem;

    public Client(TicketBookingSystem ticketBookingSystem) {
        this.ticketBookingSystem = ticketBookingSystem;
    }

    public void bookTicket(String movieTitle, String time, int numSeats) {
        ticketBookingSystem.bookTicket(movieTitle, time, numSeats);
    }

    public void cancelTicket(String movieTitle, String time, int numSeats) {
        ticketBookingSystem.cancelTicket(movieTitle, time, numSeats);
    }
}

public class ProtectedVariations {
    public static void main(String[] args) {
        TicketBookingSystem movieTicketBookingSystem = new MovieTicketBookingSystems();
        Client client = new Client(movieTicketBookingSystem);
        client.bookTicket("Avengers: Endgame", "19:00", 2);
        client.cancelTicket("Avengers: Endgame", "19:00", 2);
    }
}

