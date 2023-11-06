public class Reservation {
    private Flight flight;
    private Passenger passenger;
    private boolean isConfirmed;

    public Reservation(Flight flight, Passenger passenger) {
        this.flight = flight;
        this.passenger = passenger;
        this.isConfirmed = false;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }
}
