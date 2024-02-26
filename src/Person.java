class Person {
    //This intializes the person class, which gives a person a first and last name
    private String firstName;
    private String lastName;
    //This puts the name into one string for the person
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //These individually get the first and last names of a person
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}