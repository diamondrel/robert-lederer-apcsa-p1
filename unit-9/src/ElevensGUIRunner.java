import java.util.ArrayList;
import java.util.List;

/**
 * This is a class that plays the GUI version of the Elevens game.
 * See accompanying documents for a description of how Elevens is played.
 */
public class ElevensGUIRunner {

	/**
	 * Plays the GUI version of Elevens.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		Board board = new ElevensBoard();
//		CardGameGUI gui = new CardGameGUI(board);
//		gui.displayGame();
		List<Integer> selCards = new ArrayList<>();
		selCards.add(0);
		selCards.add(1);
		selCards.add(2);
		System.out.println(board.isLegal(selCards));
		System.out.println(selCards);
	}
}
