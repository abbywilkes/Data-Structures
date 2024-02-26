import java.util.Scanner;

public class UseParty {
    //This initiatzes the UseParty class which prints the invitation and the number of guests for the party
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Party party = new Party();

        System.out.print("Enter number of guests for the party >> ");
        int numberOfGuests = scanner.nextInt();

        party.setNumberOfGuests(numberOfGuests);
        System.out.println("The party has " + party.getNumberOfGuests() + " guests");

        party.displayInvitation();

        scanner.close();
    }
}
