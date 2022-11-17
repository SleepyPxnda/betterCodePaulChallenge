package de.bcxp.challenge.comparator;

import de.bcxp.challenge.models.WeatherModel;

import java.util.Comparator;

public class SmallestTempSpreadComparator implements Comparator<WeatherModel> {

    @Override
    public int compare(WeatherModel o1, WeatherModel o2) {
       double spreado1 = o1.getMaxTemperature() - o1.getMinTemperature();
       double spreado2 = o2.getMaxTemperature() - o2.getMinTemperature();

       return Double.compare(spreado2, spreado1);
    }
}
