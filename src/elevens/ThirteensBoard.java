package elevens;

import java.util.ArrayList;

public class ThirteensBoard{

	/**
	 * Creates a new ThirteensBoard instance.
	 */
	public ThirteensBoard() {
		/* *** TO BE IMPLEMENTED IN Activity 4 *** */
	}

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Thirteens, the legal groups are (1) a pair of cards
	 * whose values add to 13, and (2) a king.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(ArrayList<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN Activity 4 *** */
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Thirteens, the legal groups are (1) a pair of cards
	 * whose values add to 13, and (2) a king.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		/* *** TO BE IMPLEMENTED IN Activity 4 *** */
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	protected boolean containsPairSum13(ArrayList<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	protected boolean containsK(ArrayList<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
	}
	
		/**
	 * Attempts to play either a pair that sums to 13 or a K
	 * @return true if there was a legal move to play; otherwise false
	 */
	protected boolean playIfPossible() {

		return false;

	}
}
