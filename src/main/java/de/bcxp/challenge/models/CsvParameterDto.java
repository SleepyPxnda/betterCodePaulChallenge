package de.bcxp.challenge.models;

public class CsvParameterDto {
    String filePath;
    char separator;

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
