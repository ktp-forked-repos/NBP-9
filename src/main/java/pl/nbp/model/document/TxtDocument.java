package pl.nbp.model.document;


import pl.nbp.model.Interface.Document;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TxtDocument implements Document {

    BufferedReader bufferedReader = null;
    FileWriter fileWriter = null;
    private static String path = null;


    @Override
    public void isExist() throws IOException {
        if (!(new java.io.File(path).exists())) {
            System.out.printf("Document doesn't exist but he was create");
            createEmptyFile();
        }
    }

    @Override
    public void isEmpty() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(path));
        if (bufferedReader.readLine() == null) {
            System.out.printf("Document is Empty");
            addFileHeader();
        }
    }

    @Override
    public ArrayList read(String pathToFile) throws IOException {
//        path = pathToFile;
//        isExist();
//        isEmpty();
//        ArrayList<User> userArrayList = new ArrayList<User>();
//        String line = "";
//        bufferedReader = new BufferedReader(new FileReader(path));
//        bufferedReader.readLine();
//        while ((line = bufferedReader.readLine()) != null) {
//            String[] tokens = line.split(COMMA_DELIMITER);
//            if (tokens.length > 0) {
//                User user = new User.UserBuilder()
//                        .id(Integer.parseInt(tokens[USER_ID_IDX]))
//                        .firstName(tokens[USER_FNAME_IDX])
//                        .lastName(tokens[USER_LNAME_IDX])
//                        .login(tokens[USER_LOGIN])
//                        .password(tokens[USER_PASSWORD])
//                        .build();
//                userArrayList.add(user);
//            }
//        }
//        bufferedReader.close();
//        return userArrayList;
        return null;
    }

    @Override
    public void write(ArrayList E, String pathToFile) throws IOException {

    }

    @Override
    public void createEmptyFile() throws IOException {

    }

    @Override
    public void addFileHeader() throws IOException {

    }
}
