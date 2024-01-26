
import java.util.Scanner;
public class MoneyConverter {
    public static int quarters(int total) {
        return total / 25;
    }
    public static int dimes(int total) {
        return (total - quarters(total) * 25) / 10;
    }
    public static int nickels(int total) {
        return ((total - quarters(total) * 25) - (dimes(total) * 10)) / 5;
    }
    public static int pennies(int total) {
        return total % 5;
    }
    public static void main(String[] args) {
        Scanner change = new Scanner(System.in);
        String total;
        int intTotal;
        System.out.println("This program determines the change given in the smallest amount of coins for any amount of money. " +
                "Please input below the amount of money you would like to convert.");
        System.out.println("Total amount in dollars and cents:");
        total = change.next();

        total = total.replace(".", "");
        intTotal = Integer.parseInt(total);

        if (quarters(intTotal) == 1)
            System.out.print(quarters(intTotal) + " Quarter, ");
        else
            System.out.print(quarters(intTotal) + " Quarters,");

        if (dimes(intTotal) == 1)
            System.out.print(dimes(intTotal) + " Dime, ");
        else
            System.out.print(dimes(intTotal) + " Dimes, ");

        if (nickels(intTotal) == 1)
            System.out.print(nickels(intTotal) + " Nickel, ");
        else
            System.out.print(nickels(intTotal) + " Nickels, ");

        if (pennies(intTotal) == 1)
            System.out.print(pennies(intTotal) + " Penny.");
        else
            System.out.print(pennies(intTotal) + " Pennies.");
        ;

    }
}