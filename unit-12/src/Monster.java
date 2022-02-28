//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

public interface Monster
{
	public int getHowBig();
	public String getName();
	public boolean isBiggerThan(Monster other);	
	public boolean isSmallerThan(Monster other);
	public boolean namesTheSame(Monster other);
}