//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.Scanner;
import static java.lang.System.*;

public class SumLastRunner
{
	public static void main( String args[] )
	{
		int[] arr = {-99,1,2,3,4,5,6,7,8,9,10,5};
		RaySumLast test = new RaySumLast();
		
		System.out.println(test.go(arr));
	}
}