import java.util.Scanner;

public class Passenger {
    String passengerName;//
    int passengerAge;//
    String passengerContact;//
    int passengerSeatsReq;//
    int flightId;
    String passengerFlightName;
    int passengerCurrentAmount;
    int totalAmt;

    Passenger(String passengerName, int age, String contact, int seatsReq, String flightName, int flightId,
            int amountHaving) {
        this.passengerName = passengerName;
        this.passengerFlightName = flightName;
        this.flightId = flightId;
        this.passengerAge = age;
        this.passengerContact = contact;
        this.passengerSeatsReq = seatsReq;
        this.passengerCurrentAmount = amountHaving;
        this.totalAmt = 0;
    }

    public static Passenger createPasenger() {
        Scanner passengerInp = new Scanner(System.in);
        System.out.print("Enter name:");
        String name = passengerInp.nextLine();
        System.out.print("\nEnter age:");
        int age = passengerInp.nextInt();
        passengerInp.nextLine();
        System.out.print("\nEnter contact:");
        String contact = passengerInp.nextLine();
        System.out.print("\nEnter flight id");
        int fId = passengerInp.nextInt();
        passengerInp.nextLine();
        System.out.print("\nEnter flight name:");
        String fName = passengerInp.nextLine();
        System.out.print("\nEnter seats required:");
        int seats = passengerInp.nextInt();
        System.out.print("\nEnter having amount:");
        int amount = passengerInp.nextInt();
        passengerInp.nextLine();
        return new Passenger(name, age, contact, seats, fName, fId, amount);
    }
}