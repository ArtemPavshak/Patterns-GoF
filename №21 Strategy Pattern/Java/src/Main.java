
interface PricingStrategy {
    double calculatePrice(int numberOfTickets);
}

class RegularPricingStrategy implements PricingStrategy {
    private static final double REGULAR_TICKET_PRICE = 10.0;

    @Override
    public double calculatePrice(int numberOfTickets) {
        return REGULAR_TICKET_PRICE * numberOfTickets;
    }
}

class StudentDiscountPricingStrategy implements PricingStrategy {
    private static final double STUDENT_TICKET_PRICE = 7.0;

    @Override
    public double calculatePrice(int numberOfTickets) {
        return STUDENT_TICKET_PRICE * numberOfTickets;
    }
}

class SeniorCitizenDiscountPricingStrategy implements PricingStrategy {
    private static final double SENIOR_TICKET_PRICE = 8.0;

    @Override
    public double calculatePrice(int numberOfTickets) {
        return SENIOR_TICKET_PRICE * numberOfTickets;
    }
}

class MovieBooking {
    private PricingStrategy pricingStrategy;

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double calculateTotalPrice(int numberOfTickets) {
        if (pricingStrategy == null) {
            throw new IllegalStateException("Pricing strategy not set");
        }
        return pricingStrategy.calculatePrice(numberOfTickets);
    }
}

public class Main {
    public static void main(String[] args) {
        MovieBooking movieBooking = new MovieBooking();

        movieBooking.setPricingStrategy(new RegularPricingStrategy());
        double regularPrice = movieBooking.calculateTotalPrice(3);
        System.out.println("Regular price for 3 tickets: $" + regularPrice);

        movieBooking.setPricingStrategy(new StudentDiscountPricingStrategy());
        double studentPrice = movieBooking.calculateTotalPrice(4);
        System.out.println("Student price for 4 tickets: $" + studentPrice);

        movieBooking.setPricingStrategy(new SeniorCitizenDiscountPricingStrategy());
        double seniorPrice = movieBooking.calculateTotalPrice(2);
        System.out.println("Senior citizen price for 2 tickets: $" + seniorPrice);
    }
}
