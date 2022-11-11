package busReservationSystem;

import java.util.*;

public class BookingProcess {
    Scanner scan = new Scanner(System.in);
    Admin admin = new Admin();
    ArrayList<ArrayList<Passenger>> passengerList = new ArrayList<>();
    final String constTicket = "VIB";

    int ticketNumber;

    public void displayBus() {
        System.out.println(" -------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-7s| %-19s| %-19s| %-15s| %-18s| %-18s| %-18s| %-10s|%n", "BUS NO", "BUS", "AVAILABLE TICKETS", "CATEGORY", "FROM", "TO", "TRAVEL TIME", "COST");
        System.out.println(" -------------------------------------------------------------------------------------------------------------------------------------------");
        for (Bus busList : admin.getBusList())
            System.out.printf("| %-7s| %-19s| %-19s| %-15s| %-18s| %-18s| %-18s| %-10s|%n", busList.getBusNumber(), busList.getBusNumberPlate(),
                    (busList.getSeats() < busList.getAvailableSeats() ? busList.getSeats() : busList.getAvailableSeats()),
                    (busList.isAC() ? "A/C" : "N-A/C"), busList.getSource(), busList.getDestination(), busList.getTravelTime(), busList.getTicketCost());
        System.out.println(" -------------------------------------------------------------------------------------------------------------------------------------------");
    }


    public void Options() {
        displayBus();
        OUTER_WHILE:
        while (true) {
            System.out.println("\n================");
            System.out.printf("|%-14s|%n|%-14s|%n|%-14s|", "1.Booking", "2.Cancel", "3.Admin Login");
            System.out.println("\n================");
//        try{
            System.out.println("Select Option : ");
            byte option = scan.nextByte();
            switch (option) {
                case 1:
                    System.out.print("Select a Bus Number to Book your ticket : ");
                    INNER_WHILE:
                    while (true) {
                        byte input = new Scanner(System.in).nextByte();
                        for (Bus bus : admin.getBusList()) {
                            if (bus.getBusNumber() == input) {
                                System.out.println("\n --------------------------------------------------------------------------------------------------");
                                System.out.printf("| %-20s | %-20s| %-18s| %-18s| %-12s|", "Bus Number", "Available Seats", "From", "TO", "Travel Time");
                                System.out.println("\n --------------------------------------------------------------------------------------------------");
                                System.out.printf("| %-20s | %-20s| %-18s| %-18s| %-12s|%n", bus.getBusNumberPlate(), bus.getAvailableSeats(), bus.getSource(), bus.getDestination(), bus.getTravelTime());
                                System.out.println(" --------------------------------------------------------------------------------------------------");
                                bookingTicket(bus, input);
                                System.out.println(" ----------------------");
                                System.out.printf("| %-20s |", "Display Bus Details");
                                System.out.println("\n ----------------------");
                                System.out.printf("| %-20s|%n| %-20s|", "1.Yes", "2.No");
                                System.out.println("\n----------------------");
                                System.out.print("Enter your option : ");
                                if (scan.nextByte() == 1) displayBus();
                                break INNER_WHILE;
                            }
                        }
//                        System.out.print("Enter a valid Bus Number : ");
                    }
                    break;
                case 2:
                    System.out.print("Enter your ticket number to cancel : ");
                    while (true) {
                        String cancelID = scan.next();
                        if (cancelTicket(cancelID)) {
                            System.out.println("\nCancelled Successfully\n");
                            displayBus();
                            break;
                        } else {
                            System.out.print("Enter a valid Bus Ticket Number : ");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter admin USERNAME : ");
                    String userName = scan.next();
                    System.out.print("Enter admin PASSWORD : ");
                    String password = scan.next();
                    admin.login(userName, password);
                    break;
                default:
                    break OUTER_WHILE;
            }
//    }catch {}
        }
    }

    private boolean cancelTicket(String cancelID) {
        boolean flag = false;
        for (ArrayList<Passenger> passengerGroup : passengerList) {
            for (Passenger passenger : passengerGroup) {
                if (passenger.getTicketNumber().equalsIgnoreCase(cancelID)) {
                    flag = true;
                    passengerGroup.remove(passenger);
                    for (Bus busList : admin.getBusList()) {
                        if (passenger.getBusNumber() == busList.getBusNumber())
                            busList.setAvailableSeats((byte) (busList.getAvailableSeats() + 1));
                    }
                    break;
                }
            }
        }
        return flag;
    }

    private void bookingTicket(Bus bus, byte busNumber) {
        System.out.println("Please enter how many tickets you need to book : ");
        byte tickets = scan.nextByte();
        getUserDetails(tickets, bus, busNumber);
    }

    private void getUserDetails(byte tickets, Bus bus, byte busNumber) {
        byte passengers = 1;
        ArrayList<Passenger> tempPassenger = new ArrayList<>();
        if (passengers <= bus.getAvailableSeats()) {
            for (byte users = 0; users < tickets; users++) {
                // reducing available tickets
                bus.setAvailableSeats((byte) (bus.getAvailableSeats() - 1));
                // cresting individual tickets for each bus
                String TicketNumber = constTicket + bus.getBusNumber() + ++ticketNumber;
                System.out.println("Passenger " + passengers++);
                System.out.println("Enter your name : ");
                String name = scan.next();
                System.out.println("Enter your age : ");
                byte age = scan.nextByte();
                // creating new Passenger
                Passenger passenger = new Passenger(name, age, TicketNumber, busNumber);
                bus.setPassengersList(passenger);
                tempPassenger.add(passenger);
            }
            displayBookingDetails(tempPassenger);
            passengerList.add(tempPassenger);
        } else {
            System.out.println("!Sorry Seats are full");
        }
    }

    private void displayBookingDetails(ArrayList<Passenger> passenger) {
        System.out.println("\n _____________________________________________________________________________________________________");
        System.out.printf("|                                              %-45s|", "Ticket Booked");
        System.out.println("\n _____________________________________________________________________________________________________");
        System.out.printf("| %-20s|  %-5s| %-15s | %-18s| %-18s| %-12s|", "Name", "Age", "TicketNumber", "From", "TO", "Travel Time");
        System.out.println("\n _____________________________________________________________________________________________________");

        for (Passenger passenger1 : passenger) {
            for (Bus bus : admin.getBusList()) {
                if (passenger1.getBusNumber() == bus.getBusNumber()) {
                    System.out.printf("| %-20s|  %-5s| %-15s | %-18s| %-18s| %-12s|%n", passenger1.getName(), passenger1.getAge(), passenger1.getTicketNumber(),
                            bus.getSource(), bus.getDestination(), bus.getTravelTime());
                }
            }
        }
        System.out.println("_____________________________________________________________________________________________________");
    }

}