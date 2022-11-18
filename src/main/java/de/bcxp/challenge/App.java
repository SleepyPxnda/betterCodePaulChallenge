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

        String dayWithSmallestTempSpread = TestWeatherCSV(new SmallestTempSpreadComparator());   // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);

        String countryWithHighestPopulationDensity = TestCountryCSV(new HighestDensityComparator()); // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }

    private static String TestCountryCSV(Comparator<CountryModel> comp){

        CsvParameterDto parameterDto = new CsvParameterDto(countriesFilePath, ';', CountryModel.class);

        Evaluator<CountryModel, CsvParameterDto> countryEvaluator = new Evaluator<>(new CountryReader(), parameterDto);

        CountryModel highestDensity = countryEvaluator.processListWithComparator(comp);

        if(highestDensity == null){
            System.out.println("Something went wrong parsing the CSV");
            return null;
        }

        return highestDensity.getName();
    }

    private static String TestWeatherCSV(Comparator<WeatherModel> comp){
        CsvParameterDto parameterDto = new CsvParameterDto(weatherFilePath, ',', WeatherModel.class);

        Evaluator<WeatherModel, CsvParameterDto> weatherEvaluator = new Evaluator<>(new WeatherReader(), parameterDto);

        WeatherModel smallestSpread = weatherEvaluator.processListWithComparator(comp);

        if(smallestSpread == null){
            System.out.println("Something went wrong parsing the CSV");
            return null;
        }

        return smallestSpread.getDay().toString();
    }
}
