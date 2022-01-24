//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Lab  -

import static java.lang.System.*; 
import java.util.Scanner;

public class LeapYear
{
	public static boolean isLeapYear( int year )
	{
		if(!(year%400==0)) {
			if(!(year%4==0&&year%100!=0)) {
				return false;
			}
		}
		return true;
	}
}