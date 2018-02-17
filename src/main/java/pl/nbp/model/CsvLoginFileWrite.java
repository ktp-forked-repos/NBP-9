package pl.nbp.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvLoginFileWrite {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "id,firstName,lastName,login,password";

    public static void writeFile(User user , String fileName) {
        FileWriter fileWriter = null;

        try {
            File file = new File(fileName);
//            if (!file.exists()) {
//                fileWriter = new FileWriter(fileName);
//                fileWriter.append(FILE_HEADER.toString());
//                fileWriter.append(NEW_LINE_SEPARATOR.toString());
//            }
            fileWriter = new FileWriter(fileName, true);
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
