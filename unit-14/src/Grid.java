//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class Grid
{
   private String[][] grid;

   //load vals into the rows x cols grid randomly
	public Grid(int rows, int cols, String[] vals)
	{
		grid = new String[rows][cols];
		for (int i = 0;i<rows;i++) {
			for (int j = 0;j<cols;j++) {
				grid[i][j]=vals[(int) Math.floor(Math.random()*vals.length)];
			}
		}
	}

	//find out which of the vals occurs the most
	public String findMax(String[] vals)
	{
		int max = Integer.MIN_VALUE;
		String output = "";
		String maxStr = "";
		for (String i:vals) {
			if (countVals(i)>max) {
				max = countVals(i);
				maxStr = i;
			}
			output+=i+" appears "+countVals(i)+" times\n";
		}
		return output+maxStr+" appears the most, at "+max+" times";
	}

	//returns a count of how many times val occurs in the matrix
	private int countVals( String val )
	{
		int count = 0;
		for (String[] i:grid) {
			for (String j:i) {
				if (j.equals(val)) {
					count++;
				}
			}
		}
		return count;
	}

	//display the grid
	public String toString()
	{
		String output = "";
		for(String[] arr : grid){
			for(String i : arr) {
				output+=i+", ";
			}
			output+="\n";
		}
		return output;
	}
}