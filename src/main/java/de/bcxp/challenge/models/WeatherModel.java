package de.bcxp.challenge.models;
import com.opencsv.bean.CsvBindByPosition;

import java.io.Serializable;

/**
 * Model to represent the data in the weather.csv
 */
public class WeatherModel implements Serializable {

    /**
     * Day of the weather data
     */
    @CsvBindByPosition(position = 0)
    Integer day;

    /**
     * Maximum temperature of the day
     */
    @CsvBindByPosition(position = 1)
    Integer maxTemperature;

    /**
     * Minimal temperature of the day
     */
    @CsvBindByPosition(position = 2)
    Integer minTemperature;

    /**
     * Average temperature of the day
     */
    @CsvBindByPosition(position = 3)
    Integer averageTemperature;

    /**
     * Representation of the 'avDP' column in the csv
     */
    @CsvBindByPosition(position = 4)
    Double avDP;

    /**
     * Representation of the 'oneHourPTPcpn' column in the csv
     */
    @CsvBindByPosition(position = 5)
    Integer oneHourPTPcpn;

    /**
     * Representation of the 'PDir' column in the csv
     */
    @CsvBindByPosition(position = 6)
    Integer PDir;

    /**
     * Representation of the 'avSP' column in the csv
     */
    @CsvBindByPosition(position = 7)
    Double avSP;

    /**
     * Representation of the 'dir' column in the csv
     */
    @CsvBindByPosition(position = 8)
    Integer dir;

    /**
     * Representation of the 'mxS' column in the csv
     */
    @CsvBindByPosition(position = 9)
    Integer mxS;

    /**
     * Representation of the 'skyC' column in the csv
     */
    @CsvBindByPosition(position = 10)
    Double skyC;

    /**
     * Representation of the 'mxR' column in the csv
     */
    @CsvBindByPosition(position = 11)
    Integer mxR;

    /**
     * Representation of the 'mn' column in the csv
     */
    @CsvBindByPosition(position = 12)
    Integer mn;

    /**
     * Representation of the 'rAvSLP' column in the csv
     */
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
