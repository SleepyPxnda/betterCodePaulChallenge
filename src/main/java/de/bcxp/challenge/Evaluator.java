package de.bcxp.challenge;

import java.util.Comparator;
import java.util.List;

public class Evaluator<T> {

    private List<T> data;

    public Evaluator(List<T> data){
        this.data = data;
    }

    public T process(Comparator<T> comp){
        data.sort(comp);
        return data.get(0);
    }
}
