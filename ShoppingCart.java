import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

class Item {
    // Initializes the item class that contains a name and price
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
    //gets the name and price after they are set
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}


class ItemOrder {
    // Adds the quantity to the item which contains the name and price already
    private Item item;
    private int quantity;

    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
    //Gets the price and multiplies it by the quantity to determine the actual price of all the same items
    public double getPrice() {
        return item.getPrice() * quantity;
    }
    //Sets the quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}

class ShoppingCarts {
    //creates the array list of the shopping cart that contains the item and each name, price and quantity
    private ArrayList<ItemOrder> orders;

    public ShoppingCarts() {
        orders = new ArrayList<>();
    }

    public void addItem(ItemOrder order) {
        orders.add(order);
    }

    public void removeItem(ItemOrder order) {
        orders.remove(order);
    }

    public double getTotalPrice() {
        //Gets the total price of all the items based on their individual prices
        double totalPrice = 0;
        for (ItemOrder order : orders) {
            totalPrice += order.getPrice();
        }
        BigDecimal bd = new BigDecimal(Double.toString(totalPrice));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public ItemOrder searchItem(String itemName) {
        for (ItemOrder order : orders) {
            if (order.getItem().getName().equals(itemName)) {
                return order;
            }
        }
        return null;
    }
    public ArrayList<ItemOrder> getOrders() {
        //this gets the orders from the larger array list
        return orders;
    }
}

public class ShoppingCart extends JFrame {
    //This creates the frame with instructions on how to use the application
    private ShoppingCarts cart;
    private JTextArea textArea;

    public ShoppingCart() {
        //This creates the GUI for the Shopping Cart with buttons to add and remove items, or get the total price
        cart = new ShoppingCarts();
        textArea = new JTextArea(20, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JLabel titleLabel = new JLabel("To begin creating your grocery list, please click 'Add Item' to input the name, the price and the quantity.");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton addButton = new JButton("Add Item");
        JButton removeButton = new JButton("Remove Item");
        JButton totalPriceButton = new JButton("Total Price");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Enter item name:");
                double price = Double.parseDouble(JOptionPane.showInputDialog("Enter item price (do not include $ symbol):"));
                int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter item quantity:"));
                Item item = new Item(name, price);
                ItemOrder order = new ItemOrder(item, quantity);
                cart.addItem(order);
                updateTextArea();
            }
        });

        //Adding action listeners to the code to create the buttons that make message frames pop up
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog("Enter item name to remove:");
                ItemOrder order = cart.searchItem(name);
                if (order != null) {
                    cart.removeItem(order);
                    updateTextArea();
                } else {
                    JOptionPane.showMessageDialog(null, "Item not found in cart.");
                }
            }
        });

        totalPriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Total price: $" + cart.getTotalPrice());
            }
        });

        //Creates the button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(totalPriceButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("Shopping Cart");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    //This updates the frame when items are added or removed so that the user can see their shopping cart
    private void updateTextArea() {
        textArea.setText("");
        for (ItemOrder order : cart.getOrders()) {
            textArea.append(order.getItem().getName() + " - Quantity: " + order.getQuantity() + " - Price: $" + order.getPrice() + "\n");
        }
    }
    //Creates the shopping cart object
    public static void main(String[] args) {
        new ShoppingCart();
    }
}
