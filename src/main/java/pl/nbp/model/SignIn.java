package pl.nbp.model;

import sun.util.resources.CurrencyNames;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

/**
 * @author kelthuzad
 * Class to check whether given login and password are in the user database
 */
public class SignIn {

    static ArrayList<User> arrayList = new ArrayList<>();

    /**
     * Constructor which get array list all user and copy list to own array list
     *
     * @param arrayList all user
     */
    public SignIn(ArrayList arrayList) {
        this.arrayList = arrayList;
    }

    /**
     * Method to check given login and password if are they in array list
     *
     * @param login
     * @param password
     * @return true if login and password are in array list and return false if don't are
     */
    public boolean whetherLoginAndPasswordInArray(String login, String password) {
        for (User u : arrayList) {
            if (u.getLogin().equals(login)) {
                if (u.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void show() {
        for (User u : arrayList) {
            System.out.println(u.toString());
        }
    }

    public static void main(String[] args) throws IOException {

        ManagementUserDatabase managementUserDatabase = new ManagementUserDatabase();

//        String s = CurrencyType.fromValue("ouguiya (Mauretania)").toString();
//        System.out.println(s);
//        Currency  c = Currency.getInstance()
//        CsvDocument c = new CsvDocument();
//        ArrayList<User> d = c.read();
//        c.write(d);
//        managementUserDatabase.addUser("Ola", "Nowak", "ola555Ae", "fsdfsdfR3");
//        managementUserDatabase.save();
//        managementUserDatabase.addUserToArrayList();
//        SignIn.show();
//        System.out.println(managementUserDatabase.checkLoginAndPass("kam2","kam"));
//        Confirm confirm = new Confirm();
//        String s = null;
//        System.out.println(confirm.strings(s));
    }
}