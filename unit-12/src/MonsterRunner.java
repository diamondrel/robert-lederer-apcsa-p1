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
		String typeO = "";
		while (!(typeO.equals("Skeleton")||typeO.equals("Witch"))) {
			System.out.print("Skeleton or Witch? -- ");
			String typeOtmp = keyboard.next();
			typeO = typeOtmp.substring(0,1).toUpperCase()+typeOtmp.substring(1);
		}
		System.out.print("Name of "+ typeO+"? -- ");
		String nameO = keyboard.next();
		int sizeO = -1;
		while(sizeO == -1) {
			System.out.print("Size of "+typeO+"? -- ");
			if (keyboard.hasNextInt())
				sizeO = keyboard.nextInt();
			else 
				System.out.println("As a whole integer please");
		}
		Monster one;
		if (typeO == "Skeleton") {
			one = new Skeleton(nameO,sizeO);
		}
		else {
			one = new Witch(nameO,sizeO);
		}
		String typeT = "";
		while (!(typeT.equals("Skeleton")||typeT.equals("Witch"))) {
			System.out.print("Skeleton or Witch? -- ");
			String typeTtmp = keyboard.next();
			typeT = typeTtmp.substring(0,1).toUpperCase()+typeTtmp.substring(1);
		}
		System.out.print("Name of "+typeT+"? -- ");
		String nameT = keyboard.next();
		int sizeT = -1;
		while(sizeT == -1) {
			System.out.print("Size of "+typeT+"? -- ");
			if (keyboard.hasNextInt())
				sizeT = keyboard.nextInt();
			else 
				System.out.println("As a whole integer please");
		}
		Monster two;
		if (typeT == "Skeleton") {
			two = new Skeleton(nameT,sizeT);
		}
		else {
			two = new Witch(nameT,sizeT);
		}

		
		System.out.print("Monster 1 - ");
		System.out.println(one);
		System.out.print("Monster 2 - ");
		System.out.println(two);
		String callO;
		String callT;
		if (one.namesTheSame(two)) {
			if (one.getClass()==two.getClass()) {
				callO = "Monster 1";
				callT = "Monster 2";
			}
			else {
				callO = one.getClass().toString();
				callT = one.getClass().toString();
			}
		}
		else {
			callO = one.getName();
			callT = two.getName();
		}
		if (one.isSmallerThan(two)) 
			System.out.println(callO+" is smaller than "+callT);
		else 
			System.out.println(callO+" is bigger than "+callT);
		if (one.namesTheSame(two)) 
			System.out.println(callO+" has the same name as "+callT);
		else 
			System.out.println(callO+" does not have the same name as "+callT);

	}
}