
interface MovieBookingService {
    void bookMovie(String movieName, int numberOfTickets);
}
interface MovieBookingService1 {
    void bookTicket(String movieName, int numberOfTickets);
}

interface MovieBookingService2 {
    void purchaseTicket(String filmTitle, int quantity);
}

class MovieBookingServiceAdapter1 implements MovieBookingService {
    private final MovieBookingService1 service1;
    public MovieBookingServiceAdapter1(MovieBookingService1 service1) {
        this.service1 = service1;
    }
    @Override
    public void bookMovie(String movieName, int numberOfTickets) {
        service1.bookTicket(movieName, numberOfTickets);
    }
}

class MovieBookingServiceAdapter2 implements MovieBookingService {
    private final MovieBookingService2 service2;
    public MovieBookingServiceAdapter2(MovieBookingService2 service2) {
        this.service2 = service2;
    }
    @Override
    public void bookMovie(String movieName, int numberOfTickets) {
        service2.purchaseTicket(movieName, numberOfTickets);
    }
}

class MovieBookingService1Impl implements MovieBookingService1 {
    @Override
    public void bookTicket(String movieName, int numberOfTickets) {
        System.out.println("Booking " + numberOfTickets + " tickets for " + movieName + " using Service 1.");
    }
}

class MovieBookingService2Impl implements MovieBookingService2 {
    @Override
    public void purchaseTicket(String filmTitle, int quantity) {
        System.out.println("Purchasing " + quantity + " tickets for " + filmTitle + " using Service 2.");
    }
}


public class Client {
    public static void main(String[] args) {
        MovieBookingService1 service1 = new MovieBookingService1Impl();
        MovieBookingService2 service2 = new MovieBookingService2Impl();

        MovieBookingService adapter1 = new MovieBookingServiceAdapter1(service1);
        MovieBookingService adapter2 = new MovieBookingServiceAdapter2(service2);

        adapter1.bookMovie("Movie Пірати Карибського Моря", 3);
        adapter2.bookMovie("Movie Бетмен", 2);
    }
}
