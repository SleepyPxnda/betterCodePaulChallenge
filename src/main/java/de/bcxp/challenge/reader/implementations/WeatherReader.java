package de.bcxp.challenge.reader.implementations;

import com.opencsv.bean.CsvToBeanBuilder;
import de.bcxp.challenge.models.WeatherModel;
import de.bcxp.challenge.reader.interfaces.CsvReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class WeatherReader implements CsvReader<WeatherModel> {
    @Override
    public List<WeatherModel> readData(String filepath) throws FileNotFoundException {

        List<WeatherModel> models = new CsvToBeanBuilder(new FileReader(filepath))
                .withType(WeatherModel.class)
                .withSkipLines(1)
                .build()
                .parse();

        return models;
    }
}
