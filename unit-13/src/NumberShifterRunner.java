//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberShifterRunner
{
	public static void main( String args[] ) throws IOException
	{
		NumberShifter runner = new NumberShifter();
		int sizenum = 7;
		int[] arr = new int[] {1, 10, 9, 2, 8, 2, 5, 6, 10, 7, 9, 8, 6, 7, 2, 7, 6, 10, 5, 3};
		int[] run = runner.makeLucky7Array(sizenum);
		for (int i =0;i<sizenum;i++){
			run[i]=arr[i];
		}
		runner.shiftEm(arr);
	}
}



