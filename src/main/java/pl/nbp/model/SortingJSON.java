package pl.nbp.model;

import org.json.JSONArray;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;


public class SortingJSON {

    private static String JSONData = "{\"table\":\"A\",\"currency\":\"funt szterling\",\"code\":\"GBP\",\"rates\":[{\"no\":\"236/A/NBP/2017\",\"effectiveDate\":\"2017-12-06\",\"mid\":4.7715},{\"no\":\"237/A/NBP/2017\",\"effectiveDate\":\"2017-12-07\",\"mid\":4.7801},{\"no\":\"238/A/NBP/2017\",\"effectiveDate\":\"2017-12-08\",\"mid\":4.8261},{\"no\":\"239/A/NBP/2017\",\"effectiveDate\":\"2017-12-11\",\"mid\":4.7646},{\"no\":\"240/A/NBP/2017\",\"effectiveDate\":\"2017-12-12\",\"mid\":4.7652},{\"no\":\"241/A/NBP/2017\",\"effectiveDate\":\"2017-12-13\",\"mid\":4.7895},{\"no\":\"242/A/NBP/2017\",\"effectiveDate\":\"2017-12-14\",\"mid\":4.8060},{\"no\":\"243/A/NBP/2017\",\"effectiveDate\":\"2017-12-15\",\"mid\":4.8061},{\"no\":\"244/A/NBP/2017\",\"effectiveDate\":\"2017-12-18\",\"mid\":4.7717},{\"no\":\"245/A/NBP/2017\",\"effectiveDate\":\"2017-12-19\",\"mid\":4.7578},{\"no\":\"246/A/NBP/2017\",\"effectiveDate\":\"2017-12-20\",\"mid\":4.7483},{\"no\":\"247/A/NBP/2017\",\"effectiveDate\":\"2017-12-21\",\"mid\":4.7318},{\"no\":\"248/A/NBP/2017\",\"effectiveDate\":\"2017-12-22\",\"mid\":4.7387},{\"no\":\"249/A/NBP/2017\",\"effectiveDate\":\"2017-12-27\",\"mid\":4.7272},{\"no\":\"250/A/NBP/2017\",\"effectiveDate\":\"2017-12-28\",\"mid\":4.7126},{\"no\":\"251/A/NBP/2017\",\"effectiveDate\":\"2017-12-29\",\"mid\":4.7001},{\"no\":\"001/A/NBP/2018\",\"effectiveDate\":\"2018-01-02\",\"mid\":4.6805},{\"no\":\"002/A/NBP/2018\",\"effectiveDate\":\"2018-01-03\",\"mid\":4.7030},{\"no\":\"003/A/NBP/2018\",\"effectiveDate\":\"2018-01-04\",\"mid\":4.6691},{\"no\":\"004/A/NBP/2018\",\"effectiveDate\":\"2018-01-05\",\"mid\":4.6663},{\"no\":\"005/A/NBP/2018\",\"effectiveDate\":\"2018-01-08\",\"mid\":4.6990},{\"no\":\"006/A/NBP/2018\",\"effectiveDate\":\"2018-01-09\",\"mid\":4.7347},{\"no\":\"007/A/NBP/2018\",\"effectiveDate\":\"2018-01-10\",\"mid\":4.7240},{\"no\":\"008/A/NBP/2018\",\"effectiveDate\":\"2018-01-11\",\"mid\":4.7136},{\"no\":\"009/A/NBP/2018\",\"effectiveDate\":\"2018-01-12\",\"mid\":4.6777},{\"no\":\"010/A/NBP/2018\",\"effectiveDate\":\"2018-01-15\",\"mid\":4.6902},{\"no\":\"011/A/NBP/2018\",\"effectiveDate\":\"2018-01-16\",\"mid\":4.7060},{\"no\":\"012/A/NBP/2018\",\"effectiveDate\":\"2018-01-17\",\"mid\":4.7051},{\"no\":\"013/A/NBP/2018\",\"effectiveDate\":\"2018-01-18\",\"mid\":4.7216},{\"no\":\"014/A/NBP/2018\",\"effectiveDate\":\"2018-01-19\",\"mid\":4.7301},{\"no\":\"015/A/NBP/2018\",\"effectiveDate\":\"2018-01-22\",\"mid\":4.7304},{\"no\":\"016/A/NBP/2018\",\"effectiveDate\":\"2018-01-23\",\"mid\":4.7527},{\"no\":\"017/A/NBP/2018\",\"effectiveDate\":\"2018-01-24\",\"mid\":4.7563},{\"no\":\"018/A/NBP/2018\",\"effectiveDate\":\"2018-01-25\",\"mid\":4.7688},{\"no\":\"019/A/NBP/2018\",\"effectiveDate\":\"2018-01-26\",\"mid\":4.7489},{\"no\":\"020/A/NBP/2018\",\"effectiveDate\":\"2018-01-29\",\"mid\":4.7082},{\"no\":\"021/A/NBP/2018\",\"effectiveDate\":\"2018-01-30\",\"mid\":4.7061},{\"no\":\"022/A/NBP/2018\",\"effectiveDate\":\"2018-01-31\",\"mid\":4.7076},{\"no\":\"023/A/NBP/2018\",\"effectiveDate\":\"2018-02-01\",\"mid\":4.7512},{\"no\":\"024/A/NBP/2018\",\"effectiveDate\":\"2018-02-02\",\"mid\":4.7381},{\"no\":\"025/A/NBP/2018\",\"effectiveDate\":\"2018-02-05\",\"mid\":4.7111},{\"no\":\"026/A/NBP/2018\",\"effectiveDate\":\"2018-02-06\",\"mid\":4.6877},{\"no\":\"027/A/NBP/2018\",\"effectiveDate\":\"2018-02-07\",\"mid\":4.6886},{\"no\":\"028/A/NBP/2018\",\"effectiveDate\":\"2018-02-08\",\"mid\":4.7298},{\"no\":\"029/A/NBP/2018\",\"effectiveDate\":\"2018-02-09\",\"mid\":4.7690},{\"no\":\"030/A/NBP/2018\",\"effectiveDate\":\"2018-02-12\",\"mid\":4.7244},{\"no\":\"031/A/NBP/2018\",\"effectiveDate\":\"2018-02-13\",\"mid\":4.7090},{\"no\":\"032/A/NBP/2018\",\"effectiveDate\":\"2018-02-14\",\"mid\":4.6846},{\"no\":\"033/A/NBP/2018\",\"effectiveDate\":\"2018-02-15\",\"mid\":4.6763},{\"no\":\"034/A/NBP/2018\",\"effectiveDate\":\"2018-02-16\",\"mid\":4.6769}]}";

