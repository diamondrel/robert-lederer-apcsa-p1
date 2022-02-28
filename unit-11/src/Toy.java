//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Toy implements Comparable<Toy>
{
	private String name;
	private int count = 1;

	public Toy()
	{
	}

	public Toy( String nm )
	{
		setName(nm);
	}
	
	public int getCount()
	{
		return this.count;
	}
	
	public void setCount( int cnt )
	{
		if (cnt < 0)
			count++;
		else
			count=cnt;
	}
	
	public String getName()
	{
		if (name==null) {
			return "";
		}
		return this.name;
	}
	
	public void setName( String nm )
	{
		name=nm;
	}
	
	@Override public int compareTo(Toy comparestu)
    {
        int compareage
            = ((Toy)comparestu).getCount();
  
        //  For Ascending order
        return this.count - compareage;
  
        // For Descending order do like this
        // return compareage-this.studentage;
    }

	public String toString()
	{
	   return this.name + " " + this.count;
	}
}