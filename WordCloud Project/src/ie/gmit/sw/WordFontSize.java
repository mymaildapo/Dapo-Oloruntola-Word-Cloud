package ie.gmit.sw;

public class WordFontSize {

	public static int getFontSizes(int frequency) {

		int fontSizes= 18; 
		if (frequency >= 1 && frequency < 3) {
			fontSizes +=6;
	
		} else if (frequency > 3 && frequency <5) {
			fontSizes = fontSizes * 2;

		} else if (frequency >=5 && frequency <7) {
			fontSizes = fontSizes * 3;
		}
		else if(frequency >=7 && frequency <=10)
		{
			fontSizes = fontSizes * 4;
		}
		else if(frequency >10)
		{
			fontSizes = fontSizes * 5;
		}

		return fontSizes;
	}
}
