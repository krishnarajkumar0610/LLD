import java.util.*;

public class Flight {
    int tickets = 0;
    int flightId = 0;
    private static int id = 0;
    String flightName;
    int price = 0;
    public static String[] flightNames = { "Air india", "Indigo", "Delta" };
    ArrayList<Passenger> passengerDatas;
    static ArrayList<Passenger> commmonPassengersDatas = new ArrayList<>();
    boolean isAvailable;

    Flight() {
    }

    Flight(String flightName) {
        id += 1;
        flightId = id;
        this.flightName = flightName;
        tickets = 50;
        price = 5000;
        passengerDatas = new ArrayList<>();
        isAvailable = true;
    }

    public static Flight buildFlight(int index) {
        return new Flight(flightNames[index]);
    }

    public void book(Passenger passenger, ArrayList<Flight> flights) {
        for (Flight flight : flights) {
            if (flight.flightId == passenger.flightId && flight.isAvailable) {
                if (passenger.passengerSeatsReq > flight.tickets) {
                    System.out.println("Invalid seats!");
                    return;
                } else if (passenger.passengerSeatsReq * flight.price < passenger.passengerCurrentAmount) {
                    flight.tickets -= passenger.passengerSeatsReq;
                    int totalPrice = passenger.passengerSeatsReq * flight.price;
                    flight.price += totalPrice;
                    passenger.totalAmt = totalPrice;
                    flight.passengerDatas.add(passenger);
                    commmonPassengersDatas.add(passenger);
                    if (flight.tickets == 0)
                        flight.isAvailable = false;
                    break;
                } else {
                    System.out.println("Insufficient amount...");
                    return;
                }
            }
        }
    }

    public static void displayPassengersDetials() {
        if (commmonPassengersDatas.isEmpty()) {
            System.out.println("No tickets were booked...");
            return;
        }
        for (Passenger passenger : commmonPassengersDatas) {
            System.out.println("Passenger's flight Id:" + passenger.flightId);
            System.out.println("Passenger's flight Name:" + passenger.passengerFlightName);
            System.out.println("Passenger's name:" + passenger.passengerName);
            System.out.println("Passenger's age:" + passenger.passengerAge);
            System.out.println("Passenger's contact no:" + passenger.passengerContact);
            System.out.println("Passenger booked seats:" + passenger.passengerSeatsReq);
            System.out.println("Total amount for booking " + passenger.passengerSeatsReq + " is:" + passenger.totalAmt);
            System.out.println();
        }
    }

    public static void displayFlights(ArrayList<Flight> flights) {
        System.out.println("Welcome to madurai airport. Our available flights are....");
        for (Flight flight : flights) {
            if (flight.tickets != 0) {
                System.out.println("Flight Id: " + flight.flightId);
                System.out.println("Flight Name: " + flight.flightName);
                System.out.println("Available tickets for " + flight.flightName + " is: " + flight.tickets);
                System.out.println("Amount per ticket for " + flight.flightName + " is: " + flight.price);
                System.out.println();
            }
        }
    }
}