//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

public class Witch implements Monster
{
	String name="";
	int size=0;

	public Witch() {
		setName("");
		setSize(0);
	}
	
	public Witch(String n, int s) {
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
		if (other.getName().equals(name)) {
			return true;
		}
		return false;
	}

	public String toString() {
		String text=name+" - size "+size;
		return text;
	}
}