//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Recursion234Runner
{
	public static void main(String args[])
	{
		RecursionFunOne rec = new RecursionFunOne();
		RecursionFunThree recT = new RecursionFunThree();
		System.out.println(rec.countOddDigits(4532));
		System.out.println(rec.countOddDigits(42));
		System.out.println(rec.countOddDigits(111111));
		System.out.println(rec.countOddDigits(5239714));
		System.out.println("\n");
		System.out.println(recT.luckyThrees(4533));
		System.out.println(recT.luckyThrees(42));
		System.out.println(recT.luckyThrees(331113));
		System.out.println(recT.luckyThrees(5239334));

		//add more test cases
	}
}