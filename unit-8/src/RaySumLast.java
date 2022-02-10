//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class RaySumLast
{
	public static int go(int[] ray)
	{
		int num=0;
		for (int i : ray) {
			if(ray[i]>ray[ray.length]) {
				num+=ray[i];
			}
		}
		return num;
	}
}