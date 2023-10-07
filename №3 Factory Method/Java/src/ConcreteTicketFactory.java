import java.util.Scanner;
public class ConcreteTicketFactory implements TicketFactory {
    Scanner scanner = new Scanner(System.in);
    @Override
    public Ticket createTicket(String movieName, String showTime) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 for Adult, 2 for Children, or 3 for Senior");
        int number = scanner.nextInt();
        scanner.nextLine();
        scanner.close();
        return switch (number) {
            case 1 -> new AdultTicket(movieName, showTime);
            case 2 -> new ChildTicket(movieName, showTime);
            case 3 -> new SeniorTicket(movieName, showTime);
            default -> null;
        };
    }
}
