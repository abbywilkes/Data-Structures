import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Creates the frame for the GUI
public class DemoPizza extends JFrame {
    //Creates the string of the toppings that can be selected
    private static final String[] TOPPINGS = {
            "Extra cheese", "Onions", "Peppers", "Olives", "Spinach",
            "Mushrooms", "Pepperoni", "Sausage", "Banana peppers", "Pineapple"
    };
    private static final int MAX_TOPPINGS = TOPPINGS.length;
    //Creates the check boxes, text area, calculate button and the delivery address field
    private JCheckBox[] toppingCheckBoxes;
    private JButton calculateButton;
    private JTextArea outputArea;
    private JCheckBox deliveryCheckBox;
    private JTextField deliveryAddressField;

    // Creates the frame so that when the toppings are selected it changes in teh panel and changes the price
    public DemoPizza() {
        setTitle("Pizza Order");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel instructions = new JLabel("Please select the toppings you would like on your pizza. If you would like delivery, please select delivery, input your address and calculate your total.");
        add(instructions);

        JPanel toppingPanel = new JPanel(new GridLayout(MAX_TOPPINGS, 1));
        toppingCheckBoxes = new JCheckBox[MAX_TOPPINGS];
        for (int i = 0; i < MAX_TOPPINGS; i++) {
            toppingCheckBoxes[i] = new JCheckBox(TOPPINGS[i]);
            toppingPanel.add(toppingCheckBoxes[i]);
        }

        //Creates the delivery panel so that people can choose if they want delivery or not

        JPanel deliveryPanel = new JPanel(new FlowLayout());
        deliveryCheckBox = new JCheckBox("Delivery");
        deliveryAddressField = new JTextField(20);
        deliveryAddressField.setEnabled(false);
        deliveryPanel.add(deliveryCheckBox);
        deliveryPanel.add(new JLabel("Delivery Address:"));
        deliveryPanel.add(deliveryAddressField);

        JPanel controlPanel = new JPanel(new GridLayout(3, 1));
        controlPanel.add(toppingPanel);
        controlPanel.add(deliveryPanel);

        //creates the calculate button
        calculateButton = new JButton("Calculate Total");
        controlPanel.add(calculateButton);

        //Creates the output area where the price and the string of toppings is shown
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        add(controlPanel);
        add(new JScrollPane(outputArea));

        //sets the background to pink for creativity
        getContentPane().setBackground(Color.PINK); // Set the background color to yellow

        //creating action listeners so that the delivery check changes the price and the output when selected
        deliveryCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deliveryAddressField.setEnabled(deliveryCheckBox.isSelected());
            }
        });
        //creates the calculate button action listener
        //so that it displays the price and the information input by the user when selected

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numToppings = 0;
                for (int i = 0; i < MAX_TOPPINGS; i++) {
                    if (toppingCheckBoxes[i].isSelected()) {
                        numToppings++;
                    }
                }

                Pizza pizza;
                if (numToppings > 0) {
                    String[] selectedToppings = new String[numToppings];
                    int index = 0;
                    for (int i = 0; i < MAX_TOPPINGS; i++) {
                        if (toppingCheckBoxes[i].isSelected()) {
                            selectedToppings[index++] = TOPPINGS[i];
                        }
                    }
                    pizza = new Pizza(selectedToppings, numToppings);
                } else {
                    pizza = new Pizza(new String[0], 0);
                }

                String output = "";
                if (deliveryCheckBox.isSelected()) {
                    String address = deliveryAddressField.getText();
                    pizza = new DeliveryPizza(pizza, address);
                    output += "Delivery Address: " + address + "\nDelivery Fee: $" + ((DeliveryPizza) pizza).getDeliveryFee() + "\n";
                }

                //If no toppings are selected, it just shows that it is a plain cheese pizza that is the base price
                if (numToppings > 0) {
                    output += "Toppings: " + pizza.toString() + "\n";
                } else {
                    output += "Cheese Pizza\n";
                }

                output += "Total Price: $" + pizza.calculatePrice();

                outputArea.setText(output);
            }
        });
        //Sets the size of the frame to fit all the components
        setSize(950, 800);  // Set the frame size
        setLocationRelativeTo(null);  // Center the frame on the screen
    }

    //runs the main method to display the code
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DemoPizza().setVisible(true);
            }
        });
    }
}
