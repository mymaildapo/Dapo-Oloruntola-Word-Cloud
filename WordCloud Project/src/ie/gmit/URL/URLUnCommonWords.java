package ie.gmit.URL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ie.gmit.sw.*;

public class URLUnCommonWords {

	private static ArrayList<String> webContentsLists;
	private static ArrayList<String> stopWordsList;
	private static String[] wrds;

	private static ArrayList<String> duplValues = new ArrayList<String>();
	private static ArrayList<String> uncommonValues = new ArrayList<String>();
	private static Map<String, Integer> OccureMap = new HashMap<>();

	public void createUnCommonWords() throws IOException {

		StopWordsFilesReading stopFiles = new StopWordsFilesReading();
	
		webContentsLists = ReadingURL.temps;	
		stopWordsList = stopFiles.getStopWordsFiles();

		for (String items : webContentsLists) {
			if (stopWordsList.contains(items)) {
				duplValues.add(items);
			} else {
				uncommonValues.add(items);
			}
		}
		for (String itemms : uncommonValues) {

			if (itemms.length() > 0) {
				if (OccureMap.get(itemms) == null) {
					OccureMap.put(itemms, 1);
				} else {
					int value = OccureMap.get(itemms).intValue();
					value++;
					OccureMap.put(itemms, value);
				}
			}

		}

		wrds = new String[uncommonValues.size()];
		wrds = uncommonValues.toArray(wrds);

		//
		Set<Map.Entry<String, Integer>> entrySetts = OccureMap.entrySet();
	
		List<Map.Entry<String, Integer>> lists = new ArrayList<Map.Entry<String, Integer>>(entrySetts);
	        Collections.sort(lists, new Comparator<Map.Entry<String, Integer>>() {
	            public int compare(Map.Entry<String, Integer> zero1,
	                    Map.Entry<String, Integer> zero2) {
	                return zero2.getValue().compareTo(zero1.getValue());
	            }
	        });
	        
	        int count = 0;
			for (Map.Entry<String, Integer> entry : lists) {

				count++;
				if (count == 100) {
					break;
				}
		
				int fontSizes = WordFontSize.getFontSizes(entry.getValue());
			
				CommonWordCloud simpleWordFile = new CommonWordCloud();
				simpleWordFile.drawWord(entry.getKey(), fontSizes);

			}
			CommonWordCloud.Write();
			DisplayFontStyle.displayArrayListSize(duplValues, wrds, webContentsLists, stopWordsList);
	}

}
