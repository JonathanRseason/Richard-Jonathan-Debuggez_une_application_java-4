package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.TreeMap;
import java.util.*;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	private ISymptomReader reader;
	private ISymptomWriter writer;
	//private Map<String, Integer> mapsymptoms = new HashMap<String, Integer>();
	//private Map<String, Integer> sortmap = new TreeMap<String, Integer>();

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer){
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return this.reader.getSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> mapsymptoms = new HashMap<String, Integer>();
		for (String key : symptoms) {
			if (mapsymptoms.containsKey(key)) {
				mapsymptoms.put(key, mapsymptoms.get(key) + 1);
			} else {
			    mapsymptoms.put(key, 1);
            }
		}
		return mapsymptoms;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sortmap = new TreeMap<String, Integer>(symptoms);
        return sortmap;
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		this.writer.writeSymptoms(symptoms);
	}

	public static void main(String args[]) throws Exception {
        System.out.println("TEST");
    }
}