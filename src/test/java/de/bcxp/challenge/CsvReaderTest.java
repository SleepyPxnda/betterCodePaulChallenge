package de.bcxp.challenge;

import de.bcxp.challenge.models.CountryModel;
import de.bcxp.challenge.models.CsvParameterDto;
import de.bcxp.challenge.models.WeatherModel;
import de.bcxp.challenge.reader.implementations.CountryReader;
import de.bcxp.challenge.reader.implementations.WeatherReader;
import de.bcxp.challenge.reader.interfaces.ICsvReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CsvReaderTest {

    private static final String INVALID_COUNTRIES_FILE_PATH = "src\\main\\resources\\de\\bcxp\\challenge\\countriesssss.csv";
    private static final String VALID_COUNTRIES_FILE_PATH = "src\\main\\resources\\de\\bcxp\\challenge\\countries.csv";

    private static final String INVALID_WEATHER_FILE_PATH = "src\\main\\resources\\de\\bcxp\\challenge\\weatherssss.csv";
    private static final String VALID_WEATHER_FILE_PATH = "src\\main\\resources\\de\\bcxp\\challenge\\weather.csv";


    @DisplayName("Return of readData is null if file is not existing")
    @ParameterizedTest
    @MethodSource("csvReaderNullResults")
    void shouldReturnNull(ICsvReader reader, char separator, String filePath, Class type){
        CsvParameterDto dto = new CsvParameterDto(filePath, separator, type);
        try{
            assertNull(reader.readData(dto));
        }catch (Exception e){
            fail(e.getMessage());
        }
    }

    @DisplayName("Return of readData is not null if file is existing")
    @ParameterizedTest
    @MethodSource("csvReaderNotNullResults")
    void shouldReturnNotNull(ICsvReader reader, char separator, String filePath, Class type){
        CsvParameterDto dto = new CsvParameterDto(filePath, separator, type);
        try{
            assertNotNull(reader.readData(dto));
        }catch (Exception e){
            fail(e.getMessage());
        }
    }

    @MethodSource
    private static Stream<Arguments> csvReaderNotNullResults() {
        return Stream.of(
                Arguments.of(new CountryReader(),';', VALID_COUNTRIES_FILE_PATH,  CountryModel.class),
                Arguments.of(new WeatherReader(),',', VALID_WEATHER_FILE_PATH,  WeatherModel.class)
        );
    }

    @MethodSource
    private static Stream<Arguments> csvReaderNullResults() {
        return Stream.of(
                Arguments.of(new CountryReader(),';', INVALID_COUNTRIES_FILE_PATH,  CountryModel.class),
                Arguments.of(new CountryReader(),',', VALID_COUNTRIES_FILE_PATH,  CountryModel.class),
                Arguments.of(new WeatherReader(),',', INVALID_WEATHER_FILE_PATH,  WeatherModel.class),
                Arguments.of(new WeatherReader(),';', VALID_WEATHER_FILE_PATH,  WeatherModel.class)
        );
    }
}
