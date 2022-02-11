/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String suits[] = {"Giraffes","Lions"};
		String ranks[] = {"A", "B", "C"};
		int values[]= {1,2,6};
		Deck runner = new Deck(ranks,suits,values); 
		System.out.println(runner.toString());
	}
}
