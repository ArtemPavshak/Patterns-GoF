class MovieTicketResource:
    def __init__(self, movie_name, theater_name, show_time, number_of_tickets):
        self.movie_name = movie_name
        self.theater_name = theater_name
        self.show_time = show_time
        self.number_of_tickets = number_of_tickets

    def __str__(self):
        return f"Movie: {self.movie_name}\n" \
               f"Theater: {self.theater_name}\n" \
               f"Show Time: {self.show_time}\n" \
               f"Number of Tickets: {self.number_of_tickets}"


class MovieTicketResourcePool:
    def __init__(self, max_pool_size):
        self.max_pool_size = max_pool_size
        self.pool = []

    def acquire_resource(self, movie_name, theater_name, show_time, number_of_tickets):
        if not self.pool:
            return self.create_resource(movie_name, theater_name, show_time, number_of_tickets)
        else:
            return self.pool.pop(0)

    def release_resource(self, resource):
        if len(self.pool) < self.max_pool_size:
            self.pool.append(resource)

    def create_resource(self, movie_name, theater_name, show_time, number_of_tickets):
        return MovieTicketResource(movie_name, theater_name, show_time, number_of_tickets)


def main():
    resource_pool = MovieTicketResourcePool(5)

    ticket1 = resource_pool.acquire_resource("Пірати карибського моря", "Кінотеатр Starmax", "19:00", 2)
    print("Ticket 1:\n" + str(ticket1))

    ticket2 = resource_pool.acquire_resource("Барбі", "Кінотеатр Starmax", "14:30", 3)
    print("Ticket 2:\n" + str(ticket2))

    resource_pool.release_resource(ticket1)
    resource_pool.release_resource(ticket2)


if __name__ == "__main__":
    main()
