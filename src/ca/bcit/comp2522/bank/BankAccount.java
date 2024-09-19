package ca.bcit.comp2522.bank;

/**
 * This class models a bank client's information
 * Firstly, it has two different print String methods. First one, getDetails() prints name, account balance
 * , account number, account open date, account close date(if applicable). Second one, printTransaction() prints
 * Personal Information Number(PIN), Account balance, withdrew amount.
 * Secondly, this class also validates if PIN is valid, account number is valid and account balanceUSD is valid.
 * Thirdly, has deposit method to ensure client can deposit correct amount of money
 * Lastly, has two overriding methods withdraw. First method ensuring withdraw correct amount of money, and second
 * method ensure that PIN is matched before withdraw.
 * @author Gem Baojimin sha
 * @author Yujin Jeong
 * @version 1.0
 */
public class BankAccount {

    // Creating static variables to set range of PIN
    private static final int MIN_PIN_VALUE = 0;
    private static final int MAX_PIN_VALUE = 9999;


    // Creating static variables to set default balance in bank account
    private static final double MIN_BALANCE_USD = 0.00;

    // Creating variables to set bank client's basic information
    private final BankClient client;
    private final int pin;
    private final String accountNumber;
    private final Date accountCloseDate;
    private double withdrewAmount;
    private double balanceUsd;
    private final String sex;


    /**
     * Creating a constructor
     * @param client the BankClient associated with this account.
     * @param balanceUsd the initial balance of the account in USD.
     * @param pin the 4-digit PersOnal Information Number(PIN) for account.
     * @param accountNumber client's bank account number.
     * @param sex the gender of the client.
     * @param accountCloseDate client's account close date
     */
    public BankAccount( final BankClient client, final double balanceUsd, final int pin, final String accountNumber
            , final String sex, final Date accountCloseDate, final double withdrewAmount){
        isPinValid(pin);
        isAccountNumValid(accountNumber);
        isBalanceUsdValid(balanceUsd);
        this.client = client;
        this.balanceUsd = balanceUsd;
        this.pin = pin;
        this.accountNumber = accountNumber;
        this.sex = sex;
        this.accountCloseDate = accountCloseDate;
        this.withdrewAmount = withdrewAmount;
    }

    /*
     * Creating a method to check if PIN is in the correct range.
     * @param pin the 4-digit PIN for account.
     * @throws IllegalArgumentException if PIN is invalid
     */
    private static void isPinValid(final int pin) throws IllegalArgumentException{
        if(pin < MIN_PIN_VALUE || pin > MAX_PIN_VALUE) {
            throw new IllegalArgumentException(String.format("Invalid %d", pin));
        }
    }

    /*
     * Creating a method to check if account number is valid.
     * @param accountNumber accept minimum 6 to 7 length
     * @throws IllegalArgumentException if the range of account number is out of range
     */
    private static void isAccountNumValid(final String accountNumber) throws IllegalArgumentException{
        final int min_length = 6;
        final int max_length = 7;
        if(accountNumber == null || accountNumber.length() < min_length || accountNumber.length() > max_length) {
            throw new IllegalArgumentException(String.format("Invalid %s", accountNumber));
        }
    }

    /*
     * Creating a method to check if the bank account balance is correct.
     * @param balanceUsd accept over 00.00
     * @throws IllegalArgumentException if the balance is less than minimum balance
     */
    private static void isBalanceUsdValid(final double balanceUsd) throws IllegalArgumentException {
        if (balanceUsd < MIN_BALANCE_USD) {
            throw new IllegalArgumentException(String.format("Invalid %.2f",balanceUsd));
        }
    }

    /*
     * Creating a method to check if desired deposit money is more than $00.00 then
     * proceed deposit.
     * @param amountUsd amount of Usd to deposit
     * @throws IllegalArgumentException if desired deposit money is less than $0
     */
    private void deposit(final double amountUsd) throws IllegalArgumentException{
        if (amountUsd <= MIN_BALANCE_USD) {
            throw new IllegalArgumentException(String.format("Deposit amount must be greater than $%.2f.", balanceUsd));
        }
        balanceUsd += amountUsd;
    }

