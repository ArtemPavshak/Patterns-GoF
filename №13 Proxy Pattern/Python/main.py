
class MovieTicket:
    def buy_ticket(self):
        pass
class RealMovieTicket(MovieTicket):
    def __init__(self, movie_name):
        self.movie_name = movie_name

    def buy_ticket(self):
        print(f"Purchased a ticket for the movie: {self.movie_name}")


class MovieTicketProxy(MovieTicket):
    def __init__(self, movie_name, age):
        self.real_movie_ticket = RealMovieTicket(movie_name)
        self.age = age

    def buy_ticket(self):
        if self.age < 18:
            print("Sorry, you are too young to buy a ticket for this movie.")
        else:
            self.real_movie_ticket.buy_ticket()

if __name__ == "__main__":
    ticket = MovieTicketProxy("Avengers: Endgame", 16)
    ticket.buy_ticket()

    adult_ticket = MovieTicketProxy("Inception", 25)
    adult_ticket.buy_ticket()
