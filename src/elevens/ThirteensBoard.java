package elevens;
import java.util.ArrayList;

public class ThirteensBoard extends Board{

       /**
       * Creates a new ThirteensBoard instance.
       */

       private static final int BOARD_SIZE = 10;

       /**
       * The ranks of the cards for this game to be sent to the deck.
       */
       
       private static final String[] RANKS =
              {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

       /**
       * The suits of the cards for this game to be sent to the deck.
       */

       private static final String[] SUITS =
              {"spades", "hearts", "diamonds", "clubs"};

       /**
       * The values of the cards for this game to be sent to the deck.
       */

       private static final int[] POINT_VALUES =
              {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0};

       /**
       * Flag used to control debugging print statements.
       */

       private static final boolean I_AM_DEBUGGING = false;
      
       public ThirteensBoard() {

           /* *** TO BE IMPLEMENTED IN Activity 4 *** */
              super(BOARD_SIZE , RANKS, SUITS,  POINT_VALUES );
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
    	   	  
    	   	  if(selectedCards.size() == 2 && cardAt(selectedCards.get(0)).getPointValue()
            		  + cardAt(selectedCards.get(1)).getPointValue() ==13) {
                     return true;

              } 
    	   	  else if (cardAt(selectedCards.get(0)).getPointValue() == 0 && selectedCards.size()== 1 ) {
    	   		  return true;
  	   	     } else {
              
              	return false;
  	   	     }
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
              for(int i = 0; i < size(); i++) {
                     for(int j = 0; j < size(); j++) {
                           if((cardAt(cardIndexes().get(i)).getPointValue() + cardAt(cardIndexes().get(j)).getPointValue()) ==13){
                                  return true;
                           }
                     }                   
              }
              boolean king = false;
              for(int i = 0; i< size(); i++) {          
                           if (cardAt(i).getRank() == "king") {
                                  king = true;
                           }
                     }
             
              if (king != true) {
                     return false;
              }
              else {
              return true;
              }
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
              if(selectedCards.size() == 2) {
                     if(cardAt(selectedCards.get(1)).getPointValue() + cardAt(selectedCards.get(0)).getPointValue() ==13){
                           return true;
                     }
              }
              return false;
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
              if (selectedCards.size()==1 && cardAt(selectedCards.get(0)).getPointValue() == 0) {
                     return true;
              }
              else {
              return false;
              }
       }

       /**
       * Attempts to play either a pair that sums to 13 or a K
       * @return true if there was a legal move to play; otherwise false
       */

       protected boolean playIfPossible() {
              return false;

       }
}
