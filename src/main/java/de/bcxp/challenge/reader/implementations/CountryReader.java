package de.bcxp.challenge.reader.implementations;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import de.bcxp.challenge.models.CountryModel;
import de.bcxp.challenge.models.CsvParameterDto;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Class to read in the countries.csv file
 */
public class CountryReader extends AbstractCsvReader<CountryModel> {

    /**
     * Reads in data from a csv and additionally modifies the population row to fix error data
     * @param parameter which defines all needed information to parse the csv
     * @return a list of data retrieved from the csv
     */
    @Override
    public List<CountryModel> readData(CsvParameterDto parameter) {
        List<CountryModel> models;

        try {
            models = super.readData(parameter);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find the file specified in: " + parameter.getFilePath());
            return null;
        } catch (CsvDataTypeMismatchException e) {
            System.out.println("Cannot parse datatype "
                    + e.getSourceObject() + " to " + e.getDestinationClass().getName());
            return null;
        } catch (Exception e) {
            System.out.println("An unspecified Exception occurred." + e.getMessage());
            return null;
        }

        models.forEach(x -> x.setPopulation(x.getPopulation().replaceAll("\\.", "").replace(",", ".")));

        return models;
    }
}