    public static void main(String[] args) {
        System.out.println(lastCourse());
        System.out.println(lastWeek());
        System.out.println(courseFromChoiceRange());
    }

    private static String lastCourse() {
        JSONObject jsonObject = new JSONObject(JSONData);
        JSONArray rates = jsonObject.getJSONArray("rates");
        JSONObject object = rates.getJSONObject(rates.length() - 1);
        return Double.toString(object.getDouble("mid"));
    }

    private static String lastWeek() {
        JSONObject jsonObject = new JSONObject(JSONData);
        JSONArray rates = jsonObject.getJSONArray("rates");
        List<String> listOfWeekCourses = new ArrayList<String>();
        for (int i = rates.length() - 6; i < rates.length(); i++) {
            JSONObject object = rates.getJSONObject(i);
            listOfWeekCourses.add(Double.toString(object.getDouble("mid")));
        }
        return listOfWeekCourses.toString();
    }

    private static String courseFromChoiceRange() {//ma byc poczatek i koniec zakresu
        String poczatekZakresu = "2017-12-11";
        String koniecZakresu = "2017-12-20";
        JSONObject jsonObject = new JSONObject(JSONData);
        JSONArray rates = jsonObject.getJSONArray("rates");
        List<String> listOfAreaCourses = new ArrayList<String>();
        for (int i = 0; i < rates.length(); i++) {
            JSONObject dayInArea = rates.getJSONObject(i);
            if (dayInArea.getString("effectiveDate").equals(poczatekZakresu)) {
                while (!dayInArea.getString("effectiveDate").equals(koniecZakresu)) {
                    listOfAreaCourses.add(Double.toString(dayInArea.getDouble("mid")));
                    dayInArea = rates.getJSONObject(i++);
                }
                return listOfAreaCourses.toString();
            }
        }
        return listOfAreaCourses.toString();
    }

}

