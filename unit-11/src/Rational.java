//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

import javax.print.attribute.standard.MediaSize.Other; 

class Rational implements Comparable<Rational>
{
	int num, den;

	//CONSTRUCTORS
	public Rational() {
		setNum(1);
		setDen(1);
	}
	public Rational(int n, int d) {
		setNum(n);
		setDen(d);
	}
	//---

	public void setRational(int n, int d) {
		setNum(n);
		setDen(d);
	}
	
	//SET INTS
	public void setNum(int n) {
		num = n;
	}
	
	public void setDen(int d) {
		den = d;
	}
	//---
	
	public void add(Rational  other)
	{
		num = (num * other.getDen() + other.getNum() * den);
		den = (den * other.getDen());
		
		reduce();
	}

	private void reduce()
	{
		int i =0;
		if (num>den) {
			i=num;
		}
		else {
			i = den;
		}
		for (;i>0;i--) {
			if (num%i==0&&den%i==0) {
				num/=i;
				den/=i;
			}
		}
	}

	private int gcd(int numOne, int numTwo)
	{


		return 1;
	}

	public Object clone ()
	{
		return new Rational(num,den);
	}

	//ACCESSORS
	public int getDen() {
		return den;
	}
	
	public int getNum() {
		return num;
	}
	//---
	
	public boolean equals(Rational other)
	{
		other.reduce();
		reduce();
		if (other.getNum()==num&&other.getDen()==den) {
			return true;
		}
		return false;
	}

	public int compareTo(Rational other)
	{
		return (num-other.getNum());
	}
	public String toString() {
		return num+"/"+den;
	}
	
}