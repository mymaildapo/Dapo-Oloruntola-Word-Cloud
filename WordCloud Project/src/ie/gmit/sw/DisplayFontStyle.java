package ie.gmit.sw;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayFontStyle {

	
	public DisplayFontStyle() {
		super();
		
	}

	
	public static void randomlyCreateFont(JLabel label, JPanel panel) {
		int a1 = (int) (Math.random() * 255 - 0);
		int b2 = (int) (Math.random() * 255 - 0);
		int c3 = (int) (Math.random() * 255 - 0);
		label.setForeground(new java.awt.Color(a1, b2, c3));
		panel.add(label);

	}
	
	
	public static void displayArrayListSize(ArrayList<String> duplicate, String[] words, ArrayList<String> organizedDictionary, ArrayList<String> orgStopWord) {
		System.out.println("----------------------------");
		System.out.println("Duplicate Words..." + duplicate.size());
		System.out.println("Unique Words..." + words.length);

		System.out.println("Original Dict Words..." + organizedDictionary.size());
		System.out.println("Original Stop Words..." + orgStopWord.size());
		System.out.println("-----------------------");
		System.out.println("SUCCESSFULLY COMPLETED!!!");

	}
	
	
	

}
