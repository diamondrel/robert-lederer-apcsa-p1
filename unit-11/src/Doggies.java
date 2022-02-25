//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;

public class Doggies
{
	private Dog[] pups;

	public Doggies(int size)
	{
		pups = new Dog[size];
	}
	
	public void set(int spot, int age, String name)
	{
		pups[spot] = new Dog(age,name);
	}

	public String getNameOfYoungest()
	{
		Dog minObj = null;
		int min = Integer.MAX_VALUE;
		for (Dog i : pups) {
			if (i.getAge()<min) {
				minObj = i;
				min = i.getAge();
			}
		}
		return minObj.getName();
	}

	public String getNameOfOldest()
	{
		Dog maxObj = null;
		int max = Integer.MIN_VALUE;
		for (Dog i : pups) {
			if (i.getAge()>max) {
				maxObj = i;
				max = i.getAge();
			}
		}
		return maxObj.getName();
	}

	public String toString()
	{
		return ""+Arrays.toString(pups);
	}
}