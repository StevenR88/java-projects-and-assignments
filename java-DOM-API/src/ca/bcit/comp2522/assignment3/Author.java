package ca.bcit.comp2522.assignment3;

public class Author {
    private String firstName;
    private String lastName;

    /**
     * Constructor for Author object.
     * @param newFirstName as a string
     * @param newLastName as a string
     */
    public Author(final String newFirstName, final String newLastName) {
        firstName = newFirstName;
        lastName = newLastName;
    }

    /**
     * Getter for firstName variable.
     * @return firstName variable
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for firstName variable.
     * @param newFirstName as a string
     */
    public void setFirstName(final String newFirstName) {
        firstName = newFirstName;
    }

    /**
     * Getter for lastName variable.
     * @return lastName variable
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for lastName variable.
     * @param newLastName as a string
     */
    public void setLastName(final String newLastName) {
        lastName = newLastName;
    }
}
