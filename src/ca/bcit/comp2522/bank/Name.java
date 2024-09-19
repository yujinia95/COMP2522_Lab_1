package ca.bcit.comp2522.bank;

/**
 * This class combines a Name with a first and last name.
 * Firstly, this class provides functionality to retrieve initials, full name, and reverse.
 * Secondly, validating the name if we have corrected letter size of name. Also, it checks to make sure that
 * nobody access in the program as admin by typing "admin"
 * @author Gem Baojimin sha
 * @author Yujin Jeong
 * @version 1.0
 */
public class Name {

    // Creating a static variable to limit the number of letter for name.
    private static final int MAX_NAME_LENGTH = 45;

    // Creating variables to set first name and last name
    private final String firstName;
    private final String lastName;

    // Creating variables to truncate index for to set name as capital letter for first letter of first name and last
    // name and lower case for rest of the names
    private final int nameIndexZero =   0;
    private final int nameIndexOne =    1;

    /**
     * Constructs a Name object with a specified first and last name.
     * Throws an IllegalArgumentException if the first name or last name is invalid
     * (e.g. null, blank, not the required length, or contains "admin").
     *
     * @param firstName the first name of the person.
     * @param lastName the last name of the person.
     * @throws IllegalArgumentException if the name is invalid.
     */
    public Name(final String firstName,final String lastName) {
        validateFirstName(firstName);
        validateLastName(lastName);

        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Getter that returns the first name.
     * @return the first name.
     */
    public String getFirst() {

        return firstName;
    }

    /**
     * Getter that returns the last name.
     * @return the last name.
     */
    public String getLast() {

        return lastName;
    }

    /**
     * Creating a method that returns the initials of the first and last name in uppercase.
     * @return the initials in the format "F.L.".
     */
    public String getInitials() {

        return firstName.substring(nameIndexZero, nameIndexOne).toUpperCase() + "."
                + lastName.substring(nameIndexZero, nameIndexOne).toUpperCase() + ".";
    }

    /**
     * Creating a method that returns the full name in uppercase for first letter of first name and last name, and rest
     * letters in lowercase.
     * @return the full name
     */
    public String getFullName() {

          return firstName.substring(nameIndexZero, nameIndexOne).toUpperCase() +
                  firstName.substring(nameIndexOne).toLowerCase() + " "
                + lastName.substring(nameIndexZero, nameIndexOne).toUpperCase() +
                  lastName.substring(nameIndexOne).toLowerCase();
    }

    /**
     * Prints the reverse of the full name.
     * @return reverse full name
     */
    public String getReverseName(){

        final int startIndex;
        final int decrementValue;
        final String fullName = getFullName();
        final StringBuilder reverseFullName;

        startIndex =        1;
        decrementValue  =   1;
        reverseFullName =   new StringBuilder();

        for( int i = fullName.length() - startIndex; i >= decrementValue; i--) {
            reverseFullName.append(fullName.charAt(i));
        }

        return reverseFullName.toString();
    }

    /*
     * Creating a method to check if first name is valid (No null, no blank space, no more than 45 letters)
     * @param firstName first name validation check
     */
    private static void validateFirstName(final String firstName) {

        if (firstName == null || firstName.isBlank() || firstName.length() > MAX_NAME_LENGTH ||
                firstName.toLowerCase().contains("admin")) {

            throw new IllegalArgumentException("bad account First Name: " + firstName);

        }
    }

    /*
     * Creating a method to check if last name is valid (No null, no blank space, no more than 45 letters)
     * @param lastName last name validation check
     */
    private static void validateLastName(final String lastName) {

        if (lastName == null || lastName.isBlank() || lastName.length() > MAX_NAME_LENGTH ||
                lastName.toLowerCase().contains("admin")) {

            throw new IllegalArgumentException("bad account Last Name: " + lastName);

        }
    }

    }

