package de.bcxp.challenge.models;

import net.sf.jsefa.csv.annotation.CsvDataType;
import net.sf.jsefa.csv.annotation.CsvField;

@CsvDataType()
public class WeatherModel {

    @CsvField(pos = 1)
    Integer day;

    @CsvField(pos = 2)
    Integer maxTemperature;

    @CsvField(pos = 3)
    Integer minTemperature;

    @CsvField(pos = 4)
    Double averageTemperature;

    //Maybe averageDataPoints
    @CsvField(pos = 5)
    Double avDP;

    @CsvField(pos = 6)
    Integer oneHourP;

    @CsvField(pos = 7)
    Integer TPcpn;

    @CsvField(pos = 8)
    Integer PDir;

    @CsvField(pos = 9)
    Integer avSP;

    @CsvField(pos = 10)
    Integer dir;

    @CsvField(pos = 11)
    Integer mxS;

    @CsvField(pos = 12)
    Integer skyC;

    @CsvField(pos = 13)
    Integer mxR;

    @CsvField(pos = 14)
    Integer mn;

    @CsvField(pos = 15)
    Integer rAvSLP;
}
