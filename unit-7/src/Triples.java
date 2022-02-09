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
	private void pythagorean() {
		for (int i=0;i<num;i++) {
			if (i%2==1) {
				for (int j=0;j<num;j++) {
					if (((Math.pow(i, 2))-(Math.pow(j, 2)))%1==0) {
						greatestCommonFactor(j,(int)((Math.pow(i, 2))-(Math.pow(j, 2))),i);
					}
				}
			}
		}
	}
	
	private int greatestCommonFactor(int a, int b, int c)
	{
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
		for (int j=(int)(max/2); j>0; j--) {
			if((a%j==0)&&(b%j==0)&&(c%j==0)) {
				return j;
			}
		}
		return -1;
	}

	public String toString()
	{
		String output="";
		
		return output+"\n";
	}
}