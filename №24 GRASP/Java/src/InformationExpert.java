
class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayUserInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class UserController {
    private User user;

    public UserController(User user) {
        this.user = user;
    }

    public void processUser() {
        user.displayUserInfo();
    }
}

public class InformationExpert {
    public static void main(String[] args) {
        User user = new User("John", 30);

        UserController userController = new UserController(user);
        userController.processUser();
    }
}

//У цьому прикладі MovieSession володіє інформацією про конкретний
// сеанс кіно (назва фільму, час, доступні місця) імає метод bookSeats для
// бронювання місць. Клас User представляє користувача системи,
// який може бронювати квитки на сеанси.