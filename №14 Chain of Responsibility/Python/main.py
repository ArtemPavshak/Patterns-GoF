class MovieTicketRequest:
    def __init__(self, movie_name, age, payment_completed):
        self.movie_name = movie_name
        self.age = age
        self.payment_completed = payment_completed

class TicketBookingHandler:
    def set_next_handler(self, next_handler):
        self.next_handler = next_handler

    def handle_request(self, request):
        pass

class AgeCheckingHandler(TicketBookingHandler):
    def handle_request(self, request):
        if request.age >= 18:
            print("Age is OK. Proceeding to the next check.")
            if self.next_handler is not None:
                self.next_handler.handle_request(request)
        else:
            print("Sorry, you are too young to book this ticket.")

class PaymentCheckingHandler(TicketBookingHandler):
    def handle_request(self, request):
        if request.payment_completed:
            print("Payment is completed. Ticket booked successfully.")
        else:
            print("Payment is not completed. Please complete the payment to book the ticket.")

def main():
    age_checker = AgeCheckingHandler()
    payment_checker = PaymentCheckingHandler()

    age_checker.set_next_handler(payment_checker)

    age = int(input("Enter your age: "))
    payment_completed = input("Is payment completed? (true/false): ").lower() == "true"

    request = MovieTicketRequest("Avengers: Endgame", age, payment_completed)

    age_checker.handle_request(request)

if __name__ == "__main__":
    main()
