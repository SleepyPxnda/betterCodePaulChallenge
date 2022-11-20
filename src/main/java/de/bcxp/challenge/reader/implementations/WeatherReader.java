package de.bcxp.challenge.reader.implementations;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import de.bcxp.challenge.models.CsvParameterDto;
import de.bcxp.challenge.models.WeatherModel;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Class to read in the weather.csv
 */
public class WeatherReader extends AbstractCsvReader<WeatherModel> {

    /**
     * Reads in data from a csv
     * @param parameter which defines all needed information to parse the csv
     * @return a list of data retrieved from the csv
     */
    @Override
    public List<WeatherModel> readData(CsvParameterDto parameter) {
        try {
            return super.readData(parameter);
        }catch (FileNotFoundException e){
            System.out.println("Cannot find the file specified in: " + parameter.getFilePath());
            return null;
        }catch (CsvDataTypeMismatchException e){
            System.out.println("Cannot parse datatype " + e.getSourceObject() + " to " + e.getDestinationClass().getName());
            return null;
        }
    }
}
