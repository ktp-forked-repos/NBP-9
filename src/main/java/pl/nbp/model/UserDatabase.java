package pl.nbp.model;

import java.util.ArrayList;
import java.io.IOException;

public class UserDatabase {
    static public ArrayList<User> arrayList = new ArrayList<User>();
    static public User user = null;

    public UserDatabase() throws IOException {
        CsvFile csvFile = new CsvFile();
        arrayList = csvFile.read();
    }

    public int returnLastId() {
        return arrayList.size()+1;
    }
//    public User addUser() {
//        user = new User.UserBuilder()
//                .id()
//                .firstName()
//                .lastName()
//                .login()
//                .password()
//                .build();
//        return user;
//    }
}
