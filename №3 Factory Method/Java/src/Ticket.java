
public abstract class Ticket {
    private String movieName;
    private String showTime;

    public Ticket(String movieName, String showTime) {
        this.movieName = movieName;
        this.showTime = showTime;
    }

    public abstract double getPrice();

    public void printTicket() {
        System.out.println("Movie: " + movieName);
        System.out.println("Show Time: " + showTime);
        System.out.println("Price: $" + getPrice());
    }
}
