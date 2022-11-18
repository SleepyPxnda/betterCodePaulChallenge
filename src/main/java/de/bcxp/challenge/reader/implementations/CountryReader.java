package de.bcxp.challenge.reader.implementations;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import de.bcxp.challenge.models.CountryModel;
import de.bcxp.challenge.models.CsvParameterDto;

import java.io.FileNotFoundException;
import java.util.List;

public class CountryReader extends AbstractCsvReader<CountryModel> {

    @Override
    public List<CountryModel> readData(CsvParameterDto parameter) {
        List<CountryModel> models;

        try {
            models = super.readData(parameter);
        }catch (FileNotFoundException e){
            System.out.println("Cannot find the file specified in: " + parameter.getFilePath());
            return null;
        }catch (CsvDataTypeMismatchException e){
            System.out.println("Cannot parse datatype " + e.getSourceObject() + " to " + e.getDestinationClass().getName());
            return null;
        }catch (Exception e){
            System.out.println("An unspecified Exception occured." + e.getMessage());
            return null;
        }

        models.forEach(x -> x.setPopulation(x.getPopulation().replaceAll("\\.", "").replace(",",".")));

        return models;
    }
}
