
abstract class Ticket {
    public abstract void display();
}
class AdultTicket extends Ticket {
    @Override
    public void display() {
        System.out.println("Adult Ticket");
    }
}
class ChildTicket extends Ticket {
    @Override
    public void display() {
        System.out.println("Child Ticket");
    }
}
class SeniorTicket extends Ticket {
    @Override
    public void display() {
        System.out.println("Senior Ticket");
    }
}

abstract class PaymentMethod {
    public abstract void processPayment();
}

class CreditCardPayment extends PaymentMethod {
    @Override
    public void processPayment() {
        System.out.println("Processing payment with Credit Card");
    }
}

class CashPayment extends PaymentMethod {
    @Override
    public void processPayment() {
        System.out.println("Processing payment with Cash");
    }
}

interface TicketFactory {
    Ticket createTicket();
    PaymentMethod createPaymentMethod();
}

class AdultTicketFactory implements TicketFactory {
    @Override
    public Ticket createTicket() {
        return new AdultTicket();
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new CreditCardPayment();
    }
}

class ChildTicketFactory implements TicketFactory {
    @Override
    public Ticket createTicket() {
        return new ChildTicket();
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new CashPayment();
    }
}

class SeniorTicketFactory implements TicketFactory {
    @Override
    public Ticket createTicket() {
        return new SeniorTicket();
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new CreditCardPayment();
    }
}

public class Main {
    public static void main(String[] args) {
        TicketFactory adultTicketFactory = new AdultTicketFactory();
        TicketFactory childTicketFactory = new ChildTicketFactory();
        TicketFactory seniorTicketFactory = new SeniorTicketFactory();

        Ticket adultTicket = adultTicketFactory.createTicket();
        PaymentMethod adultPaymentMethod = adultTicketFactory.createPaymentMethod();

        Ticket childTicket = childTicketFactory.createTicket();
        PaymentMethod childPaymentMethod = childTicketFactory.createPaymentMethod();

        Ticket seniorTicket = seniorTicketFactory.createTicket();
        PaymentMethod seniorPaymentMethod = seniorTicketFactory.createPaymentMethod();

        adultTicket.display();
        adultPaymentMethod.processPayment();

        childTicket.display();
        childPaymentMethod.processPayment();

        seniorTicket.display();
        seniorPaymentMethod.processPayment();
    }
}
