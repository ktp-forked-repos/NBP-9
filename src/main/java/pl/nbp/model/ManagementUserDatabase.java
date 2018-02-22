package pl.nbp.model;

import javax.swing.*;
import java.util.ArrayList;
import java.io.IOException;

/**
 * @author kelthuzad
 * Class responsible for management all user
 */
public class ManagementUserDatabase {
    static public ArrayList<User> arrayList = new ArrayList<>();
    static public ArrayList<User> arrayListNewUser = new ArrayList<>();
    static public User user = null;
    static public CsvFile csvFile = null;
    static public SignIn signIn = null;

    /**
     * Constructor which read with file all user and put their in array list and
     * he give this array list to class signIn
     *
     * @throws IOException
     */
    public ManagementUserDatabase() throws IOException {
        csvFile = new CsvFile();
        arrayList = csvFile.read();
        signIn = new SignIn(arrayList);
    }

    /**
     * Method to set last value id user
     *
     * @return last value id
     */
    public int returnLastId() {
        return arrayList.size() + 1;
    }

    /**
     * Method to add new user
     *
     * @param firstName
     * @param lastName
     * @param login
     * @param password
     * @throws IOException
     */
    public void addUser(String firstName, String lastName, String login, String password) throws IOException {
        if (Confirm.strings(firstName) && Confirm.strings(lastName) && Confirm.login(login) && Confirm.password(password)) {
            user = new User.UserBuilder()
                    .id(returnLastId())
                    .firstName(firstName)
                    .lastName(lastName)
                    .login(login)
                    .password(password)
                    .build();
            arrayListNewUser.add(user);
            save();
            arrayListNewUser.clear();
            addUserToArrayList();
        } else {
            JOptionPane.showMessageDialog(null , "Input data is not correct");
        }
    }

    /**
     * Method responsible for add new user to array list
     */
    public void addUserToArrayList() {
        arrayList.add(user);
    }

    /**
     * Method responsible for write new user to file with other user
     *
     * @throws IOException
     */
    public void save() throws IOException {
        csvFile.write(arrayListNewUser);
//        arrayList.add(user);
    }

    /**
     * Method check login and password
     *
     * @param login
     * @param password
     * @return true if login and password are in array list and return false if don't are
     */
    public boolean checkLoginAndPass(String login, String password) {
        if (signIn.whetherLoginAndPasswordInArray(login, password)) {
            return true;
        }
        return false;
    }

}
