package com.epam.training;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.TreeMap;

import com.epam.training.measurement.Measurement;
import com.epam.training.meter.list.ListMeter;
import com.epam.training.meter.map.MapMeter;
import com.epam.training.meter.map.MapWithWrongKeyMeter;

public class Main {

    private static final int SIZE_10M = 10_000_000;
    private static final int SIZE_1M = 1_000_000;
    private static final int SIZE_100K = 100_000;
    private static final int SIZE_10K = 10_000;
    
    public static void main(String[] args) {
        System.out.println(" --- List measurement ---");
        new Measurement(
                new ListMeter(() -> new ArrayList<>()),
                new ListMeter(() -> new ArrayList<>(SIZE_10M)),
                new ListMeter(() -> new LinkedList<>())
            ).measureCollectionSetup(SIZE_10M)
             .measureFrequentChanges(SIZE_100K)
             .measureGet(SIZE_10M);
        
        System.out.println(" --- Map measurement ---");
        new Measurement(
                new MapMeter(() -> new HashMap<>()),
                new MapMeter(() -> new LinkedHashMap<>()),
                new MapMeter(() -> new TreeMap<>())
            ).measureCollectionSetup(SIZE_1M)
             .measureFrequentChanges(SIZE_1M)
             .measureGet(SIZE_1M);
        
        System.out.println(" --- Map with wrong key measurement ---");
        new Measurement(
                new MapWithWrongKeyMeter(() -> new HashMap<>()),
                new MapWithWrongKeyMeter(() -> new LinkedHashMap<>()),
                new MapWithWrongKeyMeter(() -> new TreeMap<>(Comparator.comparing(MapWithWrongKeyMeter.WrongClass::getString)))
            ).measureCollectionSetup(SIZE_10K)
             .measureFrequentChanges(SIZE_10K)
             .measureGet(SIZE_10K);
    }

}
