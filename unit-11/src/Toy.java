//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Toy
{
	private String name;
	private int count = 1;

	public Toy()
	{
	}

	public Toy( String nm )
	{
		
	}
	
	public int getCount()
	{
		return count;
	}
	
	public void setCount( int cnt )
	{
		count=cnt;
	}
	
	public String getName()
	{
		if (name==null) {
			return "";
		}
		return name;
	}
	
	public void setName( String nm )
	{
		name=nm;
	}

	public String toString()
	{
	   return "";
	}
}