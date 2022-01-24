//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class DistanceRunner
{
	public static void main( String[] args )
	{
		Scanner keyboard = new Scanner(in);

		out.print("Enter the first x :: ");
		int x1 = keyboard.nextInt();

		out.print("Enter the second x :: ");
		int x2 = keyboard.nextInt();

		out.print("Enter the first y :: ");
		int y1 = keyboard.nextInt();

		out.print("Enter the second y :: ");
		int y2 = keyboard.nextInt();
		Distance first = new Distance(x1,x2,y1,y2);
		first.setCoordinates(x1,x2,y1,y2);
		first.calcDistance();
		first.print();
	}
}