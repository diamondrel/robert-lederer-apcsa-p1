//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

import java.util.Scanner;

public class WordsCompareRunner
{
   public static void main( String args[] )
   {
		Scanner keyboard = new Scanner( System.in );
		WordsCompare test = new WordsCompare();
		out.print("Enter string one :: ");
		String str = keyboard.nextLine();
		out.print("Enter string two :: ");
		String str2 = keyboard.nextLine();
		test.setWords(str, str2);
		test.compare();
		out.println(test);
	}
}