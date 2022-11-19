package de.bcxp.challenge;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import de.bcxp.challenge.comparator.HighestDensityComparator;
import de.bcxp.challenge.comparator.SmallestTempSpreadComparator;
import de.bcxp.challenge.models.CountryModel;
import de.bcxp.challenge.models.CsvParameterDto;
import de.bcxp.challenge.models.WeatherModel;
import de.bcxp.challenge.reader.implementations.CountryReader;
import de.bcxp.challenge.reader.implementations.WeatherReader;
import de.bcxp.challenge.reader.interfaces.ICsvReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CsvReaderTest {

    private static String invalidCountriesFilePath = "src\\main\\resources\\de\\bcxp\\challenge\\countriesssss.csv";
    private static String validCountriesFilePath = "src\\main\\resources\\de\\bcxp\\challenge\\countries.csv";

    private static String invalidWeatherFilePath = "src\\main\\resources\\de\\bcxp\\challenge\\weatherssss.csv";
    private static String validWeatherFilePath = "src\\main\\resources\\de\\bcxp\\challenge\\weather.csv";


    @DisplayName("Return of readData is null if file is not existing")
    @ParameterizedTest
    @MethodSource("csvReaderNullResults")
    void ShouldReturnNull(ICsvReader reader, char separator, String filePath, Class type){
        CsvParameterDto dto = new CsvParameterDto(filePath, separator, type);
        try{
            assertNull(reader.readData(dto));
        }catch (Exception e){
        }
    }

    @DisplayName("Return of readData is not null if file is existing")
    @ParameterizedTest
    @MethodSource("csvReaderNotNullResults")
    void ShouldReturnNotNull(ICsvReader reader, char separator, String filePath, Class type){
        CsvParameterDto dto = new CsvParameterDto(filePath, separator, type);
        try{
            assertNotNull(reader.readData(dto));
        }catch (Exception e){
            fail();
        }
    }

    @MethodSource
    private static Stream<Arguments> csvReaderNotNullResults() {
        return Stream.of(
                Arguments.of(new CountryReader(),';', validCountriesFilePath,  CountryModel.class),
                Arguments.of(new WeatherReader(),',', validWeatherFilePath,  WeatherModel.class)
        );
    }

    @MethodSource
    private static Stream<Arguments> csvReaderNullResults() {
        return Stream.of(
                Arguments.of(new CountryReader(),';', invalidCountriesFilePath,  CountryModel.class),
                Arguments.of(new CountryReader(),',', validCountriesFilePath,  CountryModel.class),
                Arguments.of(new WeatherReader(),',', invalidWeatherFilePath,  WeatherModel.class),
                Arguments.of(new WeatherReader(),';', validWeatherFilePath,  WeatherModel.class)
        );
    }
}
