package de.bcxp.challenge.models;

import net.sf.jsefa.csv.annotation.CsvDataType;
import net.sf.jsefa.csv.annotation.CsvField;

@CsvDataType()
public class CountryModel {

    @CsvField(pos = 1)
    String name;

    @CsvField(pos = 2)
    String capital;

    @CsvField(pos = 3)
    String accession;

    @CsvField(pos = 4)
    Integer population;

    @CsvField(pos = 5)
    Long area;

    /**
     * IN US$ / M
     */
    @CsvField(pos = 6)
    Double gdp;

    /**
     * Human development index
     */
    @CsvField(pos = 7)
    Double hdi;

    @CsvField(pos = 8)
    Integer europeanParliamentMembersCount;
}
