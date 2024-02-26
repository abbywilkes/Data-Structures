import javax.swing.*;
import java.awt.*;

public class UseDinnerParty {
    //Initializes the Use Dinner Party function with the GUI
    public static void main(String[] args) {
        // Creates the frame that has the text boxes and outputs
        JFrame frame = new JFrame("Dinner Party Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        JPanel panel = new JPanel();
        frame.add(panel);

        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);

        // Create text fields and labels for the guests
        JLabel partyLabel = new JLabel("Enter number of guests for the party:");
        partyLabel.setForeground(Color.PINK);
        partyLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        JTextField partyField = new JTextField(10);

        JLabel dinnerLabel = new JLabel("Enter number of guests for the dinner party:");
        JTextField dinnerField = new JTextField(10);
        dinnerLabel.setForeground(Color.BLUE);
        dinnerLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel dinnerChoiceLabel = new JLabel("Enter the menu option (1 for Chicken or 2 for Vegetarian):");
        JTextField dinnerChoiceField = new JTextField(10);
        dinnerChoiceLabel.setForeground(Color.RED);
        dinnerChoiceLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        panel.add(partyLabel);
        panel.add(partyField);
        panel.add(dinnerLabel);
        panel.add(dinnerField);
        panel.add(dinnerChoiceLabel);
        panel.add(dinnerChoiceField);

        // Creates a button to submit the inputs
        JButton submitButton = new JButton("Create Invitation");
        panel.add(submitButton);

        // Creates a text area for the output
        JTextArea outputArea = new JTextArea(5, 20);
        panel.add(outputArea);

        frame.setVisible(true);

        // Makes sure the button can be clicked and delivers output
        submitButton.addActionListener(e -> {
            Party party = new Party();
            DinnerParty aDinnerParty = new DinnerParty();

            // Parse input values from the text boxes
            int partyGuests = Integer.parseInt(partyField.getText());
            party.setNumberOfGuests(partyGuests);

            int dinnerGuests = Integer.parseInt(dinnerField.getText());
            aDinnerParty.setNumberOfGuests(dinnerGuests);

            int dinnerChoice = Integer.parseInt(dinnerChoiceField.getText());
            aDinnerParty.setDinnerChoice(dinnerChoice);

            // Display output on the bottom of the frame
            outputArea.setText(
                    "\n" + "The party has " + party.getNumberOfGuests() + " guests\n" +
                            "The dinner party has " + aDinnerParty.getNumberOfGuests() + " guests\n" +
                            "Menu option " + aDinnerParty.getDinnerChoice() + " will be served\n" +
                            "Please come to my party!"
            );
        });
    }
}
