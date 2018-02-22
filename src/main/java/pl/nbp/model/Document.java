package pl.nbp.model;

import pl.nbp.model.User;

import java.io.IOException;
import java.util.ArrayList;

import static javafx.scene.input.KeyCode.T;

/**
 * @author kelthuzad
 * Interface which has implement few method to connect whit operation on file
 */
public interface Document<E>{

    /**
     * Check if file exist
     * @throws IOException
     */
    void isExist() throws IOException;

    /**
     * Check if file is empty
     * @throws IOException
     */
    void isEmpty() throws IOException;

    /**
     * Read with file all user and add their to arrayList
     * @return arrayList all user
     * @throws IOException
     */
    ArrayList read() throws IOException;

    /**
     * Write user to file
     * @throws IOException
     */
    void write(ArrayList<E> E) throws IOException;
//    public void write(User user) throws IOException;
//    void write(User user) throws IOException;
//    void write(String s) throws IOException;
//    <T> void write(T elem) throws IOException;

    /**
     * Create empty file
     * @throws IOException
     */
    void createEmptyFile() throws IOException;

    /**
     * Add file header
     * @throws IOException
     */
    void addFileHeader() throws IOException;
}
