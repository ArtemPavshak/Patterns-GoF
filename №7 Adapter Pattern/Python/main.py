class MovieBookingService:
    def book_movie(self, movie_name, number_of_tickets):
        pass


class MovieBookingService1:
    def book_ticket(self, movie_name, number_of_tickets):
        pass


class MovieBookingService2:
    def purchase_ticket(self, film_title, quantity):
        pass


class MovieBookingServiceAdapter1(MovieBookingService):
    def __init__(self, service1):
        self.service1 = service1

    def book_movie(self, movie_name, number_of_tickets):
        self.service1.book_ticket(movie_name, number_of_tickets)


class MovieBookingServiceAdapter2(MovieBookingService):
    def __init__(self, service2):
        self.service2 = service2

    def book_movie(self, movie_name, number_of_tickets):
        self.service2.purchase_ticket(movie_name, number_of_tickets)


class MovieBookingService1Impl(MovieBookingService1):
    def book_ticket(self, movie_name, number_of_tickets):
        print(f"Booking {number_of_tickets} tickets for {movie_name} using Service 1.")


class MovieBookingService2Impl(MovieBookingService2):
    def purchase_ticket(self, film_title, quantity):
        print(f"Purchasing {quantity} tickets for {film_title} using Service 2.")


def main():
    service1 = MovieBookingService1Impl()
    service2 = MovieBookingService2Impl()

    adapter1 = MovieBookingServiceAdapter1(service1)
    adapter2 = MovieBookingServiceAdapter2(service2)

    adapter1.book_movie("Movie Пірати Карибського Моря", 3)  # Uses Service 1
    adapter2.book_movie("Movie Бетмен", 2)  # Uses Service 2


if __name__ == "__main__":
    main()
