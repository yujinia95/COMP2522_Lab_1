package ca.bcit.comp2522.bank;

/**
 * This class models a bank client's information.
 * Firstly, it extends the Person Class
 * Secondly, Validate the range of clientID from six to seven digits.
 * Thirdly, Adding more information (name,life status, sign up date, client ID) in the getDetails() method
 * This class will print out all information above in String.
 * @author Gem Baojimin sha
 * @author Yujin Jeong
 * @version 1.0
 */
public class BankClient extends Person {

    // Creating a static variable to limit the number of letter for name.
    private static final int MIN_CLIENT_ID = 6;
    private static final int MAX_CLIENT_ID = 7;

    // Creating variables to set sing-up date and clientID.
    private final Date      signupDate;
    private final String    clientID;

    /**
     * Creating a constructor.
     * @param name     variable from Person class
     * @param dateDied variable from Person class
     * @param signupDate will be assigned to the instance data: signupDate
     * @param clientID will be assigned to the instance data: clientID
     */
    public BankClient(final Name name, final Date dateBorn, final Date dateDied, final Date signupDate
            , final String clientID) {

        super(name,dateBorn, dateDied);

        isClientIdValid(clientID);

        this.signupDate = signupDate;
        this.clientID = clientID;
    }

    /**
     * Creating a getter to get access to private variable in Name class.
     * @return sign up date to use method in BankAccount
     */
    public Date getSignupDate() {
        return signupDate;
    }

    /**
     * Overriding getDetails() method from Person class.
     * Printing client's information (name, clientID, life status, sign-up date)
     * e.g.: Tiger Woods client #12345 (alive) joined the bank on thursday, September 3, 2020")
     * [note: or “not alive” as the case may be]
     * @return client's information in String
     */
    @Override
    public String getDetails() {

        final StringBuilder builder;

        builder = new StringBuilder();

        builder.append(getName().getFullName());
        builder.append(" client #");
        builder.append(clientID);
        builder.append(isAlive()? " (alive)": " (not alive)");
        builder.append(" joined the bank on ");
        builder.append(signupDate.getDayOfTheWeek());
        builder.append(", ");
        builder.append(signupDate.getDateInString());

        return builder.toString();
    }

    /**
     * Creating a method validating the number of digits for clientID.
     * @param clientID check if the range of clientID is valid
     */
    public static void isClientIdValid(final String clientID) {

        if (clientID.length() < MIN_CLIENT_ID || clientID.length() > MAX_CLIENT_ID) {
            throw new IllegalArgumentException(String.format("You must enter the clientID between %d to %d digits",
                    MIN_CLIENT_ID, MAX_CLIENT_ID));
        }
    }

}
