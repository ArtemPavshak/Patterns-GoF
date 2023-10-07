
public class ChildTicket extends Ticket {
    public ChildTicket(String movieName, String showTime) {
        super(movieName, showTime);
    }

    @Override
    public double getPrice() {
        return 5.0;
    }
}
