package de.bcxp.challenge.reader.implementations;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import de.bcxp.challenge.models.CsvParameterDto;
import de.bcxp.challenge.models.WeatherModel;
import de.bcxp.challenge.reader.interfaces.ICsvReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public abstract class AbstractCsvReader<T> implements ICsvReader<T> {
    @Override
    public List<T> readData(CsvParameterDto parameter) throws CsvDataTypeMismatchException, FileNotFoundException {
        List models = new CsvToBeanBuilder(new FileReader(parameter.getFilePath()))
                .withType(parameter.getModelType())
                .withSeparator(parameter.getSeparator())
                .withSkipLines(1)
                .build()
                .parse();

        return models;
    }
}
