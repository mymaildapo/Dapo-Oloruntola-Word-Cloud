package ie.gmit.sw;

import java.util.Random;

public class CalculateRandomXYValues{

	public int getValueXRandomly()
	{
		Random random = new Random();
		int x = random.nextInt(1199) + 1;
		
		return x +(1);
		
	}
	public int getValueYRandomly()
	{
		Random random = new Random();
		
		int y = random.nextInt(849) + 1;
		
		return y - (40);
		
	}
}
