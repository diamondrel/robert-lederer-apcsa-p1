//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Lab  -

import static java.lang.System.*; 
import java.util.Scanner;

public class LeapYearRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		out.println(LeapYear.isLeapYear(1253));
		out.println(LeapYear.isLeapYear(209));
		out.println(LeapYear.isLeapYear(2132));
		out.println(LeapYear.isLeapYear(400));
		out.println(LeapYear.isLeapYear(4000));
		out.println(LeapYear.isLeapYear(1500));
		out.println(LeapYear.isLeapYear(1600));
	}
}