package de.bcxp.challenge.models;

import de.bcxp.challenge.reader.interfaces.IBaseParameterDto;

/**
 * Class to hold all needed parameters to parse a csv file
 */
public class CsvParameterDto implements IBaseParameterDto {

    /**
     * Filepath to the csv file
     */
    String filePath;

    /**
     * Separator used in the csv file
     */
    char separator;

    /**
     * Representation of the data in the csv
     */
    Class modelType;

    public CsvParameterDto(String filePath, char separator, Class modelType) {
        this.filePath = filePath;
        this.separator = separator;
        this.modelType = modelType;
    }

    public String getFilePath() {
        return filePath;
    }

    public char getSeparator() {
        return separator;
    }

    public Class getModelType() {
        return modelType;
    }
}
