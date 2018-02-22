package pl.nbp.model;

/**
 * @author kelthuzad
 * Class responsible for check regex input strings
 */
public class Confirm {

    /**
     * Method to check correct first name and last name and another similar strings
     *
     * @param string to check
     * @return true if string is correct to regex and return false if is don't correct
     */
    public static boolean strings(String string) {
        if (string == null || string.isEmpty()) {
            System.out.printf("\nString is Empty or is a null");
            return false;
        } else if (string.matches("[A-Z][a-z]{1,20}")) {
            return true;
        }
        return false;
    }

    /**
     * Method to check correct login
     *
     * @param login to check
     * @return true if login is correct to regex and return false if is don't correct
     */
    public static boolean login(String login) {
        if (login == null || login.isEmpty()) {
            System.out.printf("\nLogin is Empty or is a null");
            return false;
        } else if (login.matches("[A-Za-z][A-Za-z\\S\\d]{7,15}")) {
            return true;
        }
        return false;
    }

    /**
     * Method to check correct password
     *
     * @param password to check
     * @return true if login is correct to regex and return false if is don't correct
     */
    public static boolean password(String password) {
        if (password == null || password.isEmpty()) {
            System.out.printf("\nPassword is Empty or is a null");
            return false;
        } else if (password.matches("[\\w\\S]{7,15}")) {
            boolean charDigital = false;
            boolean charLetter = false;
            boolean charUpperCase = false;
            for (int index = 0; index < password.length(); index++) {
                if (Character.isLetter(password.charAt(index)) && charLetter == false) {
                    charLetter = true;
                }
                if (Character.isDigit(password.charAt(index)) && charDigital == false) {
                    charDigital = true;
                }
                if (Character.isUpperCase(password.charAt(index)) && charUpperCase == false) {
                    charUpperCase = true;
                }
                if (charDigital == true && charLetter == true && charUpperCase == true) {
                    return true;
                }
            }
        }
        return false;
    }
}
