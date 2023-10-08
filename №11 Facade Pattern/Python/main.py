from dataclasses import dataclass


@dataclass
class Movie:
    title: str


@dataclass
class Theater:
    theater_name: str


class PaymentService:
    @staticmethod
    def make_payment():
        return True


class NotificationService:
    @staticmethod
    def send_confirmation(message):
        print("Notification:", message)


class MovieBookingFacade:
    def __init__(self):
        self.payment_service = PaymentService()
        self.notification_service = NotificationService()

    def book_movie_tickets(self, movies, theater):
        for movie in movies:
            print(f"Booking movie ticket for: {movie.title} at {theater.theater_name}")

            payment_successful = self.payment_service.make_payment()

            if payment_successful:
                self.notification_service.send_confirmation(
                    f"Movie ticket booked for: {movie.title} at {theater.theater_name}")
                print("Booking successful!")
            else:
                print("Payment failed. Booking canceled.")
            print()


if __name__ == "__main__":
    movies_to_book = [Movie("Пірати карибського моря"), Movie("Матриця"), Movie("Аватар")]
    cinema_city = Theater("CinemaCity")
    movie_max = Theater("MovieMax")

    movie_booking_facade = MovieBookingFacade()

    print("Booking movies at CinemaCity:")
    movie_booking_facade.book_movie_tickets(movies_to_book, cinema_city)

    print("Booking movies at MovieMax:")
    movie_booking_facade.book_movie_tickets(movies_to_book, movie_max)
