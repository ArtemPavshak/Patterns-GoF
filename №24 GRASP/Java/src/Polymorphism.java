
class Ticket {
    private Movie movie;
    private int numberOfTickets;

    public Ticket(Movie movie, int numberOfTickets) {
        this.movie = movie;
        this.numberOfTickets = numberOfTickets;
    }

    public double calculatePrice() {
        return numberOfTickets * 10.0;
    }

}

class OnlineTicket extends Ticket {
    private String streamingLink;

    public OnlineTicket(Movie movie, int numberOfTickets, String streamingLink) {
        super(movie, numberOfTickets);
        this.streamingLink = streamingLink;
    }
    @Override
    public double calculatePrice() {
        return super.calculatePrice() * 0.8;
    }

}

class TicketManager {
    public Ticket bookTicket(String title, String director, int numberOfTickets, boolean isOnline) {
        Movie movie = new Movie(title, director);
        if (isOnline) {
            return new OnlineTicket(movie, numberOfTickets, "https://example.com/streaming_link");
        } else {
            return new Ticket(movie, numberOfTickets);
        }
    }
}
