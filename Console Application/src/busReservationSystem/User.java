package busReservationSystem;

public class User {
    private String name;
    private String phone;
    private byte age;
    private byte busNumber;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }


    public byte getBusNumber() {return busNumber;}

    public void setBusNumber(byte busNum) {this.busNumber = busNum;}
}
