public class Party {
    //Initializes the party class with number of guests (using get and set)
    private int numberOfGuests;

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void displayInvitation() {
        System.out.println("Please come to my party!");
    }
}
