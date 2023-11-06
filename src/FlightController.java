import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class FlightController {
    private Flight model;
    private FlightView view;

    public FlightController(Flight model, FlightView view) {
        this.model = model;
        this.view = view;
    }

    public void initializeController() {
        view.setConfirmButtonListener(new ConfirmButtonListener());
        view.setPaymentFormButtonListener(new PaymentFormButtonListener());
        view.setExitButtonListener(new ExitButtonListener());
    }

    private class ConfirmButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getName();
            String phoneNumber = view.getPhoneNumber();
            String seatClass = view.getSeatClass();

            // Validate input
            
            Passenger passenger = new Passenger(name, phoneNumber, seatClass);
            Flight flight = new Flight("ABC123", 100); // Sample flight data
            Reservation reservation = new Reservation(flight, passenger);

            // Logic to handle confirmation dialog
            int result = JOptionPane.showConfirmDialog(null, "Confirm Reservation?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                // Proceed to payment form
                view.displayPaymentForm();
            } else {
                // User canceled the reservation
                view.displayErrorMessage("Reservation canceled.");
            }
        }
    }

    private class PaymentFormButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cardNumber = view.getCardNumber();
            String expiryDate = view.getExpiryDate();
            String cvv = view.getCVV();

            // Perform payment processing
            if (isValidCardInformation(cardNumber, expiryDate, cvv)) {
                // Payment successful, save data to the database and perform calculations
                String name = view.getName();
                String phoneNumber = view.getPhoneNumber();
                String seatClass = view.getSeatClass();

                saveDataToDatabase(name, phoneNumber, seatClass);
                performCalculations(seatClass);

                // Display ticket details
                String ticketDetails = "Ticket Information:\n"
                        + "Name: " + name + "\n"
                        + "Phone Number: " + phoneNumber + "\n"
                        + "Seat Class: " + seatClass + "\n"
                        + "Flight Number: ABC123\n"
                        + "Seat Number: 10A\n"
                        + "Confirmation Number: 123456";

                view.displayTicketDetails(ticketDetails, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Additional logic before disposing the frame
                        // perform cleanup operations

                        view.disposeTicketFrame(); // Dispose the ticket details frame
                    }
                });
            } else {
                // Payment failed, display error message
                view.displayErrorMessage("Payment failed. Please check your card information.");
            }
        }

        private boolean isValidCardInformation(String cardNumber, String expiryDate, String cvv) {
            // Perform validation logic
            // check the card number length, validate expiry date, and CVV
            // Return true if card information is valid, false otherwise
            return true;
        }
    }

    private class ExitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Logic to exit the application
            System.exit(0);
        }
    }

    private void saveDataToDatabase(String name, String phoneNumber, String seatClass) {
        // Database saving logic (same as previously provided)
    }

    private void performCalculations(String seatClass) {
        // Calculation logic (same as previously provided)
    }
}
