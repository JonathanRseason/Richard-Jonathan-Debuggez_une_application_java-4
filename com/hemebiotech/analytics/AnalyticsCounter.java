package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
* Class that handle all logical operation of the program.
*/
public class AnalyticsCounter {
  private ISymptomReader reader;
  private ISymptomWriter writer;

  public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
    this.reader = reader;
    this.writer = writer;
  }

  public List<String> getSymptoms() {
    return this.reader.getSymptoms();
  }

  /**
  * Count from a text file the number of occurence for each symptoms.
  * @param  symptoms  list of the symptoms
  * @return a map with name of the symptoms, number of occurence
  */
  public Map<String, Integer> countSymptoms(List<String> symptoms) {
    Map<String, Integer> mapSymptoms = new HashMap<String, Integer>();
    for (String key : symptoms) {
      if (mapSymptoms.containsKey(key)) {
        mapSymptoms.put(key, mapSymptoms.get(key) + 1);
      } else {
        mapSymptoms.put(key, 1);
      }
    }
    return mapSymptoms;
  }

  /**
  * Sort a map by alphabetical order.
  * @param  symptoms an unsorted map
  * @return a sorted map
  */
  public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
    Map<String, Integer> sortMap = new TreeMap<String, Integer>(symptoms);
    return sortMap;
  }

  public void writeSymptoms(Map<String, Integer> symptoms) {
    this.writer.writeSymptoms(symptoms);
  }
}