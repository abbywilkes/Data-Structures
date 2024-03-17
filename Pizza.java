import java.util.Arrays;

public class Pizza {
    //Establishes the parent Pizza class that has the set price and the additional prices of the toppings when added
    private static final int BASE_PRICE = 14;
    private static final int TOPPING_PRICE = 2;

    //counts the amount of toppings to change the price

    private String[] toppings;
    private int numToppings;
    private int price;

    //creates an array of the toppings and the number of toppings slected
    public Pizza(String[] toppings, int numToppings) {
        this.toppings = Arrays.copyOf(toppings, numToppings);
        this.numToppings = numToppings;
        this.price = calculatePrice();
    }
    //Gets the toppings
    public String[] getToppings() {
        return toppings;
    }
    //Gets the number of toppings
    public int getNumToppings() {
        return numToppings;
    }
    //Calculates the price based on the base price added with the number of toppings multiplied by 2
    public int calculatePrice() {
        return BASE_PRICE + numToppings * TOPPING_PRICE;
    }
    //Gets the price after it is calculated
    public int getPrice() {
        return price;
    }
    //Creates a string with the toppings that were selected and separates them with a comma
    public String toString() {
        StringBuilder description = new StringBuilder();
        description.append("Toppings: ");
        for (int i = 0; i < numToppings; i++) {
            description.append(toppings[i]);
            if (i < numToppings - 1) {
                description.append(", ");
            }
        }
        description.append("\nBase Price: $").append(BASE_PRICE);
        description.append("\nTopping Price: $").append(numToppings * TOPPING_PRICE);
        description.append("\nTotal Price (before delivery fee): $").append(price);
        return description.toString();
    }
}
