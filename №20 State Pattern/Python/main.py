from abc import ABC, abstractmethod


# State interface
class BookingState(ABC):
    @abstractmethod
    def book_ticket(self):
        pass

    @abstractmethod
    def cancel_booking(self):
        pass

    @abstractmethod
    def refund_ticket(self):
        pass


class PendingState(BookingState):
    def __init__(self, context):
        self.context = context

    def book_ticket(self):
        print("Ticket booked successfully!")
        self.context.set_current_state(ConfirmedState(self.context))

    def cancel_booking(self):
        print("Booking canceled.")
        self.context.set_current_state(CancelledState())

    def refund_ticket(self):
        print("Cannot refund ticket as the booking is pending.")


class ConfirmedState(BookingState):
    def __init__(self, context):
        self.context = context

    def book_ticket(self):
        print("Ticket already booked.")

    def cancel_booking(self):
        print("Booking canceled.")
        self.context.set_current_state(CancelledState())

    def refund_ticket(self):
        print("Refunding ticket...")
        self.context.set_current_state(PendingState(self.context))


class CancelledState(BookingState):
    def book_ticket(self):
        print("Cannot book ticket as the booking is cancelled.")

    def cancel_booking(self):
        print("Booking already cancelled.")

    def refund_ticket(self):
        print("Ticket is already cancelled, no refund available.")


class MovieBooking:
    def __init__(self):
        self.current_state = PendingState(self)

    def set_current_state(self, state):
        self.current_state = state

    def book_ticket(self):
        self.current_state.book_ticket()

    def cancel_booking(self):
        self.current_state.cancel_booking()

    def refund_ticket(self):
        self.current_state.refund_ticket()


if __name__ == "__main__":
    movie_booking = MovieBooking()

    movie_booking.book_ticket()
    movie_booking.cancel_booking()
    movie_booking.book_ticket()
    movie_booking.refund_ticket()
    movie_booking.refund_ticket()
    movie_booking.cancel_booking()
