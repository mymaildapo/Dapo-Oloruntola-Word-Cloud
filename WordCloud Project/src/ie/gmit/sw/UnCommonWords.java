package ie.gmit.sw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UnCommonWords {

	private static ArrayList<String> DicList;
	private static ArrayList<String> wordStop;
	private static String[] words;

	private static ArrayList<String> dupvalues = new ArrayList<String>();
	private static ArrayList<String> uncommonValues = new ArrayList<String>();
	private static Map<String, Integer> OccurrMap = new HashMap<>();

	public void createUniqueWords() throws IOException {

		ReadDictionaryFile dictionaryfiles = new ReadDictionaryFile();
		
		ReadFileStopWord stopFiles = new ReadFileStopWord();
		
		
		DicList = dictionaryfiles.getTheDictionaryWords();
		wordStop = stopFiles .getStopWords();

		for (String itemContain : DicList) {
			if (wordStop.contains(itemContain)) {
				dupvalues.add(itemContain);
			} else {
				uncommonValues.add(itemContain);
			}
		}
		for (String itms : uncommonValues) {

		
			if (itms.length() > 0) {
				if (OccurrMap.get(itms) == null) {
					OccurrMap.put(itms, 1);
				} else {
					int v = OccurrMap.get(itms).intValue();
					v++;
					OccurrMap.put(itms, v);
				}
			}

		}

	
		words = new String[uncommonValues.size()];
		words = uncommonValues.toArray(words);

		//
		Set<Map.Entry<String, Integer>> entrySetss = OccurrMap.entrySet();
		
		 List<Map.Entry<String, Integer>> itemList = new ArrayList<Map.Entry<String, Integer>>(entrySetss);
	        Collections.sort(itemList, new Comparator<Map.Entry<String, Integer>>() {
	            public int compare(Map.Entry<String, Integer> zero1,
	                    Map.Entry<String, Integer> zero2) {
	                return zero2.getValue().compareTo(zero1.getValue());
	            }
	        });

	    
	        
	        int count = 0;
			for (Map.Entry<String, Integer> entry : itemList) {

				count++;
				if (count == 100) {
					break;
				}
			

				int fontSize = WordFontSize.getFontSizes(entry.getValue());
				
				CommonWordCloud simpleword = new CommonWordCloud();
				simpleword.drawWord(entry.getKey(), fontSize);

			}
			CommonWordCloud.Write();
			DisplayFontStyle.displayArrayListSize(dupvalues, words, DicList, wordStop);
	}

}
