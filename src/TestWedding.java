import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

public class TestWedding {
    //This allows for the information to considered important and to be used for inputting in the GUI
    private static JTextField brideFirstNameField;
    private static JTextField brideLastNameField;
    private static JTextField groomFirstNameField;
    private static JTextField groomLastNameField;
    private static JTextField weddingDateField;
    private static JTextField locationField;

    private static JLabel weddingLabel;

    public static void main(String[] args) {
        //This initializes the frame as well as adds the label in pink (which is my creativity)
        JFrame frame = new JFrame("Wedding Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new GridLayout(7, 2));

        weddingLabel = new JLabel("Please input your wedding information!");
        weddingLabel.setForeground(Color.PINK);
        weddingLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        brideFirstNameField = new JTextField();
        brideLastNameField = new JTextField();
        groomFirstNameField = new JTextField();
        groomLastNameField = new JTextField();
        weddingDateField = new JTextField();
        locationField = new JTextField();

        frame.add(new JLabel("Bride's Name:"));
        frame.add(brideFirstNameField);
        frame.add(new JLabel("Bride's Last Name:"));
        frame.add(brideLastNameField);
        frame.add(new JLabel("Groom's First Name:"));
        frame.add(groomFirstNameField);
        frame.add(new JLabel("Groom's Last Name:"));
        frame.add(groomLastNameField);
        frame.add(new JLabel("Wedding Date (yyyy-MM-dd):"));
        frame.add(weddingDateField);
        frame.add(new JLabel("Location:"));
        frame.add(locationField);
        frame.add(weddingLabel);
        //This adds all the features to the frame

        JButton submitButton = new JButton("Submit");
        //Added an action listener so the button can be pressed and will input the info
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayWeddingDetails();
            }
        });
        frame.add(submitButton);
        frame.setVisible(true);
    }

    private static void displayWeddingDetails() {
        //This creates the separate display with all the wedding information
        String brideFirstName = brideFirstNameField.getText();
        String brideLastName = brideLastNameField.getText();
        String groomFirstName = groomFirstNameField.getText();
        String groomLastName = groomLastNameField.getText();
        LocalDate weddingDate = LocalDate.parse(weddingDateField.getText());
        String location = locationField.getText();

        //This formats the date (another creativity) to make it the spelled out
        //version of the date rather than with dashes
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        String formattedDate = weddingDate.format(formatter);

        Person bride = new Person(brideFirstName, brideLastName);
        Person groom = new Person(groomFirstName, groomLastName);
        Couple couple = new Couple(bride, groom);
        Wedding wedding = new Wedding(couple, weddingDate, location);

        //This creates the pop-up window with all the information about the wedding in a full sentence
        JOptionPane.showMessageDialog(null, "Congratulations!\n" +
                "On " + formattedDate + ", "+ "\n" + bride.getFirstName() + " " + bride.getLastName() + " and "
                + groom.getFirstName() + " " + groom.getLastName() + "\n" +
                "will be married at " + location + "." );
    }
}
