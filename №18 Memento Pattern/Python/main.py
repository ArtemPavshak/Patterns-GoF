from dataclasses import dataclass

@dataclass
class MovieBookingMemento:
    movieName: str
    numberOfTickets: int

class MovieBooking:
    def __init__(self):
        self.movieName = ""
        self.numberOfTickets = 0

    def set_movie_and_tickets(self, movie_name, number_of_tickets):
        self.movieName = movie_name
        self.numberOfTickets = number_of_tickets

    def save_to_memento(self):
        return MovieBookingMemento(self.movieName, self.numberOfTickets)

    def restore_from_memento(self, memento):
        self.movieName = memento.movieName
        self.numberOfTickets = memento.numberOfTickets

    def display(self):
        print(f"Movie: {self.movieName}, Tickets: {self.numberOfTickets}")

class MovieBookingCareTaker:
    def __init__(self):
        self.memento = None

    def save_state(self, memento):
        self.memento = memento

    def retrieve_state(self):
        return self.memento

if __name__ == "__main__":
    movie_booking = MovieBooking()
    care_taker = MovieBookingCareTaker()

    movie_booking.set_movie_and_tickets("Avengers: Endgame", 5)
    movie_booking.display()

    care_taker.save_state(movie_booking.save_to_memento())

    movie_booking.set_movie_and_tickets("Spider-Man: No Way Home", 3)
    movie_booking.display()

    movie_booking.restore_from_memento(care_taker.retrieve_state())
    movie_booking.display()
