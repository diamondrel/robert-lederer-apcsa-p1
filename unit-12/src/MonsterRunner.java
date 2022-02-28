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

		Skeleton one = new Skeleton(nameO,sizeO);

		System.out.print("Name of Monster 1? -- ");
		String nameT = keyboard.next();
		System.out.print("Size of Monster 1? -- ");
		int sizeT = keyboard.nextInt();
		
		Skeleton two = new Skeleton(nameT,sizeT);
		
		System.out.println(one.toString(two));
	}
}