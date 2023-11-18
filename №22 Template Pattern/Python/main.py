from abc import ABC, abstractmethod


# Template class
def confirm_booking():
    print("Booking confirmed!")


class MovieBookingTemplate(ABC):
    def book_ticket(self):
        self.select_movie()
        self.select_seats()
        self.make_payment()
        confirm_booking()

    @abstractmethod
    def select_movie(self):
        pass

    @abstractmethod
    def select_seats(self):
        pass

    @abstractmethod
    def make_payment(self):
        pass


class MovieBookingProcess(MovieBookingTemplate):
    def __init__(self, movie_name, number_of_tickets):
        self.movie_name = movie_name
        self.number_of_tickets = number_of_tickets

    def select_movie(self):
        print(f"Selected Movie: {self.movie_name}")

    def select_seats(self):
        print(f"Selected {self.number_of_tickets} seats.")

    def make_payment(self):
        print(f"Payment successful for {self.number_of_tickets} tickets.")


if __name__ == "__main__":
    booking_process = MovieBookingProcess("Avengers: Endgame", 5)
    booking_process.book_ticket()
