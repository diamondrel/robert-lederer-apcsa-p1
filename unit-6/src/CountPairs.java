//(c) A+ Computer Science
//www.apluscompsci.com
//Name

import static java.lang.System.*;

public class CountPairs
{
	public static int pairCounter( String str )
	{ 
		int count = 0;
		char th;
		for (var i=0;i<str.length()-1;i++) {
			th = str.charAt(i);
			if (th==str.charAt(i+1)){
				count++;
			}
		}
		return count;
	}
}