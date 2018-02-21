package pl.nbp.model.filehandler;

import pl.nbp.model.User;

import java.io.IOException;
import java.util.ArrayList;

import static javafx.scene.input.KeyCode.T;

/**
 * Interface which has implement few method to connect whit operation on file
 */
public interface File <E>{

    /**
     * Check if file exist
     * @throws IOException
     */
    public void isExist() throws IOException;

    /**
     * Check if file is empty
     * @throws IOException
     */
    public void isEmpty() throws IOException;

    /**
     * Read with file all user and add their to arrayList
     * @return arrayList all user
     * @throws IOException
     */
    public ArrayList read() throws IOException;

    /**
     * Write user to file
     * @throws IOException
     */
    public void write(ArrayList<E> E) throws IOException;
//    public void write(User user) throws IOException;

    /**
     * Create empty file
     * @throws IOException
     */
    public void createEmptyFile() throws IOException;

    /**
     * Add file header
     * @throws IOException
     */
    public void addFileHeader() throws IOException;
}
