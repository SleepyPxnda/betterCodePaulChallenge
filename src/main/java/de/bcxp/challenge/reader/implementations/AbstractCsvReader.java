package de.bcxp.challenge.reader.implementations;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import de.bcxp.challenge.models.CsvParameterDto;
import de.bcxp.challenge.reader.interfaces.ICsvReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * Base of all csv readers, Implementation of ICSVReader<T>
 * @param <T> Type of model which will be returned by the reader
 */
public abstract class AbstractCsvReader<T> implements ICsvReader<T> {
    @Override
    public List<T> readData(CsvParameterDto parameter) throws CsvDataTypeMismatchException, FileNotFoundException {
        return new CsvToBeanBuilder<T>(new FileReader(parameter.getFilePath()))
                .withType(parameter.getModelType())
                .withSeparator(parameter.getSeparator())
                .withSkipLines(1)
                .build()
                .parse();
    }
}
