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

    private static String weatherFilePath = "src\\main\\resources\\de\\bcxp\\challenge\\weather.csv";
    private static String countriesFilePath = "src\\main\\resources\\de\\bcxp\\challenge\\countries.csv";

    @BeforeEach
    void setUp() {}

    @DisplayName("Test if given countrymodel comparator evaluates to result")
    @ParameterizedTest(name = "{index} => Comparator={0}, Result={1}")
    @MethodSource("countryCSVSuccessTestProvider")
    void CountryCSVSuccessTest(Comparator<CountryModel> comp,  char separator, String result){
        CsvParameterDto parameterDto = new CsvParameterDto(countriesFilePath, separator, CountryModel.class);
        Evaluator<CountryModel, CsvParameterDto> evaluator = new Evaluator<>(new CountryReader(), parameterDto);
        CountryModel model = evaluator.processListWithComparator(comp);

        assert model != null;
        assert model.getName().equalsIgnoreCase(result);
    }

    @DisplayName("Test if given weathermodel comparator evaluates to result")
    @ParameterizedTest(name = "{index} => Comparator={0}, Separator={1}, Expected={2}")
    @MethodSource("weatherCSVSuccessTestProvider")
    void WeatherCSVSuccessTest(Comparator<WeatherModel> comp, char separator, String result){
        CsvParameterDto parameterDto = new CsvParameterDto(weatherFilePath, separator, WeatherModel.class);
        Evaluator<WeatherModel, CsvParameterDto> evaluator = new Evaluator<>(new WeatherReader(), parameterDto);
        WeatherModel model = evaluator.processListWithComparator(comp);

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
