class TicketBookingSystem:
    _instance = None

    def __init__(self, password):
        self.password = password

    @classmethod
    def get_instance(cls, password):
        if cls._instance is None:
            cls._instance = cls(password)
        return cls._instance

    @staticmethod
    def book_ticket(film_name, price, row, seat):
        print(f"The film {film_name} Was booked and the total price is {price} Your seat will be {row} row {seat} seat")

    @staticmethod
    def sell_ticket(film_name, price, row, seat):
        print(f"The film {film_name} Has sold and the total price is {price} seat {row} row {seat} seat")


if __name__ == "__main__":
    booking_system = TicketBookingSystem.get_instance("Qwerty123")
    booking_system.book_ticket("Inception", 200, 3, 15)
    booking_system.sell_ticket("Batman", 220, 5, 20)
    alter_booking_system = TicketBookingSystem.get_instance("Kiras495")
    print(booking_system.password)
    print(alter_booking_system.password)
