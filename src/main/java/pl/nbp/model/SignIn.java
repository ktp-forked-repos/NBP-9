package pl.nbp.model;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author kelthuzad
 * Class to check whether given login and password are in the user database
 */
public class SignIn {

    static ArrayList<User> arrayList = new ArrayList<>();

    /**
     * Constructor which get array list all user and copy list to own array list
     * @param arrayList all user
     */
    public SignIn(ArrayList arrayList) {
        this.arrayList = arrayList;
    }

    /**
     * Method to check given login and password if are they in array list
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
//        managementUserDatabase.addUser("Ola", "Nowak", "ola", "now");
//        managementUserDatabase.save();
//        managementUserDatabase.addUserToArrayList();
//        SignIn.show();
//        System.out.println(managementUserDatabase.checkLoginAndPass("kam2","kam"));
        Confirm confirm = new Confirm();
        String s = null;
        System.out.println(confirm.strings(s));
    }
}