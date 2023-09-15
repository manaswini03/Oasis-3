

/*import java.util.Scanner;

public class TickResv {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Online Reservation System");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        if (isValidUser(username, password)) {
            System.out.println("Login successful!");
            mainMenu(scanner);
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private static boolean isValidUser(String username, String password) {
        // Implement user authentication logic here, e.g., check against a database
        // Return true if the user is valid, otherwise return false
        // Replace this with your actual authentication logic
        return username.equals("admin") && password.equals("password");
    }

    private static void mainMenu(Scanner scanner) {
        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Make a Reservation");
            System.out.println("2. Cancel a Reservation");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    makeReservation(scanner);
                    break;
                case 2:
                    cancelReservation(scanner);
                    break;
                case 3:
                    System.out.println("Logging out.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void makeReservation(Scanner scanner) {
        // Implement reservation logic here, including database interaction
        // Allow the user to enter details and confirm reservation
        // Show appropriate messages based on success or failure
        // Replace this with your actual reservation logic
        System.out.println("Reservation functionality is not implemented yet.");
    }

    private static void cancelReservation(Scanner scanner) {
        // Implement cancellation logic here, including database interaction
        // Allow the user to enter PNR and confirm cancellation
        // Show appropriate messages based on success or failure
        // Replace this with your actual cancellation logic
        System.out.println("Cancellation functionality is not implemented yet.");
    }
}*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }
}

class Reservation {
    private static int nextPNR = 1;
    private int pnr;
    private String passengerName;
    private String trainName;
    private String classType;
    private String dateOfJourney;
    private String source;
    private String destination;

    public Reservation(String passengerName, String trainName, String classType, String dateOfJourney, String source, String destination) {
        this.pnr = nextPNR++;
        this.passengerName = passengerName;
        this.trainName = trainName;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.source = source;
        this.destination = destination;
    }

    public int getPNR() {
        return pnr;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getClassType() {
        return classType;
    }

    public String getDateOfJourney() {
        return dateOfJourney;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }
}

public class TickResv{
    private static List<User> users = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        users.add(new User("admin", "password"));

        while (true) {
            System.out.println("Welcome to the Online Reservation System");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void login() {
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        User authenticatedUser = authenticateUser(username, password);

        if (authenticatedUser != null) {
            System.out.println("Login successful!");
            mainMenu(authenticatedUser);
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private static User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.authenticate(username, password)) {
                return user;
            }
        }
        return null;
    }

    private static void mainMenu(User user) {
        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Make a Reservation");
            System.out.println("2. Cancel a Reservation");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    makeReservation();
                    break;
                case 2:
                    cancelReservation();
                    break;
                case 3:
                    System.out.println("Logging out.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void makeReservation() {
        // Implement reservation logic here
        System.out.print("Enter passenger name: ");
        String passengerName = scanner.next();
        System.out.print("Enter train name: ");
        String trainName = scanner.next();
        System.out.print("Enter class type: ");
        String classType = scanner.next();
        System.out.print("Enter date of journey: ");
        String dateOfJourney = scanner.next();
        System.out.print("Enter source: ");
        String source = scanner.next();
        System.out.print("Enter destination: ");
        String destination = scanner.next();

        Reservation reservation = new Reservation(passengerName, trainName, classType, dateOfJourney, source, destination);
        reservations.add(reservation);

        System.out.println("Reservation successful!");
        System.out.println("Your PNR is: " + reservation.getPNR());
    }

    private static void cancelReservation() {
        // Implement cancellation logic here
        System.out.print("Enter PNR number to cancel the reservation: ");
        int pnrToCancel = scanner.nextInt();
        boolean found = false;

        for (Reservation reservation : reservations) {
            if (reservation.getPNR() == pnrToCancel) {
                reservations.remove(reservation);
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Cancellation successful!");
        } else {
            System.out.println("No reservation found with the provided PNR.");
        }
    }
}

