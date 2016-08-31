package ie.gmit.sw;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

public interface RandomFont {

	Color createFontRandomly(Random rand);
	
	Font getFontRandomly(int fontSize);
}
