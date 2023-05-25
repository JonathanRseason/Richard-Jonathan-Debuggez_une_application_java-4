package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
  /**
   * Main of our program, instanciate class and applied logic iteration.
   */
  public static void main(String[] args) throws Exception {

    ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
    ISymptomWriter writer = new WriteSymptomDataToFile();
    AnalyticsCounter acounter = new AnalyticsCounter(reader, writer);

    List<String> listSymptoms = acounter.getSymptoms();

    Map<String, Integer> mapSymptoms = acounter.countSymptoms(listSymptoms);

    mapSymptoms = acounter.sortSymptoms(mapSymptoms);

    acounter.writeSymptoms(mapSymptoms);
  }
}