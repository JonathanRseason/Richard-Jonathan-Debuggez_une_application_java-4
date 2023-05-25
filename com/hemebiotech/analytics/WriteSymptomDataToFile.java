package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
  /**
   * Write map with name of the symptoms, number of occurence in a file.
   * @param symptoms map of sorted symptoms
   */
  public void writeSymptoms(Map<String, Integer> symptoms) {
    try {
      FileWriter writer = new FileWriter("result.out");
      for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
        writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
      }
      writer.close();
    } catch (IOException ioe) {
      println("Oups !");
    }
  }
}