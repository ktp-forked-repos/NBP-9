package pl.nbp.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class CsvLoginFileReader {
    private static final String COMMA_DELIMITER = ",";
    private static final int USER_ID_IDX = 0;
    private static final int USER_FNAME_IDX = 1;
    private static final int USER_LNAME_IDX = 2;
    private static final int USER_LOGIN = 3;
    private static final int USER_PASSWORD = 4;
    static Set<User> userSet = new HashSet<User>();

    public static Set<User> readFile(String fileName) {

        BufferedReader fileReader = null;

        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(fileName));
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    User user = new User.UserBuilder()
                            .id(Integer.parseInt(tokens[USER_ID_IDX]))
                            .firstName(tokens[USER_FNAME_IDX])
                            .lastName(tokens[USER_LNAME_IDX])
                            .login(tokens[USER_LOGIN])
                            .password(tokens[USER_PASSWORD])
                            .build();
                    userSet.add(user);
                }
            }
        } catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
        return userSet;
    }

    public static int returnLastId(String fileName) {
        Set<User> set = readFile(fileName);
        ArrayList<User> userArrayList = new ArrayList<User>(set);
        int idMax = userArrayList.get(0).getId();
        for (int index = 1; index < userArrayList.size(); index++) {
            if (userArrayList.get(index).getId() > idMax ) {
                idMax = userArrayList.get(index).getId();
            }
        }
        return idMax + 1 ;
    }


}
