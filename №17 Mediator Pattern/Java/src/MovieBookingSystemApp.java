import java.util.ArrayList;
import java.util.List;

interface BookingMediator {
    void bookMovie(String movieTitle, String customerName);
}

class MovieBookingSystem implements BookingMediator {
    private List<Movie> movies = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void bookMovie(String movieTitle, String customerName) {
        Movie movieToBook = null;
        Customer customerBooking = null;

        for (Movie movie : movies) {
            if (movie.getTitle().equals(movieTitle)) {
                movieToBook = movie;
                break;
            }
        }

        for (Customer customer : customers) {
            if (customer.getName().equals(customerName)) {
                customerBooking = customer;
                break;
            }
        }

        if (movieToBook != null && customerBooking != null) {
            if (movieToBook.isAvailable()) {
                movieToBook.book();
                System.out.println(customerBooking.getName() + " has booked " + movieToBook.getTitle());
            } else {
                System.out.println(movieToBook.getTitle() + " is already booked.");
            }
        } else {
            System.out.println("Movie or customer not found.");
        }
    }
}

interface Colleague {
    void bookMovie(String movieTitle);
}
class Customer implements Colleague {
    private String name;
    private BookingMediator mediator;

    public Customer(String name, BookingMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    @Override
    public void bookMovie(String movieTitle) {
        mediator.bookMovie(movieTitle, name);
    }
}

class Movie {
    private String title;
    private boolean isAvailable;

    public Movie(String title) {
        this.title = title;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void book() {
        isAvailable = false;
    }
}

public class MovieBookingSystemApp {
    public static void main(String[] args) {
        MovieBookingSystem mediator = new MovieBookingSystem();

        Customer customer1 = new Customer("Customer 1", mediator);
        Customer customer2 = new Customer("Customer 2", mediator);

        mediator.addCustomer(customer1);
        mediator.addCustomer(customer2);

        Movie movie1 = new Movie("Movie 1");
        Movie movie2 = new Movie("Movie 2");

        mediator.addMovie(movie1);
        mediator.addMovie(movie2);

        customer1.bookMovie("Movie 1");
        customer2.bookMovie("Movie 2");
        customer1.bookMovie("Movie 1");
    }
}
