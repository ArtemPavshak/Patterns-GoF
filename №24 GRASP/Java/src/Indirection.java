
class TicketService {
    private TicketManager ticketManager;

    public TicketService() {
        this.ticketManager = new TicketManager();
    }

    public Ticket bookTicket(String title, String director, int numberOfTickets, boolean isOnline) {
        return ticketManager.bookTicket(title, director, numberOfTickets, isOnline);
    }

}
public class Indirection {
    public static void main(String[] args) {
        TicketService ticketService = new TicketService();
        Ticket userTicket = ticketService.bookTicket("Inception", "Christopher Nolan", 2, true);
    }
}
