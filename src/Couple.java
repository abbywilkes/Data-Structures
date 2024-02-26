class Couple {
    //This initialized the couple class which draws on the person class
    private final Person bride;
    private final Person groom;
    //This establishes each person to a bride or a groom in the couple
    public Couple(Person bride, Person groom) {
        this.bride = bride;
        this.groom = groom;
    }
    //This gets the names of the bride and groom
    public Person getBride() {
        return bride;
    }

    public Person getGroom() {
        return groom;
    }
}