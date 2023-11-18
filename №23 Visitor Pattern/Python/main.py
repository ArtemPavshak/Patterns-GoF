from abc import ABC, abstractmethod

class Visitor(ABC):
    @abstractmethod
    def visit(self, movie_booking):
        pass

class BookingAnalyzer(Visitor):
    def visit(self, movie_booking):
        print(f"Analyzing movie booking: {movie_booking}")

class Element(ABC):
    @abstractmethod
    def accept(self, visitor):
        pass

class MovieBooking(Element):
    def __init__(self, movie_name, number_of_tickets):
        self.movie_name = movie_name
        self.number_of_tickets = number_of_tickets

    def accept(self, visitor):
        visitor.visit(self)

    def get_movie_name(self):
        return self.movie_name

    def get_number_of_tickets(self):
        return self.number_of_tickets

    def __str__(self):
        return f"Movie: {self.movie_name}, Tickets: {self.number_of_tickets}"

if __name__ == "__main__":
    movie_booking1 = MovieBooking("Avengers: Endgame", 3)
    movie_booking2 = MovieBooking("Spider-Man: No Way Home", 5)

    analyzer = BookingAnalyzer()
    movie_booking1.accept(analyzer)
    movie_booking2.accept(analyzer)
