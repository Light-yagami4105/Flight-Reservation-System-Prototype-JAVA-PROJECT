public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Flight model = new Flight(); // Initialize Flight object with appropriate data
                FlightView view = new FlightView();
                FlightController controller = new FlightController(model, view);

                controller.initializeController(); // Set up event listeners for view components
            }
        });
    }
}
