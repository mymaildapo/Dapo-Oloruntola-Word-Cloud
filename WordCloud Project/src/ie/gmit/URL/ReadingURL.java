package ie.gmit.URL;

import java.io.IOException;
import java.util.ArrayList;

import org.htmlparser.parserapplications.StringExtractor;
import org.htmlparser.util.ParserException;

public class ReadingURL {

	static ArrayList<String> temps = new ArrayList<String>();
	private String websiteContent;
	private String websiteLinks;

	public ReadingURL() {
		getWebLink();
		getWebContents();
	}

	public ReadingURL(String webContent) {

		setWebLink(webContent);
	}

	public String getWebContents() {
		return websiteContent;
	}

	public void setWebLink(String websiteContent) {
		this.websiteContent = websiteContent;
	}

	public String getWebLink() {
		return websiteLinks;
	}

	public void setWebsiteLink(String websiteLinks) {
		this.websiteLinks = websiteLinks;
	}

	public static void generateAnExtractContentFromWebsite(String wwwUrl) throws IOException {
		try {
			StringExtractor sExtract = new StringExtractor(wwwUrl);
			
			String contents = sExtract.extractStrings(false);
			
			URLProcessContents process = new URLProcessContents(contents);

			temps = process.TextReadingFromURL();
		} catch (ParserException e) {
			e.printStackTrace();
		}
	}

}
