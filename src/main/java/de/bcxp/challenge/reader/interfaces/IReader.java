package de.bcxp.challenge.reader.interfaces;

import java.util.List;

/**
 * Base interface for data reader
 * @param <T> type of the class returned after the read
 * @param <U> type of the parameter dto to be sent in
 */
public interface IReader <T, U extends IBaseParameterDto> {
    List<T> readData(U parameter) throws Exception;
}
