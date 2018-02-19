package pl.nbp.model;

public class Confirm {

    public boolean strings(String string) {
        if (string == null || string.isEmpty()) {
            System.out.printf("\nString is Empty or is a null");
            return false;
        } else if (string.matches("[A-Z][a-z]{1,20}")) {
            return true;
        }
        return false;
    }
}
