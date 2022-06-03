public class Coordinate{
	int x,y;
	public Coordinate() {
		this(0,0);
	}
	public Coordinate(int row,int col) {
		x=col;
		y=row;
	}
	public int getCol() {
		return x;
	}
	public int getRow() {
		return y;
	}
	public String toString() {
		return "("+y+", "+x+")";
	}
}