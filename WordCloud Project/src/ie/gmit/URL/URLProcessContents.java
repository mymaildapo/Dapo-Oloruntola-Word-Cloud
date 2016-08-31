package ie.gmit.URL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class URLProcessContents {

	private static String[] liness = null;
	private static String urlTexWords;
	private String text;

	public URLProcessContents(String text) {
		setText(text);
	}

	public URLProcessContents() {
		setText(text);
	}



	public String getTexts() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ArrayList<String> TextReadingFromURL() throws IOException {

		ArrayList<String> urlTextWord = new ArrayList<String>();

		liness = getTexts().split(" ");
		WordSplits(liness, urlTextWord, urlTexWords);

		return urlTextWord;
	}

	public void WordSplits(String[] str, ArrayList<String> list, String outWords) {

		for (int i = 0; i < str.length; i++) {
			str[i] = str[i].replaceAll("[^a-zA-Z]", "").toLowerCase().trim();
			str[i].toLowerCase();
			outWords = str[i].toLowerCase().trim();
			list.addAll(Arrays.asList(outWords));
		}

	}

	
}