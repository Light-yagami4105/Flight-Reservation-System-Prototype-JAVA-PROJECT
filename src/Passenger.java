public class Passenger {
    private String name;
    private String phoneNumber;
    private String seatClass;

    public Passenger(String name, String phoneNumber, String seatClass) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.seatClass = seatClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }
}
