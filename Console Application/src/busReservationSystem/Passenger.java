package busReservationSystem;

public class Passenger extends User {

    private final String TicketNumber;

    Passenger(String name, byte age, String ticketNumber,byte busNumber) {
        this.setName(name);
        this.setAge(age);
        this.TicketNumber = ticketNumber;
        this.setBusNumber(busNumber);
//         this.setPhone(phone);
    }

    public String getTicketNumber() {
        return TicketNumber;
    }
}
