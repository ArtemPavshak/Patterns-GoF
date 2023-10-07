import java.util.ArrayList;
import java.util.List;

interface MovieComponent {
    void display();
}

class Seat implements MovieComponent {
    private final int seatNumber;
    private boolean isBooked;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = false;
    }

    public void bookSeat() {
        if (!isBooked) {
            isBooked = true;
            System.out.println("Seat " + seatNumber + " booked successfully.");
        } else {
            System.out.println("Seat " + seatNumber + " is already booked.");
        }
    }

    @Override
    public void display() {
        if (isBooked) {
            System.out.print("X ");
        } else {
            System.out.print(seatNumber + " ");
        }
    }
}

// Composite
class MovieSchedule implements MovieComponent {
    private final String time;
    private final List<MovieComponent> seats = new ArrayList<>();

    public MovieSchedule(String time) {
        this.time = time;
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }

    @Override
    public void display() {
        System.out.println("Movie at " + time);
        for (MovieComponent seat : seats) {
            seat.display();
        }
        System.out.println();
    }
}

class Theater implements MovieComponent {
    private final String name;
    private final List<MovieComponent> schedules = new ArrayList<>();

    public Theater(String name) {
        this.name = name;
    }

    public void addSchedule(MovieSchedule schedule) {
        schedules.add(schedule);
    }

    @Override
    public void display() {
        System.out.println("Theater: " + name);
        for (MovieComponent schedule : schedules) {
            schedule.display();
        }
    }
}

public class MovieBookingSystem {
    public static void main(String[] args) {
        Theater theater1 = new Theater("StarMax");
        Theater theater2 = new Theater("Ольги Кобилянської");

        MovieSchedule schedule1 = new MovieSchedule("10:00");
        MovieSchedule schedule2 = new MovieSchedule("14:00");
        MovieSchedule schedule3 = new MovieSchedule("18:00");

        Seat seat1 = new Seat(1);
        Seat seat2 = new Seat(2);
        Seat seat3 = new Seat(3);
        Seat seat4 = new Seat(4);

        schedule1.addSeat(seat1);
        schedule1.addSeat(seat2);
        schedule2.addSeat(seat3);
        schedule2.addSeat(seat4);

        theater1.addSchedule(schedule1);
        theater1.addSchedule(schedule2);
        theater2.addSchedule(schedule3);

        theater1.display();
        theater2.display();

        seat1.bookSeat();
        schedule1.display();
    }
}
