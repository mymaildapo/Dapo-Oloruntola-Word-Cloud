package ie.gmit.sw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class CommonWordCloud extends JPanel implements RandomFont {

	
	public static BufferedImage buffimage = new BufferedImage(1200, 650, BufferedImage.TYPE_4BYTE_ABGR);
	public static Graphics2D graphs = buffimage.createGraphics();
	private static final long serialVersionUID = 1L;
	private int xPos;
	private int yPos;

	public CommonWordCloud() throws IOException {
		setBackground(Color.white);
	}

	public void drawWord(String strword, int fontSize) throws IOException {

		Random random = new Random();

		List<Rectangle2D> usedd = new ArrayList<>(25);

		Font f = getFontRandomly(fontSize);

		Color colourRandom = createFontRandomly(random);

		FontMetrics fm = graphs.getFontMetrics(f);
		Rectangle2D bonds = fm.getStringBounds(strword, graphs);
		

		do {
			xPos = random.nextInt(1200 - (int) bonds.getWidth());
			yPos = random.nextInt(700 - (int) bonds.getHeight());

			bonds.setFrame(xPos, yPos, bonds.getWidth(), bonds.getHeight());
			graphs.drawString(strword, xPos, yPos + fm.getAscent());
		} while (colison(usedd, bonds));
		usedd.add(bonds);
		graphs.setFont(f);
		graphs.setColor(colourRandom);
		
	}

	public Dimension getPreferredSize() {
		return new Dimension(1200, 650);
	}

	protected void paintomponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphic2d = (Graphics2D) g.create();
		graphic2d.drawImage(buffimage, 0, 0, this);
		graphic2d.dispose();
	}

	public boolean colison(List<Rectangle2D> usedd, Rectangle2D bonds) {
		boolean collide = false;
		for (Rectangle2D chk : usedd) {
			if ( bonds.intersects(chk)) {
				 collide  = true;
				break;
			}
		}
		return  collide ;
	}
	// ==================================

	public static void Write() throws IOException {

		ImageIO.write(buffimage , "png", new File("WordImage-G00259679.png"));
		System.out.println("TESING PART 2:Image has been as WordImage-G00259679.png");

	}


	public Color createFontRandomly(Random rand) {
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color randomColour = new Color(r, g, b);
		return randomColour;
	}

	public Font getFontRandomly(int fontSize) {
		Font fonts = new Font(Font.SANS_SERIF, Font.BOLD, fontSize);

		return fonts;
	}

}
