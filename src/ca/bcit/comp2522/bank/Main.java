package ca.bcit.comp2522.bank;

/**
 * Creating a driver class to test the program(running Date,Name,Person,BankClient,BankAccount class).
 * @author Gem Baojimin sha
 * @author Yujin Jeong
 * @version 1.0
 */
public class Main {

    /**
     * This the program.
     * @param args unused
     */
    public static void main(final String[] args) {

        // Declaring variables to set gender
        final String sexM = "Male";
        final String sexF = "Female";

        // Declare variables to print Albert Einstein's banking information
        final Name albertName;
        final Date albertDateBorn;
        final Date albertDateDied;
        final Date albertSignupDate;
        final Date albertCloseDate;
        final Person albertPerson;
        final BankClient albertBankClient;
        final BankAccount albertBankAccount;
        final String albertAccountNumb;
        final int albertPin;
        final double albertAccountBalance;
        final double albertWithdrawAmount;

        // Declare variables to print Nelson Mandela's banking information
        final Name nelsonName;
        final Date nelsonDateBorn;
        final Date nelsonDateDied;
        final Date nelsonSignupDate;
        final Person nelsonPerson;
        final BankClient nelsonBankClient;
        final BankAccount nelsonBankAccount;
        final String nelsonAccountNumb;
        final int nelsonPin;
        final double nelsonAccountBalance;
        final double nelsonWithdrawAmount;

        // Declare variables to print Frida Kahlo's banking information
        final Name kahloName;
        final Date kahloDateBorn;
        final Date kahloDateDied;
        final Date kahloSignupDate;
        final Date kahloCloseDate;
        final Person kahloPerson;
        final BankClient kahloBankClient;
        final BankAccount kahloBankAccount;
        final String kahloAccountNumb;
        final int kahloPin;
        final double kahloAccountBalance;
        final double kahloWithdrawAmount;

        // Declare variables to print Jackie Chan's banking information
        final Name jackieName;
        final Date jackieDateBorn;
        final Date jackieSignupDate;
        final Person jackiePerson;
        final BankClient jackieBankClient;
        final BankAccount jackieBankAccount;
        final String jackieAccountNumb;
        final int jackiePin;
        final double jackieAccountBalance;
        final double jackieWithdrawAmount;


        // Instantiate to print Albert Einstein's banking information
        albertName = new Name("Albert", "Einstein");
        albertDateBorn = new Date(1879, 3, 14);
        albertDateDied = new Date(1955, 4, 18);
        albertSignupDate = new Date(1900, 1, 1);
        albertCloseDate = new Date(1950,10,14);
        albertPerson = new Person(albertName, albertDateBorn, albertDateDied);
        albertAccountNumb = "abc123";
        albertPin = 3141;
        albertAccountBalance = 1000;
        albertWithdrawAmount = 100;
        albertBankClient = new BankClient(albertName, albertDateBorn, albertDateDied, albertSignupDate, albertAccountNumb);
        albertBankAccount = new BankAccount(albertBankClient, albertAccountBalance, albertPin, albertAccountNumb, sexM, albertCloseDate
                ,albertWithdrawAmount);

        // Instantiate to print Nelson Mandela's banking information
        nelsonName = new Name("Nelson", "Mandela");
        nelsonDateBorn = new Date(1918, 7, 18);
        nelsonDateDied = new Date(2013, 12, 5);
        nelsonSignupDate = new Date(1994, 5, 10);
        nelsonAccountNumb= "654321";
        nelsonPin = 4664;
        nelsonAccountBalance = 2000;
        nelsonWithdrawAmount = 200;
        nelsonPerson = new Person(nelsonName, nelsonDateBorn, nelsonDateDied);
        nelsonBankClient = new BankClient(nelsonName, nelsonDateBorn, nelsonDateDied, nelsonSignupDate, nelsonAccountNumb);
        nelsonBankAccount = new BankAccount(nelsonBankClient, nelsonAccountBalance, nelsonPin, nelsonAccountNumb, sexM, null
                , nelsonWithdrawAmount);

        // Instantiate to print Frida Kahlo's banking information
        kahloName = new Name("Frida", "Kahlo");
        kahloDateBorn = new Date(1907, 7, 6);
        kahloDateDied = new Date(1954, 7, 13);
        kahloSignupDate = new Date(1940, 1, 1);
        kahloCloseDate = new Date(1954,7,13);
        kahloAccountNumb = "frd123";
        kahloPin = 1907;
        kahloAccountBalance = 500;
        kahloWithdrawAmount = 50;
        kahloPerson = new Person(kahloName, kahloDateBorn, kahloDateDied);
        kahloBankClient = new BankClient(kahloName, kahloDateBorn, kahloDateDied, kahloSignupDate, kahloAccountNumb);
        kahloBankAccount = new BankAccount(kahloBankClient, kahloAccountBalance, kahloPin, kahloAccountNumb, sexF, kahloCloseDate
                , kahloWithdrawAmount);

        // Instantiate to print Jackie Chan's banking information
        jackieName = new Name("Jackie", "Chan");
        jackieDateBorn = new Date(1954, 4, 7);
        jackieSignupDate = new Date(1980, 10, 1);
        jackieAccountNumb = "chan789";
        jackiePin = 1954;
        jackieAccountBalance = 3000;
        jackieWithdrawAmount = 500;
        jackiePerson = new Person(jackieName, jackieDateBorn, null);
        jackieBankClient = new BankClient(jackieName, jackieDateBorn, null, jackieSignupDate, jackieAccountNumb);
        jackieBankAccount = new BankAccount(jackieBankClient, jackieAccountBalance, jackiePin, jackieAccountNumb, sexM, null
                , jackieWithdrawAmount);


        // Printing Albert Einstein's banking information
        System.out.println(albertPerson.printPersonInfo());
        System.out.println(albertName.getInitials());
        System.out.println(albertName.getFullName());
        System.out.println(albertName.getReverseName());
        System.out.println(albertPerson.getDetails());
        System.out.println(albertBankAccount.getDetails());
        System.out.println(albertBankClient.getDetails());
        System.out.println(albertBankAccount.printTransaction());

        // Creating space between two bank clients
        System.out.println();
        System.out.println();

        // Printing Nelson Mandela's banking information
        System.out.println(nelsonPerson.printPersonInfo());
        System.out.println(nelsonName.getInitials());
        System.out.println(nelsonName.getFullName());
        System.out.println(nelsonName.getReverseName());
        System.out.println(nelsonPerson.getDetails());
        System.out.println(nelsonBankAccount.getDetails());
        System.out.println(nelsonBankClient.getDetails());
        System.out.println(nelsonBankAccount.printTransaction());

        // Creating space between two bank clients
        System.out.println();
        System.out.println();

        // Printing Frida Kahlo's banking information
        System.out.println(kahloPerson.printPersonInfo());
        System.out.println(kahloName.getInitials());
        System.out.println(kahloName.getFullName());
        System.out.println(kahloName.getReverseName());
        System.out.println(kahloPerson.getDetails());
        System.out.println(kahloBankAccount.getDetails());
        System.out.println(kahloBankClient.getDetails());
        System.out.println(kahloBankAccount.printTransaction());

        // Creating space between two bank clients
        System.out.println();
        System.out.println();

        // Printing Jackie Chan's banking information
        System.out.println(jackiePerson.printPersonInfo());
        System.out.println(jackieName.getInitials());
        System.out.println(jackieName.getFullName());
        System.out.println(jackieName.getReverseName());
        System.out.println(jackiePerson.getDetails());
        System.out.println(jackieBankAccount.getDetails());
        System.out.println(jackieBankClient.getDetails());
        System.out.println(jackieBankAccount.printTransaction());
    }
}