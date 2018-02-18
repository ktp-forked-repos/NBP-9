package pl.nbp.model;

import java.io.IOException;
import java.util.ArrayList;

public class Login {

    static ArrayList<User> arrayList = new ArrayList<>();

    public Login(ArrayList arrayList) {
        this.arrayList = arrayList;
//        show();
    }

    public static void show() {
        for (User u: arrayList) {
            System.out.println(u.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        CsvFile csvFile = new CsvFile();
        ArrayList<User> userArrayList = csvFile.read();
        UserDatabase userDatabase = new UserDatabase();
        Login.show();
    }
}
