package de.bcxp.challenge.reader.interfaces;

import de.bcxp.challenge.models.CsvParameterDto;

/**
 * Interface for the csv readers
 * @param <T> type of model which will be returned after the read
 */
public interface ICsvReader<T> extends IReader<T, CsvParameterDto> {
}
