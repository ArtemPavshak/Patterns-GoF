class Ticket:
    def __init__(self, movie_name, show_time):
        self.movie_name = movie_name
        self.show_time = show_time

    def get_price(self):
        pass

    def print_ticket(self):
        print("Movie:", self.movie_name)
        print("Show Time:", self.show_time)
        print("Price: $", self.get_price())


class AdultTicket(Ticket):
    def get_price(self):
        return 10.0


class ChildTicket(Ticket):
    def get_price(self):
        return 5.0


class SeniorTicket(Ticket):
    def get_price(self):
        return 7.0


class TicketFactory:
    def create_ticket(self, movie_name, show_time):
        pass


class ConcreteTicketFactory(TicketFactory):
    def create_ticket(self, movie_name, show_time):
        print("Enter 1 for Adult, 2 for Children, or 3 for Senior")
        number = int(input())
        return {
            1: AdultTicket(movie_name, show_time),
            2: ChildTicket(movie_name, show_time),
            3: SeniorTicket(movie_name, show_time)
        }.get(number, None)


if __name__ == "__main__":
    ticket_factory = ConcreteTicketFactory()
    ticket1 = ticket_factory.create_ticket("Пірати карибського моря", "17:30 AM")
    if ticket1:
        ticket1.print_ticket()
