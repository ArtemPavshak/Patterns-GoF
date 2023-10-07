
public class SeniorTicket extends Ticket {
    public SeniorTicket(String movieName, String showTime) {
        super(movieName, showTime);
    }

    @Override
    public double getPrice() {
        return 7.0;
    }
}
