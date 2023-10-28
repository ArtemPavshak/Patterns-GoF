import java.util.Scanner;

class MovieTicketRequest {
    private final String movieName;
    private final int age;
    private final boolean paymentCompleted;

    public MovieTicketRequest(String movieName, int age, boolean paymentCompleted) {
        this.movieName = movieName;
        this.age = age;
        this.paymentCompleted = paymentCompleted;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getAge() {
        return age;
    }

    public boolean isPaymentCompleted() {
        return paymentCompleted;
    }
}

interface TicketBookingHandler {
    void setNextHandler(TicketBookingHandler nextHandler);
    void handleRequest(MovieTicketRequest request);
}

class AgeCheckingHandler implements TicketBookingHandler {
    private TicketBookingHandler nextHandler;

    @Override
    public void setNextHandler(TicketBookingHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(MovieTicketRequest request) {
        if (request.getAge() >= 18) {
            System.out.println("Age is OK. Proceeding to the next check.");
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            }
        } else {
            System.out.println("Sorry, you are too young to book this ticket.");
        }
    }
}

class PaymentCheckingHandler implements TicketBookingHandler {
    private TicketBookingHandler nextHandler;

    @Override
    public void setNextHandler(TicketBookingHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(MovieTicketRequest request) {
        if (request.isPaymentCompleted()) {
            System.out.println("Payment is completed. Ticket booked successfully.");
        } else {
            System.out.println("Payment is not completed. Please complete the payment to book the ticket.");
        }
    }
}

public class MovieTicketBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TicketBookingHandler ageChecker = new AgeCheckingHandler();
        TicketBookingHandler paymentChecker = new PaymentCheckingHandler();

        ageChecker.setNextHandler(paymentChecker);

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        System.out.print("Is payment completed? (true/false): ");
        boolean paymentCompleted = scanner.nextBoolean();

        MovieTicketRequest request = new MovieTicketRequest("Avengers: Endgame", age, paymentCompleted);

        ageChecker.handleRequest(request);
    }
}
