package pl.nbp.model;

import java.util.ArrayList;

public class UserDatabase {
    static public ArrayList<User> arrayList = new ArrayList<User>();
    static public User user = null;

    public User addUser() {
        user = new User.UserBuilder()
                .id()
                .firstName()
                .lastName()
                .login()
                .password()
                .build();
        return user;
    }


}
