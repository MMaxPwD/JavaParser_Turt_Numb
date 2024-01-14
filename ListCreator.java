package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListCreator implements ListProvider {
    private static final List<String> countryLinkList = new ArrayList<>();
    private static final List<String> weatherLinkList = new ArrayList<>();
    private static final List<String> priceLinkList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        createList();
    }

    private static void createList() {
        String url = "https://pogoda.turtella.ru/countries";

        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Element mainBlock = document.getElementById("countriesList");
        Elements countryRough = mainBlock.getElementsByClass("w33");

        int count = 1;

        for (Element country : countryRough) {
            if(count<3) {
                String strCountry = country.select("a").attr("href");

                String countryLink = "https://pogoda.turtella.ru" + strCountry;
                countryLinkList.add(countryLink);
                count++;
            } else {
                break;
            }}


//        for (Element country : countryRough) {
//            String strCountry = country.select("a").attr("href");
//
//            String countryLink = "https://pogoda.turtella.ru" + strCountry;
//            countryLinkList.add(countryLink);

            for (String url1 : countryLinkList) {

                Document document1 = null;
                try {
                    document1 = Jsoup.connect(url1).get();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Element mainblock1 = document1.getElementById("countryResorts");

                Elements resortBlock = mainblock1.getElementsByClass("block");
                for (Element blocks : resortBlock) {
                    Elements links = blocks.select("a");
                    for (Element link : links) {
                        String resort = link.attr("href");
                        String[] resortparts = resort.split("/");
                        String capCity = resortparts[resortparts.length - 1];
                        String city = capCity.substring(0, 1).toUpperCase() + capCity.substring(1);
                        weatherLinkList.add("https://pogoda.turtella.ru" + resort);
                        priceLinkList.add("https://www.numbeo.com/cost-of-living/in/" + city);
                    }
                }
            }
        }


    @Override
    public List<String> getListTurtella() {
        createList();
        return weatherLinkList;
    }

    @Override
    public List<String> getListNumbeo() {
        createList();
        return priceLinkList;
    }
}



