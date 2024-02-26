public class DinnerParty extends Party {
    //Inherits the party class and sets a dinner choice and gets the dinner choice
    private int dinnerChoice;

    public void setDinnerChoice(int dinnerChoice) {
        this.dinnerChoice = dinnerChoice;
    }

    public int getDinnerChoice() {
        return dinnerChoice;
    }
}
