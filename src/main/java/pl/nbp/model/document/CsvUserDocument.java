package pl.nbp.model.document;

import pl.nbp.model.Interface.Document;
import pl.nbp.model.User;

import java.io.*;
import java.util.ArrayList;

/**
 * @author kelthuzad
 * Class to read and write data on file with extension csv.
 * Class implements methods on Document Interface.
 */
public class CsvUserDocument implements Document {

    private static final String COMMA_DELIMITER = ",";
    private static final int USER_ID_IDX = 0;
    private static final int USER_FNAME_IDX = 1;
    private static final int USER_LNAME_IDX = 2;
    private static final int USER_LOGIN = 3;
    private static final int USER_PASSWORD = 4;
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "id,firstName,lastName,signIn,password";
    //    static final String path = "allUser.csv";
    BufferedReader bufferedReader = null;
    FileWriter fileWriter = null;
    private static String path = null;

    /**
     * Method that has the task of checking if file exist.
     *
     * @throws IOException
     */
    public void isExist() throws IOException {
        if (!(new java.io.File(path).exists())) {
            System.out.printf("Document doesn't exist but he was create");
            createEmptyFile();
        }
    }

    /**
     * Method that has the task of checking if file is Empty
     *
     * @throws IOException
     */
    public void isEmpty() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(path));
        if (bufferedReader.readLine() == null) {
            System.out.printf("Document is Empty");
            addFileHeader();
        }
    }

    /**
     * Method that has the task of read all User with file and add all user to arrayList
     *
     * @return arrayList which has all user who was in file
     * @throws IOException
     */
    public ArrayList read(String pathToFile) throws IOException {
        path = pathToFile;
        isExist();
        isEmpty();
        ArrayList<User> userArrayList = new ArrayList<User>();
        String line = "";
        bufferedReader = new BufferedReader(new FileReader(path));
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
     * @param E is arrayList which write to file
     * @throws IOException
     */
    public void write(ArrayList E, String pathToFile) throws IOException {
        path = pathToFile;
        ArrayList<User> newUserTowrite = E;
        System.out.println(newUserTowrite.toString());
        isExist();
        isEmpty();
        for (int index = 0; index < newUserTowrite.size(); index++) {
            fileWriter = new FileWriter(path, true);
            fileWriter.append(String.valueOf(newUserTowrite.get(index).getId()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(newUserTowrite.get(index).getFirstName());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(newUserTowrite.get(index).getLastName());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(newUserTowrite.get(index).getLogin());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(newUserTowrite.get(index).getPassword());
            fileWriter.append(NEW_LINE_SEPARATOR);
}
        fileWriter.close();
        newUserTowrite.clear();
    }

//    /**
//     * Method that has the task of write user to file
//     *
//     * @param user to add to file
//     * @throws IOException
//     */
//    public void write(User user) throws IOException {
//        isExist();
//        isEmpty();
//        fileWriter = new FileWriter(path, true);
//        fileWriter.append(String.valueOf(user.getId()));
//        fileWriter.append(COMMA_DELIMITER);
//        fileWriter.append(user.getFirstName());
//        fileWriter.append(COMMA_DELIMITER);
//        fileWriter.append(user.getLastName());
//        fileWriter.append(COMMA_DELIMITER);
//        fileWriter.append(user.getLogin());
//        fileWriter.append(COMMA_DELIMITER);
//        fileWriter.append(user.getPassword());
//        fileWriter.append(NEW_LINE_SEPARATOR);
//        fileWriter.close();
//    }

    /**
     * Method that has the task of create file
     *
     * @throws IOException
     */
    public void createEmptyFile() throws IOException {
        new java.io.File(path).createNewFile();
    }

    /**
     * Method that has the task of add file header
     *
     * @throws IOException
     */
    public void addFileHeader() throws IOException {
        fileWriter = new FileWriter(path);
        fileWriter.append(FILE_HEADER);
        fileWriter.close();
    }
}