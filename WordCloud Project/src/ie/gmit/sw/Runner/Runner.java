package ie.gmit.sw.Runner;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import ie.gmit.URL.URLUnCommonWords;
import ie.gmit.URL.InputUserURL;
import ie.gmit.sw.*;


public class Runner {

	private static Scanner in = new Scanner(System.in);
	private static boolean ans = false;

	public static void main(String[] args) throws IOException {

		int optionNumber;

		System.out.println(" WELCOME TO Dapo WORD CLOUD MAIN MENU");
		System.out.println("==================================");
		System.out.println("1) Console");
		System.out.println("2) Web Link");

		try {
			do {

				System.out.println("Please, Enter Your Option...");
				optionNumber = in.nextInt();

				if (optionNumber == 1) {
					System.out.println("Console Option");
					UserInputConsole.userScannerInput();

					UnCommonWords words = new UnCommonWords();
					words.createUniqueWords();
					ans = true;
	
				} else if (optionNumber == 2) {
					System.out.println("Web Content Option");
					URLUnCommonWords uncommon = new URLUnCommonWords();

					InputUserURL.scannerInputs();
					uncommon.createUnCommonWords();
					ans = true;
				} else
					System.out.println("Invalid Input.");

			} while (ans == false);

		} catch (InputMismatchException ex) {
			System.out.println("Please Enter Numbers 1-2 Only");
		}

	}
}