    /*
     * Creating a method to check if desired withdrawal money is more than $00.00 and less than bank balance.
     * @param amountUsd amount of Usd to withdraw
     * @throws IllegalArgumentException if desired withdraw money is less than $.
     * @throws IllegalArgumentException if desired deposit money is more than balance
     */
    private void withdraw(final double amountUsd) throws IllegalArgumentException{
        if (amountUsd <= MIN_BALANCE_USD) {
            throw new IllegalArgumentException(String.format("The withdrawal amount must be greater than $%.2f.",
                    MIN_BALANCE_USD));
        }
        if (amountUsd > balanceUsd) {
            throw new IllegalArgumentException(String.format("The withdrawal amount exceeds your $%.2f", balanceUsd));
        }
        balanceUsd -= amountUsd;
        withdrewAmount = amountUsd;
    }

    /**
     * Creating a method to check if the PIN is matched. If PIN is matched then allow client
     * withdraws money more than $00.00 and less than bank balance.
     * @param amountUsd amount of Usd to withdraw
     * @param pinToMatch checking PIN is matched
     * @throws IllegalArgumentException if PIN is invalid
     * @throws IllegalArgumentException if desired deposit money is less than $0
     * @throws IllegalArgumentException if desired deposit money is more than balance
     */
    private void withdraw(final double amountUsd, final int pinToMatch) throws IllegalArgumentException {
        if(pinToMatch != pin) {
            throw new IllegalArgumentException("Pin is not matched correctly");
        }
        if (amountUsd <= MIN_BALANCE_USD) {
            throw new IllegalArgumentException(String.format("The withdrawal amount must be greater than $%.2f."

                    , MIN_BALANCE_USD));
        }
        if (amountUsd > balanceUsd) {
            throw new IllegalArgumentException(String.format("The withdrawal amount exceeds your $%.2f", balanceUsd));
        }
        balanceUsd -= amountUsd;
        withdrewAmount = amountUsd;
    }

    /*
     * Creating a method to validate client's gender (Used for change the String "His/Her" in getDetails())
     * @param sex client's gender
     * @return true if gender is male
     */
    private static boolean isMale(final String sex) {
        return sex.equals("Male");
    }

    /*
     * Creating a method to validate client's gender (Used for change the String "His/Her" in getDetails())
     * @param sex client's gender
     * @return true if gender is female
     */
    private static boolean isFemale(final String sex) {
        return sex.equals("Female");
    }

    /*
     * Creating a method to validate if account is not close (Still open).
     * @param accountCloseDate is null then still open
     * @return true if still open
     */
    private boolean isNotClosed(final Date accountCloseDate) {
        return accountCloseDate == null;
    }

    /**
     * Creating a method to print client's information (Name, account balance, account number, account open date
     * , account close date(if applicable).
     * e.g. Albert Einstein had $900 USD in account #abc123 which he opened on Monday January 1, 1900 and
     * closed Saturday October 14, 1950.
     * @return client's information in String
     */
    public String getDetails() {
        StringBuilder builder1;
        builder1 = new StringBuilder();

        builder1.append(client.getName().getFullName());
        builder1.append(" had $");
        builder1.append(String.format("%.0f",balanceUsd));
        builder1.append( "USD in account #");
        builder1.append(accountNumber);
        builder1.append(" which");
        builder1.append(isMale(sex)? " he" : isFemale(sex)? " she" : "No gender has typed");
        builder1.append(" opened on ");
        builder1.append(client.getSignupDate().getDayOfTheWeek());
        builder1.append(" ");
        builder1.append(client.getSignupDate().getDateInString());
        builder1.append(" and");
        builder1.append(isNotClosed(accountCloseDate)? " is still open.": " closed ");
        if(!isNotClosed(accountCloseDate)) {
            builder1.append(accountCloseDate.getDayOfTheWeek());
            builder1.append(" ");
            builder1.append(accountCloseDate.getDateInString());
        }

        return builder1.toString();
    }

    /**
     * Creating a method to print client's information(PIN, Account balance, withdrew amount).
     * e.g. His BankAccount (pin 4664) had $2000 in it, then withdraw $200.
     * @return client's information in String
     */
    public String printTransaction() {
        StringBuilder builder2;
        builder2 = new StringBuilder();

        builder2.append(isMale(sex)? "His" : isFemale(sex)? "Her" : "No gender has typed");
        builder2.append(" BankAccount (pin ");
        builder2.append(pin);
        builder2.append(") had $");
        builder2.append(String.format("%.0f",balanceUsd));
        builder2.append(" in it, ");
        builder2.append("then withdraw $");
        builder2.append(String.format("%.0f",withdrewAmount));
        builder2.append(".");

        return builder2.toString();
    }
}