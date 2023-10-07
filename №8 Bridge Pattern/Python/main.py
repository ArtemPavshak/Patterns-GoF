from abc import ABC, abstractmethod


class MovieBooking(ABC):
    @abstractmethod
    def book_ticket(self, number_of_tickets):
        pass

    @abstractmethod
    def cancel_booking(self):
        pass


class MovieBookingSystem(ABC):
    @abstractmethod
    def make_booking(self, movie, number_of_tickets):
        pass

    @abstractmethod
    def cancel_booking(self, movie):
        pass


class OnlineBookingSystem(MovieBookingSystem):
    def make_booking(self, movie, number_of_tickets):
        print(f"Online booking for {number_of_tickets} tickets for {movie}")

    def cancel_booking(self, movie):
        print(f"Canceling online booking for {movie}")


class BoxOfficeBookingSystem(MovieBookingSystem):
    def make_booking(self, movie, number_of_tickets):
        print(f"Box office booking for {number_of_tickets} tickets for {movie}")

    def cancel_booking(self, movie):
        print(f"Canceling box office booking for {movie}")


class MovieBookingImpl(MovieBooking):
    def __init__(self, booking_system, movie):
        self.booking_system = booking_system
        self.movie = movie

    def book_ticket(self, number_of_tickets):
        self.booking_system.make_booking(self.movie, number_of_tickets)

    def cancel_booking(self):
        self.booking_system.cancel_booking(self.movie)


if __name__ == "__main__":
    online_booking_system = OnlineBookingSystem()
    box_office_booking_system = BoxOfficeBookingSystem()

    online_booking = MovieBookingImpl(online_booking_system, "Пірати карибського моря")
    box_office_booking = MovieBookingImpl(box_office_booking_system, "Бетмен")

    online_booking.book_ticket(2)
    online_booking.cancel_booking()

    box_office_booking.book_ticket(3)
    box_office_booking.cancel_booking()
