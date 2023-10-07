from abc import ABC, abstractmethod


class MovieComponent(ABC):
    @abstractmethod
    def display(self):
        pass


class Seat(MovieComponent):
    def __init__(self, seat_number):
        self.seat_number = seat_number
        self.is_booked = False

    def book_seat(self):
        if not self.is_booked:
            self.is_booked = True
            print(f"Seat {self.seat_number} booked successfully.")
        else:
            print(f"Seat {self.seat_number} is already booked.")

    def display(self):
        if self.is_booked:
            print("X", end=" ")
        else:
            print(self.seat_number, end=" ")


class MovieSchedule(MovieComponent):
    def __init__(self, time):
        self.time = time
        self.seats = []

    def add_seat(self, seat):
        self.seats.append(seat)

    def display(self):
        print(f"Movie at {self.time}")
        for seat in self.seats:
            seat.display()
        print()


class Theater(MovieComponent):
    def __init__(self, name):
        self.name = name
        self.schedules = []

    def add_schedule(self, schedule):
        self.schedules.append(schedule)

    def display(self):
        print(f"Theater: {self.name}")
        for schedule in self.schedules:
            schedule.display()


def main():
    theater1 = Theater("StarMax")
    theater2 = Theater("Ольги Кобилянської")

    schedule1 = MovieSchedule("10:00")
    schedule2 = MovieSchedule("14:00")
    schedule3 = MovieSchedule("18:00")

    seat1 = Seat(1)
    seat2 = Seat(2)
    seat3 = Seat(3)
    seat4 = Seat(4)

    schedule1.add_seat(seat1)
    schedule1.add_seat(seat2)
    schedule2.add_seat(seat3)
    schedule2.add_seat(seat4)

    theater1.add_schedule(schedule1)
    theater1.add_schedule(schedule2)
    theater2.add_schedule(schedule3)

    theater1.display()
    theater2.display()

    seat1.book_seat()
    schedule1.display()


if __name__ == "__main__":
    main()
