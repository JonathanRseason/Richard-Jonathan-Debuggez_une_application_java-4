package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String args[]) throws Exception {

        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile();
        //ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("./symptoms.txt");
        //WriteSymptomDataToFile writer = new WriteSymptomDataToFile();
        AnalyticsCounter acounter = new AnalyticsCounter(reader, writer);

        List<String> listsymptoms = acounter.getSymptoms();

        Map<String, Integer> mapsymptoms = acounter.countSymptoms(listsymptoms);

        mapsymptoms = acounter.sortSymptoms(mapsymptoms);

        acounter.writeSymptoms(mapsymptoms);
    }
}