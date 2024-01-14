package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelMaker {

    public static String path = "parserdata.xlsx";


    public static void excelSaver(List<Datalist> dataWeatherList) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("data");

        Row rowHeader = sheet.createRow(0);
        rowHeader.createCell(0).setCellValue("Город");
        rowHeader.createCell(1).setCellValue("Месяц");
        rowHeader.createCell(2).setCellValue("Средняя дневная температура");
        rowHeader.createCell(3).setCellValue("Средняя ночная температура");
        rowHeader.createCell(4).setCellValue("Солнечные дни");

        for (int rowNum = 0; rowNum < dataWeatherList.size(); rowNum++) {
            Row row = sheet.createRow(rowNum + 1);
            Datalist datalist = dataWeatherList.get(rowNum);
            row.createCell(0).setCellValue(datalist.getStrCity());
            row.createCell(1).setCellValue(datalist.getStrMonth());
            row.createCell(2).setCellValue(datalist.getStrDayTemperature());
            row.createCell(3).setCellValue(datalist.getStrNightTemperature());
            row.createCell(4).setCellValue(datalist.getStrSundays());
        }

        try (FileOutputStream out = new FileOutputStream(new File(path))) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Создан Excel-файл c данными Turtella");
    }

    public static void excelAdder(List<Datalist> dataLivingList) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook((new FileInputStream(path)));
        XSSFSheet sheet = workbook.getSheet("data");

        //Создаем шапку
        Row rowHeader = sheet.getRow(0);
        rowHeader.createCell(5).setCellValue("Стоимость Бананб 1кг");
        rowHeader.createCell(6).setCellValue("Пиво");
        rowHeader.createCell(7).setCellValue("Стоимость Бензин");
        rowHeader.createCell(8).setCellValue("Аренда квартиры в центре");

        for (int rowNum = 0; rowNum < dataLivingList.size(); rowNum++) {
            Row row = sheet.getRow(rowNum + 1);
            Datalist datalist = dataLivingList.get(rowNum);
            row.createCell(5).setCellValue(datalist.getStrBananaPrice());
            row.createCell(6).setCellValue(datalist.getStrBeerPrice());
            row.createCell(7).setCellValue(datalist.getStrGasPrice());
            row.createCell(8).setCellValue(datalist.getStrRentPrice());
        }

        try (FileOutputStream out = new FileOutputStream(new File(path))) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel-файл дополнен данными Numbeo");

    }
}

