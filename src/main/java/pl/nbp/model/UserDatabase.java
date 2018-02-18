package pl.nbp.model;

import java.util.ArrayList;
import java.io.IOException;

public class UserDatabase {
    static public ArrayList<User> arrayList = new ArrayList<User>();
    static public User user = null;

    public UserDatabase() throws IOException {
        CsvFile csvFile = new CsvFile();
        arrayList = csvFile.read();
        Login login = new Login(arrayList);
    }

    public int returnLastId() {
        return arrayList.size()+1;
    }

    public User addUser(String firstName, String lastName , String login , String password) {
        user = new User.UserBuilder()
                .id(returnLastId())
                .firstName(firstName)
                .lastName(lastName)
                .login(login)
                .password(password)
                .build();
        return user;
    }
}
