package de.bcxp.challenge;

import de.bcxp.challenge.comparator.HighestDensityComparator;
import de.bcxp.challenge.comparator.SmallestTempSpreadComparator;
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

        String dayWithSmallestTempSpread = TestWeatherModel(new SmallestTempSpreadComparator());   // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);

        String countryWithHighestPopulationDensity = TestCountryModel(new HighestDensityComparator()); // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }

    private static String TestCountryModel(Comparator<CountryModel> comp){
        CountryReader countryReader = new CountryReader();
        List<CountryModel> countryModels;
        try {
            countryModels = countryReader.readData(countriesFilePath);
        }catch (FileNotFoundException e){
            System.out.println("Cannot find File: " + weatherFilePath);
            return null;
        }
        
        CountryModel highestDensity = new Evaluator<CountryModel>(countryModels).process(comp);

        return highestDensity.getName();
    }

    private static String TestWeatherModel(Comparator<WeatherModel> comp){
        WeatherReader weatherReader = new WeatherReader();
        List<WeatherModel> weatherModels;
        try {
            weatherModels = weatherReader.readData(weatherFilePath);
        }catch (FileNotFoundException e){
            System.out.println("Cannot find File: " + weatherFilePath);
            return null;
        }

        WeatherModel smallestSpread = new Evaluator<WeatherModel>(weatherModels).process(new SmallestTempSpreadComparator());

        return smallestSpread.getDay().toString();
    }
}
