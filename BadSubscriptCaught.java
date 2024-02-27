import java.util.Scanner;

public class BadSubscriptCaught {
    public static void main(String[] args) {
        String[] names = {"Leo", "Zoe", "Daniel", "Zeke", "Renee", "North", "Jack", "Jasper", "Gracie", "Abby"};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the position of the name you want to display (0-9): ");
        try {
            int index = scanner.nextInt();
            System.out.println("Name at " + index + " is: " + names[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index is out of range. Please enter a number between 0 and 9.");
        }
    }
}
