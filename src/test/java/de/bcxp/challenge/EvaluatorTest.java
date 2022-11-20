package de.bcxp.challenge;

import de.bcxp.challenge.comparator.HighestDensityComparator;
import de.bcxp.challenge.comparator.SmallestTempSpreadComparator;
import de.bcxp.challenge.models.CountryModel;
import de.bcxp.challenge.models.CsvParameterDto;
import de.bcxp.challenge.models.WeatherModel;
import de.bcxp.challenge.reader.implementations.CountryReader;
import de.bcxp.challenge.reader.implementations.WeatherReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.stream.Stream;

public class EvaluatorTest {

    private static final String WEATHER_FILE_PATH = "src\\main\\resources\\de\\bcxp\\challenge\\weather.csv";
    private static final String COUNTRIES_FILE_PATH = "src\\main\\resources\\de\\bcxp\\challenge\\countries.csv";

    @BeforeEach
    void setUp() {}

    @DisplayName("Test if given country model comparator evaluates to result")
    @ParameterizedTest(name = "{index} => Comparator={0}, Result={1}")
    @MethodSource("countryCSVSuccessTestProvider")
    void countryCSVSuccessTest(Comparator<CountryModel> comp,  char separator, String result){
        CsvParameterDto parameterDto = new CsvParameterDto(COUNTRIES_FILE_PATH, separator, CountryModel.class);

        CountryModel model = new EvaluatorBuilder<CountryModel, CsvParameterDto>()
                .withComparator(comp)
                .useReader(new CountryReader())
                .process(parameterDto);

        assert model != null;
        assert model.getName().equalsIgnoreCase(result);
    }

    @DisplayName("Test if given weather model comparator evaluates to result")
    @ParameterizedTest(name = "{index} => Comparator={0}, Separator={1}, Expected={2}")
    @MethodSource("weatherCSVSuccessTestProvider")
    void weatherCSVSuccessTest(Comparator<WeatherModel> comp, char separator, String result){
        CsvParameterDto parameterDto = new CsvParameterDto(WEATHER_FILE_PATH, separator, WeatherModel.class);

        WeatherModel model = new EvaluatorBuilder<WeatherModel, CsvParameterDto>()
                .withComparator(comp)
                .useReader(new WeatherReader())
                .process(parameterDto);

        assert model != null;
        assert model.getDay().toString().equalsIgnoreCase(result);
    }

    @MethodSource
    private static Stream<Arguments> countryCSVSuccessTestProvider() {
        return Stream.of(
                Arguments.of(new HighestDensityComparator(), ';', "France")
        );
    }

    @MethodSource
    private static Stream<Arguments> weatherCSVSuccessTestProvider() {
        return Stream.of(
                Arguments.of(new SmallestTempSpreadComparator(), ',', "9")
        );
    }
}
