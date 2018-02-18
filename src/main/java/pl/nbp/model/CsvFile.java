package pl.nbp.model;

import pl.nbp.model.filehandler.File;

import java.io.*;
import java.util.ArrayList;

public class CsvFile implements File {

    private static final String COMMA_DELIMITER = ",";
    private static final int USER_ID_IDX = 0;
    private static final int USER_FNAME_IDX = 1;
    private static final int USER_LNAME_IDX = 2;
    private static final int USER_LOGIN = 3;
    private static final int USER_PASSWORD = 4;
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "id,firstName,lastName,login,password";
    static final String PATH_TO_USER_FILE = "allUser.csv";
    BufferedReader bufferedReader = null;
    FileWriter fileWriter = null;

    public void isExist() throws IOException {
        if (!(new java.io.File(PATH_TO_USER_FILE).exists())) {
            System.out.printf("File doesn't exist but he was create");
            new java.io.File(PATH_TO_USER_FILE).createNewFile();
        }
    }

    public void isEmpty() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(PATH_TO_USER_FILE));
        if (bufferedReader.readLine() == null) {
            System.out.printf("File is Empty");
            fileWriter = new FileWriter(PATH_TO_USER_FILE);
            fileWriter.append(FILE_HEADER);
            fileWriter.close();
        }
    }

    public ArrayList read() throws IOException {
        isExist();
        isEmpty();
        ArrayList<User> userArrayList = new ArrayList<User>();
        String line = "";
        bufferedReader = new BufferedReader(new FileReader(PATH_TO_USER_FILE));
        bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            String[] tokens = line.split(COMMA_DELIMITER);
            if (tokens.length > 0) {
                User user = new User.UserBuilder()
                        .id(Integer.parseInt(tokens[USER_ID_IDX]))
                        .firstName(tokens[USER_FNAME_IDX])
                        .lastName(tokens[USER_LNAME_IDX])
                        .login(tokens[USER_LOGIN])
                        .password(tokens[USER_PASSWORD])
                        .build();
                userArrayList.add(user);
            }
        }
        bufferedReader.close();
        return userArrayList;
    }

    public void write(User user) throws IOException {
        isExist();
        isEmpty();
        fileWriter = new FileWriter(PATH_TO_USER_FILE, true);
        fileWriter.append(String.valueOf(user.getId()));
        fileWriter.append(COMMA_DELIMITER);
        fileWriter.append(user.getFirstName());
        fileWriter.append(COMMA_DELIMITER);
        fileWriter.append(user.getLastName());
        fileWriter.append(COMMA_DELIMITER);
        fileWriter.append(user.getLogin());
        fileWriter.append(COMMA_DELIMITER);
        fileWriter.append(user.getPassword());
        fileWriter.append(NEW_LINE_SEPARATOR);
        fileWriter.close();
    }
}