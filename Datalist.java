package org.example;

public class Datalist {

    private String strCity;
    private String strMonth;
    private double strDayTemperature;
    private double strNightTemperature;
    private int strSundays;
    private Double strBananaPrice;
    private Double strBeerPrice;
    private Double strGasPrice;
    private Double strRentPrice;


    @Override
    public String toString() {
        return "Datalist{" +
                "strCity='" + strCity + '\'' +
                ", strMonth='" + strMonth + '\'' +
                ", strDayTemperature=" + strDayTemperature +
                ", strNightTemperature=" + strNightTemperature +
                ", strSundays=" + strSundays +
                ", strBananaPrice=" + strBananaPrice +
                ", strBeerPrice=" + strBeerPrice +
                ", strGasPrice=" + strGasPrice +
                ", strRentPrice=" + strRentPrice +
                '}';
    }

    public Datalist() {
    };

    public String getStrCity() {
        return strCity;
    }

    public String getStrMonth() {
        return strMonth;
    }

    public double getStrDayTemperature() {
        return strDayTemperature;
    }

    public double getStrNightTemperature() {
        return strNightTemperature;
    }

    public int getStrSundays() {
        return strSundays;
    }

    public double getStrBananaPrice() {
        return strBananaPrice;
    }

    public void setStrBananaPrice(Double strBananaPrice) {
        this.strBananaPrice = strBananaPrice;
    }

    public Double getStrBeerPrice() {
        return strBeerPrice;
    }

    public void setStrBeerPrice(Double strBeerPrice) {
        this.strBeerPrice = strBeerPrice;
    }

    public Double getStrGasPrice() {
        return strGasPrice;
    }

    public void setStrGasPrice(Double strGasPrice) {
        this.strGasPrice = strGasPrice;
    }

    public Double getStrRentPrice() {
        return strRentPrice;
    }

    public void setStrRentPrice(Double strRentPrice) {
        this.strRentPrice = strRentPrice;
    }



    public Datalist(String strCity, String strMonth, double strDayTemperature, double strNightTemperature, int strSundays, Double strRentPrice, double strBananaPrice, Double strBeerPrice, Double strGasPrice) {
        this.strCity = strCity;
        this.strMonth = strMonth;
        this.strDayTemperature = strDayTemperature;
        this.strNightTemperature = strNightTemperature;
        this.strSundays = strSundays;
        this.strBananaPrice = strBananaPrice;
        this.strBeerPrice = strBeerPrice;
        this.strGasPrice = strGasPrice;
        this.strRentPrice = strRentPrice;
    }

    public void setStrCity(String strCity) {
        this.strCity = strCity;
    }

    public void setStrMonth(String strMonth) {
        this.strMonth = strMonth;
    }

    public void setStrDayTemperature(double strDayTemperature) {
        this.strDayTemperature = strDayTemperature;
    }

    public void setStrNightTemperature(double strNightTemperature) {
        this.strNightTemperature = strNightTemperature;
    }

    public void setStrSundays(int strSundays) {
        this.strSundays = strSundays;
    }

};

