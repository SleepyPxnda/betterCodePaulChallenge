package de.bcxp.challenge.reader.implementations;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import de.bcxp.challenge.models.CsvParameterDto;
import de.bcxp.challenge.models.WeatherModel;
import de.bcxp.challenge.reader.interfaces.ICsvReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class WeatherReader extends AbstractCsvReader<WeatherModel> {

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
