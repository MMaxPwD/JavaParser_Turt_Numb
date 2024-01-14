package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ParserNumbeo extends Datalist {
    public static List<String> cityList = new ArrayList<>();
    public static List<Datalist> dataLivingList = new ArrayList<Datalist>();
    public static Element bananaPrice = null;
    public static Element beerPrice = null;
    public static Element gasPrice = null;
    public static Element rentPrice = null;

//    public static void main(String[] args) throws IOException {
//        parsingNumbeo(cityList);
//    }
    public static List<Datalist> parsingNumbeo (List<String> cityList) throws IOException {

        List<String> urlList = new ArrayList<>();

        for (String city : cityList) {
            urlList.add(city);
        }
        int count = 1;
        for (String url : urlList) {

            Document document = Jsoup.connect(url).get();

            Elements mainblock = document.getElementsByClass("data_wide_table new_bar_table");
            Elements mainblock404 = document.select("h1");
            String strMainblock404 = mainblock404.text();

            if (strMainblock404.contains("Cannot")) {
                Double numBananaPrice = null;
                Double numBeerPrice = null;
                Double numGasPrice = null;
                Double numRentPrice = null;

                Datalist dataLiving = new Datalist();
                dataLiving.setStrBananaPrice(numBananaPrice != null ? numBananaPrice.doubleValue() : 0.0);
                dataLiving.setStrBeerPrice(numBeerPrice != null ? numBeerPrice.doubleValue() : 0.0);
                dataLiving.setStrGasPrice(numGasPrice != null ? numGasPrice.doubleValue() : 0.0);
                dataLiving.setStrRentPrice(numRentPrice != null ? numRentPrice.doubleValue() : 0.0);
                for (int month = 0; month < 3; month++) {
                    dataLivingList.add(dataLiving);
                }
                System.out.println("Идёт парсинг и запись страницы " + count);
                count++;

            } else {
                bananaPrice = mainblock.select("tr").get(18).select("td").get(1);
                String bananaCheck = bananaPrice.text().split(" ")[0];
                String strBananaPrice = !"?".equals(bananaCheck) ? bananaCheck : "0.0";
                Double numBananaPrice = Double.parseDouble(strBananaPrice);

                beerPrice = mainblock.select("tr").get(27).select("td").get(1);
                String beerCheck = beerPrice.text().split(" ")[0];
                String strBeerPrice = !"?".equals(beerCheck) ? beerCheck : "0.0";
                Double numBeerPrice = Double.parseDouble(strBeerPrice);

                gasPrice = mainblock.select("tr").get(35).select("td").get(1);
                String gasCheck = gasPrice.text().split(" ")[0];
                String strGasPrice = !"?".equals(gasCheck) ? gasCheck : "0.0";
                Double numGasPrice = Double.parseDouble(strGasPrice);

                rentPrice = mainblock.select("tr").get(35).select("td").get(1);
                String rentCheck = rentPrice.text().split(" ")[0];
                String strRentPrice = !"?".equals(rentCheck) ? rentCheck : "0.0";
                Double numRentPrice = Double.parseDouble(strRentPrice);


                Datalist dataLiving = new Datalist();
                dataLiving.setStrBananaPrice(numBananaPrice != null ? numBananaPrice.doubleValue() : 0.0);
                dataLiving.setStrBeerPrice(numBeerPrice != null ? numBeerPrice.doubleValue() : 0.0);
                dataLiving.setStrGasPrice(numGasPrice != null ? numGasPrice.doubleValue() : 0.0);
                dataLiving.setStrRentPrice(numRentPrice != null ? numRentPrice.doubleValue() : 0.0);
                for (int month = 0; month < 3; month++) {
                    dataLivingList.add(dataLiving);
                }

                System.out.println("Идёт парсинг и запись страницы " + count);
                count++;

            }
        }
        return dataLivingList;
    }
}

