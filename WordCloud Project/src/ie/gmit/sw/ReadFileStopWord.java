package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadFileStopWord implements ReadFileInterfaces {

	private static BufferedReader bufferStopWord = null;
	private static FileReader fileRStopWord = null;
	private static String[] stopword = null;
	private static String strStopWord;
	private static String outputStopwords;

	public ReadFileStopWord() {
		
	}
	
	public ArrayList<String> getStopWords() throws IOException {

		ArrayList<String> stopWordsSetss = new ArrayList<String>();

		try {
			fileRStopWord = new FileReader(UserInputConsole.getStWordFileName());
			bufferStopWord = new BufferedReader(fileRStopWord);

			while ((strStopWord = bufferStopWord.readLine()) != null) {
				stopword = strStopWord.split(" ");

				
				removeCommonCharacters(stopword, stopWordsSetss, outputStopwords);

			}
		} catch (FileNotFoundException e) {
			System.out.println("Files not found.");
		} catch (IOException e) {
			System.out.println("Problem with reading files.");
		}
		bufferStopWord.close();
		fileRStopWord.close();

		return stopWordsSetss;
	}

		public void removeCommonCharacters(String[] str, ArrayList<String> list, String outpWords) {
			
			for (int i = 0; i < str.length; i++) {
				str[i] = str[i].replaceAll("[^a-zA-Z]", "").toLowerCase().trim();
				str[i].toLowerCase();
				outpWords = str[i].toLowerCase().trim();
				
				list.addAll(Arrays.asList(outpWords));

			}

		}

	
}
