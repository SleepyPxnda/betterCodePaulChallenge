package de.bcxp.challenge;

import de.bcxp.challenge.models.CountryModel;
import de.bcxp.challenge.reader.implementations.CountryReader;
import de.bcxp.challenge.reader.interfaces.IReader;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;

public class Evaluator<T, U> {

    private IReader reader;
    private U parameters;

    public Evaluator(IReader reader, U parameters){
        this.reader = reader;
        this.parameters = parameters;
    }

    public T processListWithComparator(Comparator<T> comp){
        List<T> models;
        try {
            models = reader.readData(parameters);
        } catch (Exception e) {
            System.out.println("An Exception of type " + e.getCause() + " occured. \n Message: " + e.getMessage());
            return null;
        }
        models.sort(comp);
        return models.get(0);
    }
}
