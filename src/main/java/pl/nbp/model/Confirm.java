package pl.nbp.model;

/**
 * @author kelthuzad
 * Class responsible for check regex input strings
 */
public class Confirm {

    /**
     * Method to check correct first name and last name and another similar strings
     * @param string to check
     * @return true if string is correct to regex and return false if is don't correct
     */
    public boolean strings(String string) {
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
     * @param string to check
     * @return true if login is correct to regex and return false if is don't correct
     */
    public boolean login(String string) {
        if (string == null || string.isEmpty()) {
            System.out.printf("\nString is Empty or is a null");
            return false;
        } else if (string.matches("[A-Za-z][A-Za-z\\S\\d]{7,15}")){
            return true;
        }
        return false;
    }
}
