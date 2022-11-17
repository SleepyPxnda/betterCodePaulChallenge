package de.bcxp.challenge.reader.implementations;

import com.opencsv.bean.CsvToBeanBuilder;
import de.bcxp.challenge.models.CountryModel;
import de.bcxp.challenge.reader.interfaces.CsvReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CountryReader implements CsvReader<CountryModel> {

    @Override
    public List<CountryModel> readData(String filepath) throws FileNotFoundException {

        List<CountryModel> models = new CsvToBeanBuilder(new FileReader(filepath))
                .withType(CountryModel.class)
                .withSeparator(';')

                .withSkipLines(1)
                .build()
                .parse();

        return models;
    }
}
