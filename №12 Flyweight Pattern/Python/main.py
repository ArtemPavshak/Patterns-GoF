class MovieFlyweight:
    def book_seat(self, seat_number):
        pass


class Movie(MovieFlyweight):
    def __init__(self, title, genre, duration, theater):
        self.title = title
        self.genre = genre
        self.duration = duration
        self.theater = theater

    def book_seat(self, seat_number):
        print(f"Booking seat #{seat_number} for movie: {self.title}")


class MovieFactory:
    def __init__(self):
        self.movies = {}

    def get_movie(self, title, genre, duration, theater):
        key = title + theater
        if key not in self.movies:
            movie = Movie(title, genre, duration, theater)
            self.movies[key] = movie
        return self.movies[key]


def main():
    factory = MovieFactory()

    movie1 = factory.get_movie("Пірати карибського моря", "Екшен", 150, "CinemaCity")
    movie2 = factory.get_movie("Аватар", "Екшен", 150, "SmartCinema")
    movie3 = factory.get_movie("Барбі", "Комедія", 162, "StarMax")

    movie1.book_seat(1)
    movie2.book_seat(2)
    movie3.book_seat(3)


if __name__ == "__main__":
    main()
