//(c) A+ Computer Science
import static java.lang.System.*;

public class MilesPerHour
{
	private int distance, hours, minutes;
	private double mph;
	
	public MilesPerHour(int dist, int hrs, int mins)
	{
		setNums(dist, hrs, mins);
	}

	public void setNums(int dist, int hrs, int mins)
	{
		distance = dist;
		hours = hrs;
		minutes = mins;
	}

	public void calcMPH()
	{
		if (minutes!=0) {
			mph=distance/(hours+(60/minutes));
		}
	}

	public void print()
	{
		out.println("Speed is "+mph+" miles per hour");
	}
	
	//create a print or toString or both
	
	public String toString()
	{
		return "";
	}
}