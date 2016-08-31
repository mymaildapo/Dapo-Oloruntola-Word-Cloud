package ie.gmit.sw;

import java.io.File;
import java.util.Scanner;

public class UserInputConsole {

	private static Scanner console = new Scanner(System.in);

	private static String dictFileName;
	private static String stopWordFileName;

	public UserInputConsole() {
		super();
	}
	
	public UserInputConsole(String dictionaryName, String stopWords) {
		setDictFileName(dictionaryName);
		setStopWordFileName(stopWords);
	}

	public static String getDictionaryFileName()
	{
		if(dictFileName.isEmpty())
		{
			System.out.println("Enter Dictionary File Name");
		}
		else{
		
			return dictFileName;
		}
		return dictFileName;
	}

	public static void setDictFileName(String dictionaryFileName) {
		UserInputConsole.dictFileName = dictionaryFileName;
	}

	public static String getStWordFileName() {
		
		if(stopWordFileName.isEmpty())
		{
			System.out.println("Please enter Stop Word File Name");
		}
		else
		{
			return stopWordFileName;
		}
		
		return stopWordFileName;
	}

	public static void setStopWordFileName(String stpWrdFileName) {
		UserInputConsole.stopWordFileName = stpWrdFileName;
	}


	public static void userScannerInput() {

		String workingDirecotry = System.getProperty("user.dir");

		File workingworkingDirecotryFile = new File(workingDirecotry);

		int i = 0;
		while (i == 0) {
			System.out.println("(1) Please, Enter Your Word Dictionary File Name...");
			dictFileName = console.nextLine();

			File testFile1 = new File(workingworkingDirecotryFile, dictFileName);

			System.out.println("(2) Please, Enter Your Stop Words File Name...");
			stopWordFileName = console.nextLine();
			File testFile2 = new File(workingworkingDirecotryFile, stopWordFileName);

			if( !(dictFileName.isEmpty()|| stopWordFileName.isEmpty())){
				
				if (testFile1.exists() && testFile2.exists()) {
					
					new UserInputConsole(dictFileName, stopWordFileName);
			
					i = 1;
				} 
				else
				{
					System.out.println("You have entered the wrong File Names... \nPlease try again...");
				}
				
			}
			else
			{
				System.out.println("Please type file names");
			}
			
		}

	}

	public static void main(String[] args) throws Throwable {

		userScannerInput();

		UnCommonWords words = new UnCommonWords();
		words.createUniqueWords();

	}

}
