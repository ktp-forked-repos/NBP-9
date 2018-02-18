package pl.nbp.model;

import java.io.IOException;
import java.util.ArrayList;

public class Login {

    static ArrayList<User> arrayList = new ArrayList<>();

    public Login(ArrayList arrayList) {
        this.arrayList = arrayList;
    }

    public static void show() {
        for (User u: arrayList) {
            System.out.println(u.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        UserDatabase userDatabase = new UserDatabase();
        userDatabase.addUser("Ola" , "Nowak" , "ola" , "now");
        userDatabase.save();
        userDatabase.addUserToArrayList();
        Login.show();
    }
}