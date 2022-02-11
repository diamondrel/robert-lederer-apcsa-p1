/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card AceOfSpades = new Card("ace","spades",1);
		Card KingOfDiamonds = new Card("king","diamonds",13);
		Card SevenOfNine = new Card("seven","nine",5);
		System.out.println(AceOfSpades);
		System.out.println(KingOfDiamonds);
		System.out.println(SevenOfNine);
	}
}
