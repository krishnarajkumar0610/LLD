import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner mainInp = new Scanner(System.in);
        System.out.println("\nWelcome to Madurai airport");
        Flight airport = new Flight();
        ArrayList<Flight> myFlights = new ArrayList<>();
        for (int i = 0; i < Flight.flightNames.length; i++) {
            Flight flight = Flight.buildFlight(i);
            myFlights.add(flight);
        }
        while (true) {
            System.out.println("\n1.Book");
            System.out.println("2.Cancel");
            System.out.println("3.Display flights");
            System.out.println("4.Display passengers");
            System.out.println("5.Exit");
            System.out.print("Enter your choice");
            int choice = mainInp.nextInt();
            switch (choice) {
                case 1:
                    Passenger passenger = Passenger.createPasenger();
                    airport.book(passenger, myFlights);
                    break;
                case 2:
                    break;
                case 3:
                    Flight.displayFlights(myFlights);
                    break;
                case 4:
                    Flight.displayPassengersDetials();
                    break;
                default:
                    // mainInp.close();
                    break;
            }
        }
    }
}
