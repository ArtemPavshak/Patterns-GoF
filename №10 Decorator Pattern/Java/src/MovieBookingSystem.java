
interface MovieBooking {
    String getDescription();
    double getCost();
}

class BasicMovieBooking implements MovieBooking {
    @Override
    public String getDescription() {
        return "Basic Movie Ticket";
    }

    @Override
    public double getCost() {
        return 10.0;
    }
}

abstract class BookingDecorator implements MovieBooking {
    protected MovieBooking decoratedBooking;

    public BookingDecorator(MovieBooking decoratedBooking) {
        this.decoratedBooking = decoratedBooking;
    }

    @Override
    public String getDescription() {
        return decoratedBooking.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedBooking.getCost();
    }
}

class PopcornDecorator extends BookingDecorator {
    public PopcornDecorator(MovieBooking decoratedBooking) {
        super(decoratedBooking);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Popcorn";
    }

    @Override
    public double getCost() {
        return super.getCost() + 5.0;
    }
}

class PremiumSeatDecorator extends BookingDecorator {
    public PremiumSeatDecorator(MovieBooking decoratedBooking) {
        super(decoratedBooking);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Premium Seat";
    }

    @Override
    public double getCost() {
        return super.getCost() + 8.0;
    }
}

public class MovieBookingSystem {
    public static void main(String[] args) {
        MovieBooking basicBooking = new BasicMovieBooking();
        System.out.println("Basic Booking: " + basicBooking.getDescription() + ", Cost: " + basicBooking.getCost());

        MovieBooking bookingWithPopcorn = new PopcornDecorator(basicBooking);
        System.out.println("Booking with Popcorn: " + bookingWithPopcorn.getDescription() + ", Cost: $" + bookingWithPopcorn.getCost());

        MovieBooking bookingWithPremiumSeat = new PremiumSeatDecorator(basicBooking);
        System.out.println("Booking with Premium Seat: " + bookingWithPremiumSeat.getDescription() + ", Cost: $" + bookingWithPremiumSeat.getCost());

        MovieBooking bookingWithPopcornAndPremiumSeat = new PremiumSeatDecorator(new PopcornDecorator(basicBooking));
        System.out.println("Booking with Popcorn and Premium Seat: " + bookingWithPopcornAndPremiumSeat.getDescription() + ", Cost: $" + bookingWithPopcornAndPremiumSeat.getCost());
    }
}
