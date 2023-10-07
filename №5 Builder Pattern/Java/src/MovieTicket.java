public class MovieTicket {
    private final String movieName;
    private final String theaterName;
    private final String showTime;
    private final int numberOfTickets;

    private MovieTicket(Builder builder) {
        this.movieName = builder.movieName;
        this.theaterName = builder.theaterName;
        this.showTime = builder.showTime;
        this.numberOfTickets = builder.numberOfTickets;
    }

    public static class Builder {
        private final String movieName;
        private final String theaterName;
        private String showTime = "13:00";
        private int numberOfTickets = 1;

        public Builder(String movieName, String theaterName) {
            this.movieName = movieName;
            this.theaterName = theaterName;
        }

        public Builder showTime(String showTime) {
            this.showTime = showTime;
            return this;
        }

        public Builder numberOfTickets(int numberOfTickets) {
            this.numberOfTickets = numberOfTickets;
            return this;
        }

        public MovieTicket build() {
            return new MovieTicket(this);
        }
    }

    @Override
    public String toString() {
        return "Movie: " + movieName + "\n" +
                "Theater: " + theaterName + "\n" +
                "Show Time: " + showTime + "\n" +
                "Number of Tickets: " + numberOfTickets;
    }

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket.Builder("Пірати Карибського моря", "Кінотеатр Starmax")
                .showTime("19:30")
                .numberOfTickets(5)
                .build();
        MovieTicket ticket2 = new MovieTicket.Builder("Барбі", "Кінотеатр Starmax")
                .showTime("14:30")
                .numberOfTickets(2)
                .build();

        System.out.println(ticket);
        System.out.println("\n");
        System.out.println(ticket2);
    }
}
