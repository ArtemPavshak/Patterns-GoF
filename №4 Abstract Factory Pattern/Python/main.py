class Ticket:
    def display(self):
        pass

class AdultTicket(Ticket):
    def display(self):
        print("Adult Ticket")

class ChildTicket(Ticket):
    def display(self):
        print("Child Ticket")

class SeniorTicket(Ticket):
    def display(self):
        print("Senior Ticket")

class PaymentMethod:
    def process_payment(self):
        pass

class CreditCardPayment(PaymentMethod):
    def process_payment(self):
        print("Processing payment with Credit Card")

class CashPayment(PaymentMethod):
    def process_payment(self):
        print("Processing payment with Cash")

class TicketFactory:
    def create_ticket(self):
        pass

    def create_payment_method(self):
        pass

class AdultTicketFactory(TicketFactory):
    def create_ticket(self):
        return AdultTicket()

    def create_payment_method(self):
        return CreditCardPayment()

class ChildTicketFactory(TicketFactory):
    def create_ticket(self):
        return ChildTicket()

    def create_payment_method(self):
        return CashPayment()

class SeniorTicketFactory(TicketFactory):
    def create_ticket(self):
        return SeniorTicket()

    def create_payment_method(self):
        return CreditCardPayment()

if __name__ == "__main__":
    adult_ticket_factory = AdultTicketFactory()
    child_ticket_factory = ChildTicketFactory()
    senior_ticket_factory = SeniorTicketFactory()

    adult_ticket = adult_ticket_factory.create_ticket()
    adult_payment_method = adult_ticket_factory.create_payment_method()

    child_ticket = child_ticket_factory.create_ticket()
    child_payment_method = child_ticket_factory.create_payment_method()

    senior_ticket = senior_ticket_factory.create_ticket()
    senior_payment_method = senior_ticket_factory.create_payment_method()

    adult_ticket.display()
    adult_payment_method.process_payment()

    child_ticket.display()
    child_payment_method.process_payment()

    senior_ticket.display()
    senior_payment_method.process_payment()
