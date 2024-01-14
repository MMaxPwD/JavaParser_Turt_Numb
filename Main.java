package org.example;

import java.io.IOException;
import java.util.List;

import static org.example.ParserNumbeo.dataLivingList;
import static org.example.ParserTurtello.dataWeatherList;

public class Main {
    public static void main(String[] args) throws IOException {
        ListProvider parser = new ListCreator(); //создаем списки url-адресов для парсинга

        List TurtellaLinks = parser.getListTurtella(); // получаем список url для Turtelld
        List NumbeoLinks = parser.getListNumbeo(); // получаем список для url Numbeo

        ParserTurtello.parsingTurtella(TurtellaLinks); //запускаем парсер для Turtella, передавая список url для Turtella. Получаем список с данными dataWeatherList
        ParserNumbeo.parsingNumbeo(NumbeoLinks); //запускаем парсер для Numbeo, передавая список url для Numbeo. Получаем список с данными datalivingList

        ExcelMaker.excelSaver(dataWeatherList); //Сохраняем данные из Turtella в Excel-файл
        ExcelMaker.excelAdder(dataLivingList); //Добавляем данные из Numbeo в Excel-файл
        }
    }
