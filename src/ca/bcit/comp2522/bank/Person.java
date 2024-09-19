package ca.bcit.comp2522.bank;

/**
 * This class models a person's information
 * Firstly, get a person's name from name class
 * Secondly, get a date of birth from date class
 * Thirdly, get a date of death from date class (only if the person is not alive) and validate through
 * isAlive() to help to create getDetails().
 * This class will print out all information above in two different formats by using getDetails() and
 * printPersonInfo().
 * @author Gem Baojimin sha
 * @author Yujin Jeong
 * @version 1.0
 */
public class Person {

    // Creating a variable to set person's name, date of birth, and date of death.
    private final Name name;
    private final Date dateBorn;
    private final Date dateDied;

    /**
     * Creating a constructor.
     * @param name will be assigned to the instance data: name
     * @param dateBorn will be assigned to the instance data: dateBorn
     * @param dateDied will be assigned to the instance data: dateDied
     */
    public Person (final Name name,final Date dateBorn,final Date dateDied) {
        this.name =     name;
        this.dateBorn = dateBorn;
        this.dateDied = dateDied;

    }

    /**
     * Creating a getter to get access to private variable in Name class.
     * @return name to use methods in Name class.
     */
    public Name getName(){
        return name;
    }

    /**
     * Creating a method that prints the person's details.
     * (life Status, if not alive printing death date, born date).
     * e.g. Tiger Woods (alive) was born on tuesday, December 30, 1975!
     * or Albert Einstein (died monday, April 18, 1955) was born on friday, March 14, 1879!
     * @return printing different format of person's detail depending on person's life status
     */
    public String getDetails(){

        final StringBuilder builder1;

        builder1 = new StringBuilder();

        builder1.append(name.getFullName());
        builder1.append(isAlive() ? " (alive)" : " (died ");
        if (!isAlive()) {
            builder1.append(dateDied.getDayOfTheWeek());
            builder1.append(", ");
            builder1.append(dateDied.getDateInString());
            builder1.append(")");
        }
        builder1.append(" was born on ");
        builder1.append(dateBorn.getDayOfTheWeek());
        builder1.append(", ");
        builder1.append(dateBorn.getDateInString());
        builder1.append("!");
        return builder1.toString();
    }

    /**
     * Creating a method to check if the person is still alive.
     * @return true if there is dateDied is null, else false
     */
    public boolean isAlive(){
        return dateDied == null;
    }

    /**
     * Creating a method to print first name, born date, death date in different format to avoid duplication.
     * e.g. Frida Kahlo (July 6, 1907 – July 13, 1954)
     * @return person's information in different format
     */
    public String printPersonInfo(){

        final StringBuilder builder2;

        builder2 = new StringBuilder();

        builder2.append(name.getFullName());
        builder2.append( "(");
        builder2.append(dateBorn.getDateInString());
        builder2.append(" - ");
        builder2.append(isAlive()? "still alive" : "");
        if(!isAlive()){
            builder2.append(dateDied.getDateInString());
        }
        builder2.append(")");

        return builder2.toString();
    }
}
