package ie.gmit.URL;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class InputUserURL {

	private static String websiteLinks;

	private static String stopWordFileName;
	private static Scanner console = new Scanner(System.in);

	public InputUserURL() {
		super();
	}

	
	public static void scannerInputs() throws IOException {

		String workingDirectory = System.getProperty("user.dir");

		File workingDirectoryFile = new File(workingDirectory);

		
		int i = 0;
		while (i == 0) {

			System.out.println("Please Enter Your Website Link Here  (www)");
			websiteLinks = console.nextLine();

			System.out.println("Please Enter Your Stop Words File Name");
			stopWordFileName = console.nextLine();
			File testFile = new File(workingDirectoryFile, stopWordFileName);

			if (!(websiteLinks.isEmpty() || stopWordFileName.isEmpty())) {

			
				if (testFile.exists()) {

					ReadingURL.generateAnExtractContentFromWebsite(websiteLinks);
					StopWordsFilesReading.setFileName(stopWordFileName);

					i = 1;
				} else {
					System.out.println("Wrong File Names... \nPlease try again");
				}

			} else {
				System.out.println("You Entered Invalid Data");
			}

		}

	}

	public static void main(String[] args) throws Throwable {

		URLUnCommonWords unique = new URLUnCommonWords();

		scannerInputs();
		unique.createUnCommonWords();

	}

}
