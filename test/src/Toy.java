//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

import java.util.ArrayList; 

public class Toy{
	private String name="";
	private int count=0;
	public Toy() {
		setName("");
		setCount(0);
	}
	public Toy(String n) {
		setName(n);
	}
	public void setName(String n) {
		name = n;
	}
	public void setCount(int t) {
		count = t;
	}
	public String getName() {
		return name;
	}
	public int getCount() {
		return count;
	}
}