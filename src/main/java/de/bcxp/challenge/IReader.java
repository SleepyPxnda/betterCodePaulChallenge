package de.bcxp.challenge;

import java.util.List;

public interface IReader <T, U> {

    List<T> readData(U parameter);
}
