import java.time.LocalDate;
class Wedding {
    //This establishes the wedding class using the Couple class, giving a location and a date.
    private Couple couple;
    private LocalDate weddingDate;
    private String location;

    //This sets the wedding information up
    public Wedding(Couple couple, LocalDate weddingDate, String location) {
        this.couple = couple;
        this.weddingDate = weddingDate;
        this.location = location;
    }
    //This gets all the features of the code and classes used before to set up the wedding
    public Couple getCouple() {
        return couple;
    }

    public LocalDate getWeddingDate() {
        return weddingDate;
    }

    public String getLocation() {
        return location;
    }
}
