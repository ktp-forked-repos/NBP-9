package pl.nbp.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Login {
    static ArrayList<User> userArrayList = new ArrayList<User>();
    static final String PATH_TO_USER_FILE = "allUser.csv";

//    public static boolean cheackLoginAndPasswordIsCorrect(String login , String password) {
//        userArrayList.addAll(CsvLoginFileReader.readFile(PATH_TO_USER_FILE));
//        for (User u : userArrayList) {
//            if (u.getLogin().equals(login)) {
//                if (u.getPassword().equals(password)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) throws IOException {
        CsvFile csvFile = new CsvFile();
        csvFile.isExist();
        csvFile.isEmpty();
        //TODO problem z indeksowaniem jakas metoda do auto-increment id
        User user = new User.UserBuilder()
                .id(0)
                .firstName("Tomsd")
                .lastName("Kowsdki")
                .login("Tom2")
                .password("Tom")
                .build();
        userArrayList = csvFile.read();
        csvFile.write(user,userArrayList);
        userArrayList.add(user);
        for (User u: userArrayList) {
            System.out.printf("%s \n" , u.toString());
        }
    }

}
