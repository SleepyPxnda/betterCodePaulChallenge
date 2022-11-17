package de.bcxp.challenge.comparator;

import de.bcxp.challenge.models.CountryModel;

import java.util.Comparator;

public class HighestDensityComparator implements Comparator<CountryModel> {
    @Override
    public int compare(CountryModel o1, CountryModel o2) {

        String o1pop = o1.getPopulation().replaceAll("\\.", "").replace(",",".");
        String o2pop = o2.getPopulation().replaceAll("\\.", "").replace(",",".");

        double spreado1 = Double.parseDouble(o1pop) * o1.getArea();
        double spreado2 = Double.parseDouble(o2pop) * o2.getArea();
        return Double.compare(spreado2, spreado1);
    }
}
