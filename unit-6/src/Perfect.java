//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Perfect
{
   private int number;
   private int total;
   private String s;

	public Perfect() {
		
	}
	
	public Perfect(int num) {
		setNum(num);
	}
	
	public void setNum(int n) {
		number = n;
	}

	public boolean isPerfect()
	{
		total = 0;
		for (int i=1;i<=Math.ceil(number/2);i++) {
			if (number%i==0) {
				total+=i;
				System.out.println(total);
			}
			if(total==number) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		if (isPerfect()) {
			s = " is perfect";
		}
		else {
			s = " is not perfect";
		}
		return number + s;
	}
	
}