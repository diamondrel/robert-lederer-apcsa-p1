//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class GridRunner
{
	public static void main( String args[] ) throws IOException
	{
		
		Grid test = new Grid(7,7, new String[] {"a","7","x","b","C","2","9"});
		System.out.println(test);
		System.out.println(test.findMax(new String[] {"a","7","x"}));
	}
}