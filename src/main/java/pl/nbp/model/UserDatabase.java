package pl.nbp.model;

import java.util.ArrayList;
import java.io.IOException;

public class UserDatabase {
    static public ArrayList<User> arrayList = new ArrayList<User>();
    static public User user = null;
    static public CsvFile csvFile = null;
    static public Login login = null;

    public UserDatabase() throws IOException {
        csvFile = new CsvFile();
        arrayList = csvFile.read();
        login = new Login(arrayList);
    }

    public int returnLastId() {
        return arrayList.size()+1;
    }

    public void addUser(String firstName, String lastName , String login , String password) {
        user = new User.UserBuilder()
                .id(returnLastId())
                .firstName(firstName)
                .lastName(lastName)
                .login(login)
                .password(password)
                .build();
    }

    public void addUserToArrayList(){
        arrayList.add(user);
    }

    public void save() throws IOException {
        csvFile.write(this.user);
    }
}
