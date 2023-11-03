class BookingMediator:
    def book_movie(self, movie_title, customer_name):
        pass

class MovieBookingSystem(BookingMediator):
    def __init__(self):
        self.movies = []
        self.customers = []

    def add_movie(self, movie):
        self.movies.append(movie)

    def add_customer(self, customer):
        self.customers.append(customer)

    def book_movie(self, movie_title, customer_name):
        movie_to_book = None
        customer_booking = None

        for movie in self.movies:
            if movie.get_title() == movie_title:
                movie_to_book = movie
                break

        for customer in self.customers:
            if customer.get_name() == customer_name:
                customer_booking = customer
                break

        if movie_to_book and customer_booking:
            if movie_to_book.is_available:
                movie_to_book.book()
                print(customer_booking.get_name() + " has booked " + movie_to_book.get_title())
            else:
                print(movie_to_book.get_title() + " is already booked.")
        else:
            print("Movie or customer not found.")

class Colleague:
    def book_movie(self, movie_title):
        pass

class Customer(Colleague):
    def __init__(self, name, mediator):
        self.name = name
        self.mediator = mediator

    def get_name(self):
        return self.name

    def book_movie(self, movie_title):
        self.mediator.book_movie(movie_title, self.name)

class Movie:
    def __init__(self, title):
        self.title = title
        self.is_available = True

    def get_title(self):
        return self.title

    def book(self):
        self.is_available = False

if __name__ == "__main__":
    mediator = MovieBookingSystem()

    customer1 = Customer("Customer 1", mediator)
    customer2 = Customer("Customer 2", mediator)

    mediator.add_customer(customer1)
    mediator.add_customer(customer2)

    movie1 = Movie("Movie 1")
    movie2 = Movie("Movie 2")

    mediator.add_movie(movie1)
    mediator.add_movie(movie2)

    customer1.book_movie("Movie 1")
    customer2.book_movie("Movie 2")
    customer1.book_movie("Movie 1")
