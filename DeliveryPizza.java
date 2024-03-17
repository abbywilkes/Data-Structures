//Inherits the pizza class attributes and adds information on delivery to change the price of the order
public class DeliveryPizza extends Pizza
{
    //determines the price of delivery if the price of the pizza if it is over or under $18
    private static final double DELIVERY_FEE_UNDER_18 = 5.0;
    private static final double DELIVERY_FEE_OVER_18 = 3.0;

    //Creates the delivery fee and address attributes
    private double deliveryFee;
    private String deliveryAddress;

    public DeliveryPizza(Pizza pizza, String deliveryAddress)
    {
        //takes the price of the pizza already established and determines the delivery fee if delivery is chosen
        super(pizza.getToppings(), pizza.getNumToppings());
        this.deliveryAddress = deliveryAddress;

        int totalPriceWithoutDelivery = super.calculatePrice();
        if (totalPriceWithoutDelivery > 18) {
            this.deliveryFee = DELIVERY_FEE_OVER_18;
        } else {
            this.deliveryFee = DELIVERY_FEE_UNDER_18;
        }
    }

    public double getDeliveryFee()
    {
        //gets the delivery fee
        return deliveryFee;
    }

    @Override
    //Overrides the price in the Pizza file with the price including the delivery fee
    public int calculatePrice()
    {
        //calculates the price with the determined delivery fee included
        return super.calculatePrice() + (int) deliveryFee;
    }

    public String toString()
    {
        //creates a string with the delivery fee cost and the address
        return super.toString() + "\nDelivery Address: " + deliveryAddress + "\nTotal Price: $" + calculatePrice();
    }
}
