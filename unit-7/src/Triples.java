//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import static java.lang.System.*;

public class Triples
{
   private int num;

	public Triples()
	{
		this(0);
	}

	public Triples(int n)
	{
		setNum(n);
	}

	public void setNum(int n)
	{
		num = n;
	}
	
	public int greatestCommonFactor(int a, int b, int c)
	{
//		for (int i=num;i>0;i--) {
			int max = 0;
			if(a>b&&a>c) {
				max = a;
			}
			else if(b>c) {
				max = b;
			}
			else {
				max = c;
			}
			out.println(max);
			for (int j=(int)Math.floor(max/2); j>0; j--) {
				if((a%j==0)&&(b%j==0)&&(c%j==0)) {
					return j;
				}
			}
//		}
		return -1;
	}

	public String toString()
	{
		String output="";
		
		return output+"\n";
	}
}