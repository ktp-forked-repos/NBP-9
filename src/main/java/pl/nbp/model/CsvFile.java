package pl.nbp.model;

import pl.nbp.model.filehandler.File;

import java.io.*;
import java.util.ArrayList;

/**
 * @author kelthuzad
 * Class to read and write data on file with extension csv.
 * Class implements methods on File interface.
 */
public class CsvFile implements File {

    private static final String COMMA_DELIMITER = ",";
    private static final int USER_ID_IDX = 0;
    private static final int USER_FNAME_IDX = 1;
    private static final int USER_LNAME_IDX = 2;
    private static final int USER_LOGIN = 3;
    private static final int USER_PASSWORD = 4;
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "id,firstName,lastName,signIn,password";
    static final String PATH_TO_USER_FILE = "allUser.csv";
    BufferedReader bufferedReader = null;
    FileWriter fileWriter = null;

    /**
     * Method that has the task of checking if file exist.
     *
     * @throws IOException
     */
    public void isExist() throws IOException {
        if (!(new java.io.File(PATH_TO_USER_FILE).exists())) {
            System.out.printf("File doesn't exist but he was create");
            createEmptyFile();
        }
    }

    /**
     * Method that has the task of checking if file is Empty
     *
     * @throws IOException
     */
    public void isEmpty() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(PATH_TO_USER_FILE));
        if (bufferedReader.readLine() == null) {
            System.out.printf("File is Empty");
            addFileHeader();
        }
    }

    /**
     * Method that has the task of read all User with file and add all user to arrayList
     *
     * @return arrayList which has all user who was in file
     * @throws IOException
     */
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

    /**
     * Method that has the task of write user to file
     *
     * @param user to add to file
     * @throws IOException
     */
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

    /**
     * Method that has the task of create file
     *
     * @throws IOException
     */
    public void createEmptyFile() throws IOException {
        new java.io.File(PATH_TO_USER_FILE).createNewFile();
    }

    /**
     * Method that has the task of add file header
     *
     * @throws IOException
     */
    public void addFileHeader() throws IOException {
        fileWriter = new FileWriter(PATH_TO_USER_FILE);
        fileWriter.append(FILE_HEADER);
        fileWriter.close();
    }
}