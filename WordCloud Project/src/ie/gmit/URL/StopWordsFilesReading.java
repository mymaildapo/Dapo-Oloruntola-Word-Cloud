package ie.gmit.URL;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import ie.gmit.sw.ReadFileInterfaces;


public class StopWordsFilesReading implements ReadFileInterfaces {

	private static BufferedReader bufferRStopWord = null;
	private static FileReader fileReaderStopWord = null;
	private static String[] stopWords= null;
	private static String strStopWords;
	private static String outpStopwords;
	private static String fileName;

	public StopWordsFilesReading() {
		
	}
	
	public static void setFileName(String fName) {
		StopWordsFilesReading.fileName = fName;
	}
	
	public static String getFileName() {
		return fileName;
	}


	
	// getStopWordsFiles changed
	public ArrayList<String> getStopWordsFiles() throws IOException {

		ArrayList<String> stopWordsSetts = new ArrayList<String>();

		try {
			fileReaderStopWord = new FileReader("stopwords.txt");
			bufferRStopWord = new BufferedReader(fileReaderStopWord);

			while ((strStopWords = bufferRStopWord.readLine()) != null) {
				stopWords = strStopWords.split(" ");

				//remove all non character symbols
				removeCommonCharacters(stopWords, stopWordsSetts, outpStopwords);

			}
		} catch (FileNotFoundException e) {
			System.out.println("Files not found.");
		} catch (IOException e) {
			System.out.println("Problem with reading files.");
		}
		bufferRStopWord.close();
		fileReaderStopWord.close();

		return stopWordsSetts;
	}
	public void removeCommonCharacters(String[] str, ArrayList<String> list, String outWord) {
			
			for (int i = 0; i < str.length; i++) {
				str[i] = str[i].replaceAll("[^a-zA-Z]", "").toLowerCase().trim();
				str[i].toLowerCase();
				outWord = str[i].toLowerCase().trim();
				
			list.addAll(Arrays.asList(outWord));

			}

		}

	

}
