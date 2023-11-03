from typing import List


class Movie:
    def __init__(self, title, director, duration):
        self.title = title
        self.director = director
        self.duration = duration

    def get_title(self):
        return self.title

    def get_director(self):
        return self.director

    def get_duration(self):
        return self.duration


class MovieList:
    def __init__(self, movies):
        self.movies = movies

    def create_iterator(self):
        return MovieIterator(self)


class MovieIterator:
    def __init__(self, movie_list):
        self.movie_list = movie_list
        self.current_index = 0

    def has_next(self):
        return self.current_index < len(self.movie_list.movies)

    def next(self):
        if self.has_next():
            movie = self.movie_list.movies[self.current_index]
            self.current_index += 1
            return movie
        return None


def main():
    movie_list = [
        Movie("Movie 1", "Director 1", 120),
        Movie("Movie 2", "Director 2", 110),
        Movie("Movie 3", "Director 3", 140)
    ]

    movie_aggregate = MovieList(movie_list)
    movie_iterator = movie_aggregate.create_iterator()

    while movie_iterator.has_next():
        movie = movie_iterator.next()
        print("Title:", movie.get_title())
        print("Director:", movie.get_director())
        print("Duration:", str(movie.get_duration()) + " minutes\n")


if __name__ == "__main__":
    main()
