package de.bcxp.challenge;

import de.bcxp.challenge.comparator.HighestDensityComparator;
import de.bcxp.challenge.comparator.SmallestTempSpreadComparator;
import de.bcxp.challenge.models.CsvParameterDto;
import de.bcxp.challenge.reader.implementations.CountryReader;
import de.bcxp.challenge.reader.implementations.WeatherReader;
import de.bcxp.challenge.models.CountryModel;
import de.bcxp.challenge.models.WeatherModel;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    private static String weatherFilePath = "src\\main\\resources\\de\\bcxp\\challenge\\weather.csv";
    private static String countriesFilePath = "src\\main\\resources\\de\\bcxp\\challenge\\countries.csv";

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …
        CsvParameterDto weatherParameterDto = new CsvParameterDto(weatherFilePath, ',', WeatherModel.class);

        WeatherModel weatherModel = new EvaluatorBuilder<WeatherModel, CsvParameterDto>()
                .WithComparator(new SmallestTempSpreadComparator())
                .UseReader(new WeatherReader())
                .process(weatherParameterDto);

        CsvParameterDto countryParameterDto = new CsvParameterDto(countriesFilePath, ';', CountryModel.class);

        CountryModel countryModel = new EvaluatorBuilder<CountryModel, CsvParameterDto>()
                .WithComparator(new HighestDensityComparator())
                .UseReader(new CountryReader())
                .process(countryParameterDto);

        String dayWithSmallestTempSpread = weatherModel.getDay().toString();   // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);

        String countryWithHighestPopulationDensity = countryModel.getName(); // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
