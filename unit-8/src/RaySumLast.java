//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class RaySumLast
{
	public RaySumLast() {
		
	}
	public static int go(int[] ray)
	{
		int num=0;
		for (int i : ray) {
			if(i>ray[ray.length-1]) {
				num+=i;
			}
		}
		return num;
	}
}