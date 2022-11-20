package de.bcxp.challenge.models;

import com.opencsv.bean.CsvBindByPosition;

/**
 * Model to represent the data in the country.csv
 */
public class CountryModel {

    /**
     * Name of the country
     */
    @CsvBindByPosition(position = 0)
    String name;

    /**
     * Capital of the country
     */
    @CsvBindByPosition(position = 1)
    String capital;

    /**
     * Year of the accession into the European Union
     */
    @CsvBindByPosition(position = 2)
    String accession;

    /**
     * Population of the country
     */
    @CsvBindByPosition(position = 3)
    String population;

    /**
     * Area occupied by the country
     */
    @CsvBindByPosition(position = 4)
    Long area;

    /**
     * Gross domestic product of the country in US$ / M
     */
    @CsvBindByPosition(position = 5)
    Double gdp;

    /**
     * Human development index of the country
     */
    @CsvBindByPosition(position = 6)
    Double hdi;

    /**
     * Members in the european parliament of the country
     */
    @CsvBindByPosition(position = 7)
    Integer europeanParliamentMembersCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPopulation() {
        return population;
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
