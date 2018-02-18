package pl.nbp.model;

import java.io.*;
import java.util.ArrayList;

public class CsvFile {
    private static final String COMMA_DELIMITER = ",";
    private static final int USER_ID_IDX = 0;
    private static final int USER_FNAME_IDX = 1;
    private static final int USER_LNAME_IDX = 2;
    private static final int USER_LOGIN = 3;
    private static final int USER_PASSWORD = 4;
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "id,firstName,lastName,login,password";
    private final String PATH_TO_USER_FILE = "allUser.csv";
    private BufferedReader bufferedReader = null;
    private FileWriter fileWriter = null;
    private File file = new File(PATH_TO_USER_FILE);

    public void isExist() throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public void isEmpty() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(PATH_TO_USER_FILE));
        if (bufferedReader.readLine() == null) {
            fileWriter = new FileWriter(PATH_TO_USER_FILE, true);
            fileWriter.append(FILE_HEADER);
            fileWriter.close();
        }
    }

    public ArrayList read() throws IOException {
        ArrayList<User> userArrayList = new ArrayList<User>();
        isExist();
        isEmpty();
        bufferedReader = new BufferedReader(new FileReader(PATH_TO_USER_FILE));
        try {
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
        } catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
        return userArrayList;
    }

    public void write(User user, ArrayList<User> arrayList) throws IOException {
        isExist();
        isEmpty();
        try {
            fileWriter = new FileWriter(PATH_TO_USER_FILE, true);
            fileWriter.append(String.valueOf(arrayList.size() + 1));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(user.getFirstName());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(user.getLastName());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(user.getLogin());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(user.getPassword());
            fileWriter.append(NEW_LINE_SEPARATOR);

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }
}
