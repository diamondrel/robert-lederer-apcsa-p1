//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

public class Skeleton implements Monster
{
	String name="";
	int size=0;

	public Skeleton() {
		setName("");
		setSize(0);
	}
	
	public Skeleton(String n, int s) {
		setName(n);
		setSize(s);
	} 
	
	public void setName(String n) {
		name = n;
	}
	
	public void setSize(int s) {
		size = s;
	}

	public int getHowBig() {
		return size;
	}
	public String getName() {
		return name;
	}
	public boolean isBiggerThan(Monster other) {
		if (size>other.getHowBig()) {
			return true;
		}
		return false;
	}
	public boolean isSmallerThan(Monster other) {
		if (size<other.getHowBig()) {
			return true;
		}
		return false;
	}
	
	public boolean namesTheSame(Monster other) {
		if (other.getName()==name) {
			return true;
		}
		return false;
	}

	public String toString(Monster other) {
		String text="Monster 1 - "+name+" - "+size+"\n"+"Monster 2 - "+other.getName()+" - "+other.getHowBig()+"\n\n";
		if (isSmallerThan(other)) 
			text+="Monster 1 is smaller than Monster 2";
		else 
			text+="Monster 1 is bigger than Monster 2";
		if (namesTheSame(other)) 
			text+="Monster 1 has the same name as Monster 2";
		else 
			text+="Monster 1 does not have the same name as Monster 2";
		return text;
	}
}