//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import static java.lang.System.*;

public class ToyRunner
{
	public static void main( String args[] )
	{
		ToyStore store = new ToyStore();
		store.loadToys("sorry gi_joe sorry yahtzee monopoly sorry gi_joe");
		store.outPrint();
	}
}