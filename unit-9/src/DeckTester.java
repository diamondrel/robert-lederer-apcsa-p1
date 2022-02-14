/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String suits[] = {"Diamonds","Clubs","Spades","Hearts"};
		String ranks[] = {"Ace", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		int values[]= {14,1,2,3,4,5,6,7,8,9,10,11,12,13};
		Deck runner = new Deck(ranks,suits,values); 
		System.out.println(runner.toString());
	}
}
