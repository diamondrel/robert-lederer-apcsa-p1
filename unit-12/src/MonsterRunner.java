//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import static java.lang.System.*;

public class MonsterRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Name of Monster 1? -- ");
		String nameO = keyboard.next();
		System.out.print("Size of Monster 1? -- ");
		int sizeO = keyboard.nextInt();

		Monster one = new Skeleton(nameO,sizeO);

		System.out.print("Name of Monster 2? -- ");
		String nameT = keyboard.next();
		System.out.print("Size of Monster 2? -- ");
		int sizeT = keyboard.nextInt();
		
		Monster two = new Skeleton(nameT,sizeT);
		
		System.out.print("Monster 1 - ");
		System.out.println(one);
		System.out.print("Monster 2 - ");
		System.out.println(two);
		if (one.isSmallerThan(two)) 
			System.out.println("Monster 1 is smaller than Monster 2");
		else 
			System.out.println("Monster 1 is bigger than Monster 2");
		if (one.namesTheSame(two)) 
			System.out.println("Monster 1 has the same name as Monster 2");
		else 
			System.out.println("Monster 1 does not have the same name as Monster 2");

	}
}