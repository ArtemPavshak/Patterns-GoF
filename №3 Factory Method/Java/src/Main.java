
public class Main {
    public static void main(String[] args) {
        TicketFactory ticketFactory = new ConcreteTicketFactory();
        Ticket ticket1 = ticketFactory.createTicket("Пірати карибського моря", "17:30 AM");
        ticket1.printTicket();
    }
}
