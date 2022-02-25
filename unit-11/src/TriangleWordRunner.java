//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import static java.lang.System.*;

public class TriangleWordRunner
{
	public static void main( String args[] )
	{
		TriangleWord words = new TriangleWord();
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Wooorrrrddd! -- ");
		String word = keyboard.next();
		TriangleWord.printTriangle(word);
	}
}