import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlightView {
    private JTextField nameField;
    private JTextField phoneNumberField;
    private JComboBox<String> seatClassComboBox;
    private JFrame frame;

    public FlightView() {
    	public void setConfirmButtonListener(ActionListener listener) {
            confirmButton.addActionListener(listener);
        }

        public void setPaymentFormButtonListener(ActionListener listener) {
            paymentFormButton.addActionListener(listener);
        }

        public void setExitButtonListener(ActionListener listener) {
            exitButton.addActionListener(listener);

        frame = new JFrame("Flight Reservation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberField = new JTextField();
        JLabel seatClassLabel = new JLabel("Seat Class:");
        String[] seatClasses = {"Economy", "Premium Economy", "Business", "First Class"};
        seatClassComboBox = new JComboBox<>(seatClasses);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(phoneNumberLabel);
        panel.add(phoneNumberField);
        panel.add(seatClassLabel);
        panel.add(seatClassComboBox);

        JButton confirmButton = new JButton("Confirm Reservation");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to handle confirmation button click
                String name = nameField.getText();
                String phoneNumber = phoneNumberField.getText();
                String seatClass = seatClassComboBox.getSelectedItem().toString();

                // Display confirmation dialog
                int result = JOptionPane.showConfirmDialog(frame, "Confirm Reservation?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    // Logic to handle payment form
                    displayPaymentForm();
                }
            }
        });

        panel.add(confirmButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void displayPaymentForm() {
        JFrame paymentFrame = new JFrame("Payment Form");
        paymentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paymentFrame.setSize(400, 200);

        JPanel paymentPanel = new JPanel();
        paymentPanel.setLayout(new GridLayout(3, 2));

        JLabel cardNumberLabel = new JLabel("Card Number:");
        JTextField cardNumberField = new JTextField();
        JLabel expiryLabel = new JLabel("Expiry Date:");
        JTextField expiryField = new JTextField();
        JLabel cvvLabel = new JLabel("CVV:");
        JTextField cvvField = new JTextField();

        paymentPanel.add(cardNumberLabel);
        paymentPanel.add(cardNumberField);
        paymentPanel.add(expiryLabel);
        paymentPanel.add(expiryField);
        paymentPanel.add(cvvLabel);
        paymentPanel.add(cvvField);

        JButton confirmPaymentButton = new JButton("Confirm Payment");
        confirmPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to handle payment confirmation
            	String name = getName();
                String phoneNumber = getPhoneNumber();
                String seatClass = getSeatClass();
                String cardNumber = cardNumberField.getText();
                String expiryDate = expiryField.getText();
                String cvv = cvvField.getText();
                saveDataToDatabase();
                performCalculations();

                ticketFrame.dispose();

                // Perform payment processing

                // After successful payment, display ticket details
                String ticketDetails = "Ticket Information:\n"
                        + "Name: " + getName() + "\n"
                        + "Phone Number: " + getPhoneNumber() + "\n"
                        + "Seat Class: " + getSeatClass() + "\n"
                        + "Flight Number: ABC123\n"
                        + "Seat Number: 10A\n"
                        + "Confirmation Number: 123456";

                displayTicketDetails(ticketDetails, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        paymentFrame.dispose();
                        frame.dispose();
                    }
                });
            }
        });

        paymentPanel.add(confirmPaymentButton);

        paymentFrame.add(paymentPanel);
        paymentFrame.setVisible(true);
    }
    
        public String getName() {
            return nameField.getText();
        }

        public String getPhoneNumber() {
            return phoneNumberField.getText();
        }

        public String getSeatClass() {
            return seatClassComboBox.getSelectedItem().toString();
        
    }

        displayTicketDetails("Ticket Information: ", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    public void displayTicketDetails(String ticketDetails, ActionListener exitButtonListener) {
        JFrame ticketFrame = new JFrame("Ticket Details");
        ticketFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ticketFrame.setSize(300, 200);

        JPanel ticketPanel = new JPanel();
        ticketPanel.setLayout(new GridLayout(2, 1));

        JLabel ticketLabel = new JLabel(ticketDetails);
        JButton exitButton = new JButton("Exit Portal");
        exitButton.addActionListener(exitButtonListener);

        ticketPanel.add(ticketLabel);
        ticketPanel.add(exitButton);

        ticketFrame.add(ticketPanel);
        ticketFrame.setVisible(true);
    }

    public void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FlightView();
            }
        });
    }
}
