package de.bcxp.challenge.reader.interfaces;

import java.util.List;

public interface IReader <T, U> {
    List<T> readData(U parameter) throws Exception;
}
