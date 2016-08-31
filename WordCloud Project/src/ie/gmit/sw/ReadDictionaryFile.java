package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadDictionaryFile implements ReadFileInterfaces {
	
	private static BufferedReader in = null;
	private static FileReader fileReader = null;
	private static String[] words = null;
	private static String WordsOutput;
	private static String s;

	
	public ReadDictionaryFile() {
		
	}
	
	public ArrayList<String> getTheDictionaryWords() throws IOException {
		
		ArrayList<String> DictList = new ArrayList<String>();

		try {

			fileReader = new FileReader(UserInputConsole.getDictionaryFileName());
															
			in = new BufferedReader(fileReader);

			while ((s = in.readLine()) != null) {
				words = s.split(" ");
				
				
				removeCommonCharacters(words, DictList, WordsOutput);
				
			}

		} catch (FileNotFoundException e) {
			System.out.println("Files not found.");
		} 
		
		fileReader.close();
		in.close();
		
		return DictList;
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
