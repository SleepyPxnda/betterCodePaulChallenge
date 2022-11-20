package de.bcxp.challenge;

import de.bcxp.challenge.reader.interfaces.IBaseParameterDto;
import de.bcxp.challenge.reader.interfaces.IReader;

import java.util.Comparator;
import java.util.List;

/**
 * Builder to retrieve data from a csv and use a comparator to retrieve one entry
 * @param <T> type of model which will be retrieved
 * @param <U> type of the dto used in the reader
 */
public class EvaluatorBuilder<T, U extends IBaseParameterDto> {

    public Comparator<T> comparator;
    public IReader reader;

    public EvaluatorBuilder() {
    }

    /**
     * Adds a comparator the builder
     * @param comp comparator to be used
     * @return instance of the builder
     */
    public EvaluatorBuilder<T, U> withComparator(Comparator<T> comp){
        this.comparator = comp;
        return this;
    }

    /**
     * Adds a reader to the builder
     * @param reader reader to be used
     * @return instance of the builder
     */
    public EvaluatorBuilder<T, U> useReader(IReader reader){
        this.reader = reader;
        return this;
    }

    /**
     * Process the data and returns the first element of the list after beeing sorted by the comparator
     * @param parameters Parameters for the reader to read data
     * @return the first element of the sorted list
     */
    public T process(U parameters) {
        List<T> models;
        try {
            models = reader.readData(parameters);
        } catch (Exception e) {
            System.out.println("An Exception of type " + e.getCause() + " occurred. \n Message: " + e.getMessage());
            return null;
        }
        models.sort(comparator);
        return models.get(0);
    }
}
