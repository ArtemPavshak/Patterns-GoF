class MovieTicketBookingSystem {
    public void bookTicket(Customer user, MovieSession movieSession, int numSeats) {
        // Логіка бронювання квитків
    }

    public void cancelTicket(Customer user, MovieSession movieSession, int numSeats) {
        // Логіка скасування квитків
    }
}

class MovieSession {
    public void displayMovieInfo() {
        // Виведення інформації про фільм
    }

    public void bookSeats(int numSeats) {
        // Бронювання місць на сеансі
    }
}
 class Customer {
    public void register() {
        // Реєстрація нового користувача
    }

    public void login() {
        // Вхід користувача
    }
}

//У цьому прикладі, різні класи (MovieTicketBookingSystem, MovieSession, User)
// мають високу зачепленість,оскільки кожен з них відповідає
// за конкретну функціональність, і всі методи в межах класу
// пов'язані та спрямовані на виконання специфічних завдань.
