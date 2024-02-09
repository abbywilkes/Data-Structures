import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


abstract class PizzaApplication extends JFrame implements ItemListener
{
    //Establish the PizzaApplication Class and create the window
    JComboBox<String> sizeComboBox;
    JCheckBox pepperoni, mushrooms, onions, extraCheese;
    JButton calculateButton;
    JLabel priceLabel;
    //This is the constructor for the class that applies the formatting and the functions to the new frame
    private PizzaApplication() throws FontFormatException {
        setTitle("Order a Big Y Pizza");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 1));
        main();
        addListeners();
        setVisible(true);
    }

    private void main() throws FontFormatException
    {
        //This method creates the Combo Box selection option for the sizes of pizza, and the selectable topping buttons
        //This also establishes the price and the calculate button
        //It also sets a font size and color for teh price button (creativity)
        String[] sizeOptions = {"Small ($5)", "Medium ($10)", "Large ($15)", "Super ($20)"};
        sizeComboBox = new JComboBox<>(sizeOptions);
        pepperoni = new JCheckBox("Pepperoni");
        mushrooms = new JCheckBox("Mushrooms");
        onions = new JCheckBox("Onions");
        extraCheese = new JCheckBox("Extra Cheese (No Cost)");

        calculateButton = new JButton("Calculate Price");
        priceLabel = new JLabel("Price: $0.00");
        priceLabel.setForeground(Color.PINK);

        priceLabel.setFont(new Font("Helvetica", Font.BOLD, 25));

        //This adds all the features into the layout and pop-up screen that was made in the previous method
        add(sizeComboBox);
        add(extraCheese);
        add(pepperoni);
        add(mushrooms);
        add(onions);
        add(calculateButton);
        add(priceLabel);
    }

    private void addListeners()
    {
        //This method makes sure that the calculate button listens to the selection of other buttons and performs its task
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculatePrice();
            }
        });
    }

    public void calculatePrice()
    {
        //This sets up the function to calculate the right price based on size and topping selections
        double basePrice = switch (sizeComboBox.getSelectedIndex()) {
            // Small
            case 0 ->
                    5.0;
            // Medium
            case 1 ->
                    10.0;
            // Large
            case 2 ->
                    15.0;
            // Super
            case 3 ->
                    20.0;
            default -> 0;
        };

        double addToppingsCost = 0.5 * toppingsCounter();
        // Adjust topping cost based on the number of toppings
        if (toppingsCounter() == 3) {
            addToppingsCost = 1.25;
        } else if (toppingsCounter() == 2) {
            addToppingsCost = 1.0;
        }

        //Returns the total cost with the right decimal percentage
        double totalCost = basePrice + addToppingsCost;
        priceLabel.setText("Price: $" + String.format("%.2f", totalCost));
    }

    private int toppingsCounter()
    {
        //This method counts the amount of toppings that are selected so the customer can get charged accordingly in the previous method
        int count = 0;
        if (pepperoni.isSelected()) count++;
        if (mushrooms.isSelected()) count++;
        if (onions.isSelected()) count++;
        return count;
    }

    public static void main(String[] args)
    {
        //This main method actually runs the code and ensures that the pizza application returns the right price
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PizzaApplication() {
                        @Override
                        public void itemStateChanged(ItemEvent e) {

                        }
                    };
                } catch (FontFormatException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
