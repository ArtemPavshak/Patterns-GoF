
class TicketBookingCommand:
    def execute(self):
        pass

class MovieTicketBooking:
    def book_ticket(self, movie_name):
        print(f"Ticket booked for the movie: {movie_name}")

class BookTicketCommand(TicketBookingCommand):
    def __init__(self, movie_ticket_booking, movie_name):
        self.movie_ticket_booking = movie_ticket_booking
        self.movie_name = movie_name

    def execute(self):
        self.movie_ticket_booking.book_ticket(self.movie_name)

class TicketBookingSystem:
    def __init__(self):
        self.commands = []

    def add_command(self, command):
        self.commands.append(command)

    def execute_commands(self):
        for command in self.commands:
            command.execute()
        self.commands.clear()

if __name__ == "__main__":
    movie_ticket_booking = MovieTicketBooking()
    booking_system = TicketBookingSystem()

    book_ticket1 = BookTicketCommand(movie_ticket_booking, "Avengers: Endgame")
    book_ticket2 = BookTicketCommand(movie_ticket_booking, "Inception")

    booking_system.add_command(book_ticket1)
    booking_system.add_command(book_ticket2)

    booking_system.execute_commands()
