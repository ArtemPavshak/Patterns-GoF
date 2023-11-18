from abc import ABC, abstractmethod

class MovieBookingSubject(ABC):
    @abstractmethod
    def register_observer(self, observer):
        pass

    @abstractmethod
    def remove_observer(self, observer):
        pass

    @abstractmethod
    def notify_observers(self):
        pass


class MovieBooking(MovieBookingSubject):
    def __init__(self):
        self.movie_name = ""
        self.number_of_tickets = 0
        self.observers = []

    def set_movie_and_tickets(self, movie_name, number_of_tickets):
        self.movie_name = movie_name
        self.number_of_tickets = number_of_tickets
        self.notify_observers()

    def register_observer(self, observer):
        self.observers.append(observer)

    def remove_observer(self, observer):
        self.observers.remove(observer)

    def notify_observers(self):
        for observer in self.observers:
            observer.update(self.movie_name, self.number_of_tickets)


class MovieBookingObserver(ABC):
    @abstractmethod
    def update(self, movie_name, number_of_tickets):
        pass


class User(MovieBookingObserver):
    def __init__(self, user_name):
        self.user_name = user_name

    def update(self, movie_name, number_of_tickets):
        print(f"Hi {self.user_name}! Movie: {movie_name}, Tickets: {number_of_tickets}")


if __name__ == "__main__":
    movie_booking = MovieBooking()

    user1 = User("Alice")
    user2 = User("Bob")

    movie_booking.register_observer(user1)
    movie_booking.register_observer(user2)

    movie_booking.set_movie_and_tickets("Avengers: Endgame", 5)
    movie_booking.set_movie_and_tickets("Spider-Man: No Way Home", 3)
    movie_booking.remove_observer(user2)
    movie_booking.set_movie_and_tickets("The Matrix Resurrections", 2)
