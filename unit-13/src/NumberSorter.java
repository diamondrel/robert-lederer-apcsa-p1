//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays; 
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSorter
{
	//instance variables and other methods not shown

	private static int getNumDigits(int number)
	{
		int count = String.valueOf(number).length();
		return count;
	}

	public static int[] getSortedDigitArray(int number)
	{
		int[] sorted = new int[getNumDigits(number)];
		int num = getNumDigits(number);
		for (int i=0;i<num;i++) {
			sorted[i]=number%10;
			number/=10;
		}
		for(int k=0;k<num;k++) {
		for (int i=1;i<num;i++) {
			if (sorted[i-1]<sorted[i]) {
				
			}
			else {
				int g = sorted[i-1];
				sorted[i-1]=sorted[i];
				sorted[i]=g;
			}
		}
		}
		return sorted;
	}
}