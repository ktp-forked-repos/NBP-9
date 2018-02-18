package pl.nbp.model;

import java.io.IOException;
import java.util.ArrayList;

public class Login {
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
        ArrayList<User> userArrayList = csvFile.read();
        for (User u : userArrayList) {
            System.out.println(u.toString());
            System.out.println();
        }

        UserDatabase userDatabase = new UserDatabase();
        System.out.println(userDatabase.returnLastId());
    }
}
