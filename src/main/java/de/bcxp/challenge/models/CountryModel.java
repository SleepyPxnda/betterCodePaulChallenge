package de.bcxp.challenge.models;

import com.opencsv.bean.CsvBindByPosition;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class CountryModel {

    @CsvBindByPosition(position = 0)
    String name;

    @CsvBindByPosition(position = 1)
    String capital;

    @CsvBindByPosition(position = 2)
    String accession;

    @CsvBindByPosition(position = 3)
    String population;

    @CsvBindByPosition(position = 4)
    Long area;

    /**
     * IN US$ / M
     */
    @CsvBindByPosition(position = 5)
    Double gdp;

    /**
     * Human development index
     */
    @CsvBindByPosition(position = 6)
    Double hdi;

    @CsvBindByPosition(position = 7)
    Integer europeanParliamentMembersCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopulation() {
        return population.replaceAll("\\.", "");
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "CountryModel{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", accession='" + accession + '\'' +
                ", population=" + population +
                ", area=" + area +
                ", gdp=" + gdp +
                ", hdi=" + hdi +
                ", europeanParliamentMembersCount=" + europeanParliamentMembersCount +
                '}';
    }
}
