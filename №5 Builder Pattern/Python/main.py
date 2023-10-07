class MovieTicket:
    def __init__(self, movie_name, theater_name):
        self.movie_name = movie_name
        self.theater_name = theater_name
        self.show_time = "13:00"
        self.number_of_tickets = 1

    def set_show_time(self, show_time):
        self.show_time = show_time
        return self

    def set_number_of_tickets(self, number_of_tickets):
        self.number_of_tickets = number_of_tickets
        return self

    def build(self):
        return self

    def __str__(self):
        return f"Movie: {self.movie_name}\n" \
               f"Theater: {self.theater_name}\n" \
               f"Show Time: {self.show_time}\n" \
               f"Number of Tickets: {self.number_of_tickets}"


# Example usage:
ticket = MovieTicket("Пірати карибського моря", "Кінотеатр Starmax") \
    .set_show_time("19:00") \
    .set_number_of_tickets(2) \
    .build()

ticket2 = MovieTicket("Барбі", "Кінотеатр Starmax") \
    .set_show_time("14:30") \
    .set_number_of_tickets(2) \
    .build()

print(ticket)
print("\n")
print(ticket2)
