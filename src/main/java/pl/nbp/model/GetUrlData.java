package pl.nbp.model;


import com.sun.javafx.binding.StringFormatter;
import javafx.application.Application;
import javafx.stage.Stage;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Currency;

public class GetUrlData {


    public static void main(String[] args) throws IOException {

        getCurrencyGBP();
        LocalDate todaysDate = todaysDate();
        LocalDate someDay = LocalDate.of(2018, 02, 9);
        // System.out.println(someDay.toString());
        //getThisWeekCurrencyData(startOfThisWeek(todaysDate), endOfThisWeek(todaysDate), CurrencyCode.USD);
       // System.out.println(getAllExchangeRate(someDay)); // z danego dnia
        ///  getLastWeekCurrencyData(); //brak implementacji

    }

    private static void getLastWeekCurrencyData() {


    }

    private static LocalDate todaysDate() {

        Calendar calendar = Calendar.getInstance();
        LocalDate today;
        today = LocalDate.now();
        SimpleDateFormat dateFormat;
        dateFormat = new SimpleDateFormat("MM/dd/yy");
        return today;
    }

    private static LocalDate startOfThisWeek(LocalDate todaysDate) {

        int currentNumberOfWeekDay = todaysDate.getDayOfWeek().getValue();
        LocalDate startOfThisWeekDate = todaysDate; //in case startOfThisWeekDate = 2
        if (currentNumberOfWeekDay > 1) {
            startOfThisWeekDate = todaysDate.minusDays(currentNumberOfWeekDay - 1);
        }
        return startOfThisWeekDate;
    }

    private static LocalDate endOfThisWeek(LocalDate todaysDate) {

        int currentNumberOfWeekDay = todaysDate.getDayOfWeek().getValue();
        LocalDate endOfThisWeekDay = todaysDate; //in case startOfThisWeekDate = 2
        if (currentNumberOfWeekDay == 7) {
            endOfThisWeekDay = todaysDate.minusDays(2);
        } else if (currentNumberOfWeekDay == 6) {
            endOfThisWeekDay = todaysDate.minusDays(1);
        } else if (currentNumberOfWeekDay < 5) {
            endOfThisWeekDay = todaysDate.minusDays(currentNumberOfWeekDay + 2);
        }

        return endOfThisWeekDay;
    }

    private static String getJsonString(BufferedReader jsonReader) throws IOException {
        String outputJson = "";
        String output = "";
        while ((output = jsonReader.readLine()) != null) {
            outputJson += output;
        }
        System.out.println(outputJson);
        return outputJson;
    }

    private static String getAllExchangeRate(LocalDate date) throws IOException {
        //http://api.nbp.pl/api/exchangerates/tables/A/2018-02-16/
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String strDate = date.format(formatter);
        URL requestURL = new URL("http://api.nbp.pl/api/exchangerates/tables/A/" + strDate + "/");
        try {
            URLConnection requestURLConnection = requestURL.openConnection();
            BufferedReader jsonReader = new BufferedReader(new InputStreamReader(requestURLConnection.getInputStream()));
            String outputJson = getJsonString(jsonReader);
            return outputJson;
        } catch (IOException e) {
            return "no data";
        }
    }

    private static String getThisWeekCurrencyData(LocalDate startOfThisWeek, LocalDate endOfThisWeek, CurrencyCode currencyCode) throws IOException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
            String startDay = startOfThisWeek.format(formatter);
            String endDay = startOfThisWeek.format(formatter);
            URL requestURL = new URL("http://api.nbp.pl/api/exchangerates/rates/A/" + currencyCode + "/" + startDay + "/" + endDay + "/");
            URLConnection requestURLConnection = requestURL.openConnection();
            BufferedReader jsonReader = new BufferedReader(new InputStreamReader(requestURLConnection.getInputStream()));
            String outputJson = getJsonString(jsonReader);
            return outputJson;
        } catch (IOException e) {
            return "no data";
        }
    }

    private static String getCurrencyGBP() throws IOException {
        try {
            URL requestURL = new URL("http://api.nbp.pl/api/exchangerates/rates/a/gbp/last/50/?format=json");
            URLConnection requestURLConnection = requestURL.openConnection();
            BufferedReader jsonReader = new BufferedReader(new InputStreamReader(requestURLConnection.getInputStream()));
            String outputJson = getJsonString(jsonReader);
            //JSONObject json = new JSONObject(outputJson);
            //jsonReader.close();
           // System.out.println(json.toString());
            return outputJson;
        } catch (IOException e) {
            return "no data";
        }
    }


}

