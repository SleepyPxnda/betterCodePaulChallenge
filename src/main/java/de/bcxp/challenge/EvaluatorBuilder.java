package de.bcxp.challenge;

import de.bcxp.challenge.reader.interfaces.IReader;

import java.util.Comparator;
import java.util.List;

public class EvaluatorBuilder<T, U> {

    public Comparator<T> comparator;
    public IReader reader;

    public EvaluatorBuilder() {
    }

    public EvaluatorBuilder<T, U> WithComparator(Comparator<T> comp){
        this.comparator = comp;
        return this;
    }

    public EvaluatorBuilder<T, U> UseReader(IReader reader){
        this.reader = reader;
        return this;
    }

    public T process(U parameters) {
        List<T> models;
        try {
            models = reader.readData(parameters);
        } catch (Exception e) {
            System.out.println("An Exception of type " + e.getCause() + " occured. \n Message: " + e.getMessage());
            return null;
        }
        models.sort(comparator);
        return models.get(0);
    }
}
