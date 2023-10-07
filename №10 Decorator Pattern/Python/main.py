class MovieBooking:
    def get_description(self):
        pass

    def get_cost(self):
        pass


class BasicMovieBooking(MovieBooking):
    def get_description(self):
        return "Basic Movie Ticket"

    def get_cost(self):
        return 10.0


class BookingDecorator(MovieBooking):
    def __init__(self, decorated_booking):
        self.decorated_booking = decorated_booking

    def get_description(self):
        return self.decorated_booking.get_description()

    def get_cost(self):
        return self.decorated_booking.get_cost()


class PopcornDecorator(BookingDecorator):
    def __init__(self, decorated_booking):
        super().__init__(decorated_booking)

    def get_description(self):
        return super().get_description() + ", Popcorn"

    def get_cost(self):
        return super().get_cost() + 5.0


class PremiumSeatDecorator(BookingDecorator):
    def __init__(self, decorated_booking):
        super().__init__(decorated_booking)

    def get_description(self):
        return super().get_description() + ", Premium Seat"

    def get_cost(self):
        return super().get_cost() + 8.0


if __name__ == "__main__":
    basic_booking = BasicMovieBooking()
    print(f"Basic Booking: {basic_booking.get_description()}, Cost: ${basic_booking.get_cost()}")

    booking_with_popcorn = PopcornDecorator(basic_booking)
    print(f"Booking with Popcorn: {booking_with_popcorn.get_description()}, Cost: ${booking_with_popcorn.get_cost()}")

    booking_with_premium_seat = PremiumSeatDecorator(basic_booking)
    print(
        f"Booking with Premium Seat: {booking_with_premium_seat.get_description()}, Cost: ${booking_with_premium_seat.get_cost()}")

    booking_with_popcorn_and_premium_seat = PremiumSeatDecorator(PopcornDecorator(basic_booking))
    print(
        f"Booking with Popcorn and Premium Seat: {booking_with_popcorn_and_premium_seat.get_description()}, Cost: ${booking_with_popcorn_and_premium_seat.get_cost()}")
