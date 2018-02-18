package pl.nbp.model;

import java.io.IOException;
import java.util.ArrayList;

public class Login {
    static ArrayList<User> userArrayList = new ArrayList<User>();
    static final String PATH_TO_USER_FILE = "allUSer.csv";
//
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
//        userArrayList.addAll(CsvLoginFileReader.readFile(PATH_TO_USER_FILE));
//        User user = new User.UserBuilder()
//                .id(CsvLoginFileReader.returnLastId(PATH_TO_USER_FILE))
//                .firstName("Tomek")
//                .lastName("Kowalski")
//                .login("Tom2")
//                .password("Tom")
//                .build();
//        userArrayList.add(user);
//        CsvLoginFileWrite.writeFile(user,PATH_TO_USER_FILE);
//        for (User u: userArrayList) {
//            System.out.println(u.toString());
//        }
        CsvFile csvFile = new CsvFile();
        csvFile.isExist();
        csvFile.isEmpty();
        userArrayList = csvFile.read();
        for (User u: userArrayList) {
            System.out.println(u.toString());
            System.out.println();
        }

        csvFile.write(user);
    }

}
