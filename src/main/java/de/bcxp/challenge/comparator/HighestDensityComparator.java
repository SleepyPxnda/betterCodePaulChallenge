package de.bcxp.challenge.comparator;

import de.bcxp.challenge.models.CountryModel;

import java.util.Comparator;

public class HighestDensityComparator implements Comparator<CountryModel> {
    @Override
    public int compare(CountryModel o1, CountryModel o2) {
        double densityModel1 = Double.parseDouble(o1.getPopulation()) * o1.getArea();
        double densityModel2 = Double.parseDouble(o2.getPopulation()) * o2.getArea();
        return Double.compare(densityModel2, densityModel1);
    }
}
