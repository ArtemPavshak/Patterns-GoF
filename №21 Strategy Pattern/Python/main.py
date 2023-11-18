from abc import ABC, abstractmethod


class PricingStrategy(ABC):
    @abstractmethod
    def calculate_price(self, number_of_tickets):
        pass


class RegularPricingStrategy(PricingStrategy):
    REGULAR_TICKET_PRICE = 10.0

    def calculate_price(self, number_of_tickets):
        return self.REGULAR_TICKET_PRICE * number_of_tickets


class StudentDiscountPricingStrategy(PricingStrategy):
    STUDENT_TICKET_PRICE = 7.0

    def calculate_price(self, number_of_tickets):
        return self.STUDENT_TICKET_PRICE * number_of_tickets


class SeniorCitizenDiscountPricingStrategy(PricingStrategy):
    SENIOR_TICKET_PRICE = 8.0

    def calculate_price(self, number_of_tickets):
        return self.SENIOR_TICKET_PRICE * number_of_tickets


class MovieBooking:
    def __init__(self):
        self.pricing_strategy = None

    def set_pricing_strategy(self, pricing_strategy):
        self.pricing_strategy = pricing_strategy

    def calculate_total_price(self, number_of_tickets):
        if self.pricing_strategy is None:
            raise ValueError("Pricing strategy not set")
        return self.pricing_strategy.calculate_price(number_of_tickets)


if __name__ == "__main__":
    movie_booking = MovieBooking()

    movie_booking.set_pricing_strategy(RegularPricingStrategy())
    regular_price = movie_booking.calculate_total_price(3)
    print(f"Regular price for 3 tickets: ${regular_price}")

    movie_booking.set_pricing_strategy(StudentDiscountPricingStrategy())
    student_price = movie_booking.calculate_total_price(4)
    print(f"Student price for 4 tickets: ${student_price}")

    movie_booking.set_pricing_strategy(SeniorCitizenDiscountPricingStrategy())
    senior_price = movie_booking.calculate_total_price(2)
    print(f"Senior citizen price for 2 tickets: ${senior_price}")
