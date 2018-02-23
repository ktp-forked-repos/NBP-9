package pl.nbp.model;

import pl.nbp.model.Enum.NameTable;
import pl.nbp.model.Enum.TableOrRate;
import pl.nbp.model.menagement.ManagementUserDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * @author kelthuzad
 * Class to check whether given login and password are in the user database
 */
public class SignIn {

    static ArrayList<User> arrayList = new ArrayList<>();

    /**
     * Constructor which get array list all user and copy list to own array list
     *
     * @param arrayList all user
     */
    public SignIn(ArrayList arrayList) {
        this.arrayList = arrayList;
    }

    /**
     * Method to check given login and password if are they in array list
     *
     * @param login
     * @param password
     * @return true if login and password are in array list and return false if don't are
     */
    public boolean whetherLoginAndPasswordInArray(String login, String password) {
        for (User u : arrayList) {
            if (u.getLogin().equals(login)) {
                if (u.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void show() {
        for (User u : arrayList) {
            System.out.println(u.toString());
        }
    }

    public static void main(String[] args) throws IOException {

        ManagementUserDatabase managementUserDatabase = new ManagementUserDatabase();
//        System.out.println(TableOrRate.valueOf("tablica kursów"));
//        String s = QueriesToWeb.tableCurrency(TableOrRate.fromValue("kurs waluty") , NameTable.C);
        String s = QueriesToWeb.seriesOfLastCountTableCurrency(TableOrRate.fromValue("tablica kursów") , NameTable.A , 4);
        System.out.println(s);
//        URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/a/gbp/last/50");
//        URL url = new URL(s);
//        URLConnection connection = url.openConnection();
//        InputStream in = connection.getInputStream();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
//        String line = null;
//        String a = new String();
//        while ((line = bufferedReader.readLine()) !=null) {
//            a += line;
//        }
//        System.out.println(a);
//        String split2[] = a.split(":\\[\\{");
//        for (int i = 0; i < split2.length; i++) {
//            System.out.println(split2[i]);
//        }
//        String split[] = split2[1].split("},\\{");
//        for (int index = 0; index < split.length; index++) {
//            System.out.println(split[index]) ;
//        }
//        TextURL url = new TextURL(urlString);
//        String s = CurrencyTypeInTableA.fromValue("ouguiya (Mauretania)").toString();
//        System.out.println(s);
//        Currency  c = Currency.getInstance()
//        CsvDocument c = new CsvDocument();
//        ArrayList<User> d = c.read();
//        c.write(d);
//        managementUserDatabase.addUser("Ola", "Nowak", "ola555Ae", "fsdfsdfR3");
//        managementUserDatabase.save();
//        managementUserDatabase.addUserToArrayList();
//        SignIn.show();
//        System.out.println(managementUserDatabase.checkLoginAndPass("kam2","kam"));
//        Confirm confirm = new Confirm();
//        String s = null;
//        System.out.println(confirm.strings(s));
    }
}