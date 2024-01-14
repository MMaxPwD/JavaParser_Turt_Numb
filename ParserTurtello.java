package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ParserTurtello extends Datalist {
    public static List<String> urlList = new ArrayList<>();
    public static List<String> cityList = new ArrayList<>();
    public static List<Datalist> dataWeatherList = new ArrayList<Datalist>();

    public static void main(String[] args) throws IOException, NoClassDefFoundError {

        parsingTurtella(cityList);
        System.out.println(urlList.toString());

        ExcelMaker.excelSaver(dataWeatherList);
    }

    public static List<Datalist> parsingTurtella(List<String> cityList) throws IOException {

        List<String> monthList = new ArrayList<>();
        monthList.add("january");
        monthList.add("february");
        monthList.add("march");

        for (String cityName : cityList) {

            for (String monthName : monthList) {
                urlList.add(cityName + "/" + monthName);
            }
        }
        for (String url : urlList) {
            System.out.println(url);
            Document document = Jsoup.connect(url).get(); //С помощью Jsoup создаем подключение и получаем html код страницы
            Element mainBlock = document.getElementById("monthWeather");

            Element city = document.getElementsByClass("blockLnk bck big-btn").select("td").getFirst();
            String strCity = city.text();

            Element month = mainBlock.selectFirst("h2").selectFirst("span");
            String strMonth = month.text();

            Elements DayTemperature = mainBlock.select("tr").get(1).getElementsByClass("val");
            String strDayTemperature = DayTemperature.text().replaceAll("°C", "");
            double numDayTemperature = Double.parseDouble(strDayTemperature);

            Elements NightTemperature = mainBlock.select("tr").get(2).getElementsByClass("val");
            String strNightTemperature = NightTemperature.text().replaceAll("°C", "");
            double numNightTemperature = Double.parseDouble(strNightTemperature);

            Elements sunDays = mainBlock.select("tr").get(4).getElementsByClass("val");
            String strSunDays = sunDays.text();
            int sunDaysNum = 0;
            if (strSunDays.contains("д")) {
                strSunDays = strSunDays.replaceAll("\\D", "");
                sunDaysNum = Integer.parseInt(strSunDays);
            } else {
                Elements sunDays1 = mainBlock.select("tr").get(6).getElementsByClass("val");
                String strSunDays1 = sunDays1.text();
                strSunDays = strSunDays1.replaceAll("\\D", "");
                sunDaysNum = Integer.parseInt(strSunDays);
            }

            Datalist dataWeather = new Datalist();
            dataWeather.setStrCity(strCity);
            dataWeather.setStrMonth(strMonth);
            dataWeather.setStrDayTemperature(numDayTemperature);
            dataWeather.setStrNightTemperature(numNightTemperature);
            dataWeather.setStrSundays(sunDaysNum);
            dataWeatherList.add(dataWeather);
        }
        return dataWeatherList;
    }
}

