package busReservationSystem;

import java.util.ArrayList;
import java.util.HashMap;

public class Bus {
    Bus() {
    }

    public String getBusNumberPlate() {
        return busNumberPlate;
    }

    public boolean isAC() {
        return AC;
    }

    private String busNumberPlate;

    public void setPassengersList(Passenger passenger) {
        this.passengersList.add(passenger);
    }

    private ArrayList<Passenger> passengersList = new ArrayList<>();

    public byte getSeats() {
        return seats;
    }

    public int getBusNumber() {
        return this.busNumber;
    }

    public byte availableSeats;
    private boolean AC;
    private byte seats;

    private int busNumber;

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


    private String source;
    private String destination;

    private String travelTime;

    public double getTicketCost() {
        return ticketCost;
    }


    private Double ticketCost;


    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getTravelTime() {
        return travelTime;
    }


    public byte getAvailableSeats() {
        return availableSeats;
    }


    public void setAvailableSeats(byte availableSeats) {
        this.availableSeats = availableSeats;
    }


    Bus(String busNumberPlate, boolean AC, byte seats,
        int busCount, String source, String destination, String travelTime, double price) {
        this.busNumberPlate = busNumberPlate;
        this.AC = AC;
        this.seats = seats;
        this.availableSeats = seats;
        this.busNumber = busCount;
        this.source = source;
        this.destination = destination;
        this.travelTime = travelTime;
        this.ticketCost = price;
    }

    public ArrayList<Passenger> getPassengersList() {
        return passengersList;
    }
}