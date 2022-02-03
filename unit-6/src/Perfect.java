//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Perfect
{
   private int number;
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
		for (int i=0;i<Math.sqrt(number);i++) {
			if(i!=0&&number%i == 0&&((number/i)+i)==number) {
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