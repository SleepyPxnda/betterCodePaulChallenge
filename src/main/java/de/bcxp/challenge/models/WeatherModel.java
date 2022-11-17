package de.bcxp.challenge.models;
import com.opencsv.bean.CsvBindByPosition;

import java.io.Serializable;

public class WeatherModel implements Serializable {

    @CsvBindByPosition(position = 0)
    Integer day;

    @CsvBindByPosition(position = 1)
    Integer maxTemperature;

    @CsvBindByPosition(position = 2)
    Integer minTemperature;

    @CsvBindByPosition(position = 3)
    Integer averageTemperature;

    //Maybe averageDataPoints
    @CsvBindByPosition(position = 4)
    Double avDP;

    @CsvBindByPosition(position = 5)
    Integer oneHourPTPcpn;

    @CsvBindByPosition(position = 6)
    Integer PDir;

    @CsvBindByPosition(position = 7)
    Double avSP;

    @CsvBindByPosition(position = 8)
    Integer dir;

    @CsvBindByPosition(position = 9)
    Integer mxS;

    @CsvBindByPosition(position = 10)
    Double skyC;

    @CsvBindByPosition(position = 11)
    Integer mxR;

    @CsvBindByPosition(position = 12)
    Integer mn;

    @CsvBindByPosition(position = 13)
    Double rAvSLP;


    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Integer maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Integer getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Integer minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Integer getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(Integer averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    @Override
    public String toString() {
        return "WeatherModel{" +
                "day=" + day +
                ", maxTemperature=" + maxTemperature +
                ", minTemperature=" + minTemperature +
                ", averageTemperature=" + averageTemperature +
                ", avDP=" + avDP +
                ", oneHourPTPcpn=" + oneHourPTPcpn +
                ", PDir=" + PDir +
                ", avSP=" + avSP +
                ", dir=" + dir +
                ", mxS=" + mxS +
                ", skyC=" + skyC +
                ", mxR=" + mxR +
                ", mn=" + mn +
                ", rAvSLP=" + rAvSLP +
                '}';
    }
}
