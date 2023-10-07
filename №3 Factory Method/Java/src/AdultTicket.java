
public class AdultTicket extends Ticket {
    public AdultTicket(String movieName, String showTime) {
        super(movieName, showTime);
    }

    @Override
    public double getPrice() {
        return 10.0;
    }
}
