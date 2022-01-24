//(c) A+ Computer Science
// www.apluscompsci.com

//Name - 
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Distance
{
	private int x1,y1,x2,y2;
	public Distance() {
		
	}
	public Distance(int xOne, int yOne, int xTwo, int yTwo)
	{
		setCoordinates(x1, x2, y1, y2);
	}

	public void setCoordinates(int xOne, int yOne, int xTwo, int yTwo)
	{
		xOne = x1;
		xTwo = x2;
		yOne = y1;
		yTwo = y2;
	}

	public String determineClosest( )
	{
		double distanceA = 0.0, distanceB = 0.0;
		distanceA = Math.sqrt(Math.pow(x1,2)+(Math.pow(y1, 2)));
		distanceB = Math.sqrt(Math.pow(x2,2)+(Math.pow(y2, 2)));
		String result="";
		if (distanceA>distanceB) {
			result="A is closer";
		}
		else if (distanceA==distanceB) {
			result="The distances are the same";
		}
		else {
			result="B is closer";
		}

		return result;
	}
	
	public String toString()
	{
		return "";
	}
}