package elevens;
import java.util.ArrayList;

/**
* The ElevensBoard class represents the board in a game of Elevens.
*/

public class ElevensBoard extends Board{
       /**
       * The size (number of cards) on the board.
       */

       private static final int BOARD_SIZE = 9;

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
              {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

       /**
       * Flag used to control debugging print statements.
       */

       private static final boolean I_AM_DEBUGGING = false;

       /**
       * Creates a new ElevensBoard instance.
       */

       public ElevensBoard() {
              /* *** TO BE IMPLEMENTED IN Activity 3 *** */
              super(BOARD_SIZE , RANKS, SUITS,  POINT_VALUES );
       }

 

       /**

       * Determines if the selected cards form a valid group for removal.
       * In Elevens, the legal groups are (1) a pair of non-face cards
       * whose values add to 11, and (2) a group of three cards consisting of
       * a jack, a queen, and a king in some order.
       * @param selectedCards the list of the indices of the selected cards.
       * @return true if the selected cards form a valid group for removal;
       *         false otherwise.
       */

       public boolean isLegal(ArrayList<Integer> selectedCards) {
              /* *** TO BE IMPLEMENTED IN Activity 3 *** */
    	   if(selectedCards.size() == 2 && cardAt(selectedCards.get(0)).getPointValue() + cardAt(selectedCards.get(1)).getPointValue() ==11) {
               return true;
    	   } else if (selectedCards.size() == 3 &&
               cardAt(selectedCards.get(0)).getPointValue() + 
               cardAt(selectedCards.get(1)).getPointValue() +  cardAt(selectedCards.get(2)).getPointValue()== 0 &&
               cardAt(selectedCards.get(1)).getRank() != cardAt(selectedCards.get(0)).getRank()  &&
               cardAt(selectedCards.get(1)).getRank() != cardAt(selectedCards.get(2)).getRank() &&
               cardAt(selectedCards.get(0)).getRank() != cardAt(selectedCards.get(2)).getRank()) {
         return true;
    	   }
    	   return false;
       }

       /**

       * Determine if there are any legal plays left on the board.
       * In Elevens, there is a legal play if the board contains
       * (1) a pair of non-face cards whose values add to 11, or (2) a group
       * of three cards consisting of a jack, a queen, and a king in some order.
       * @return true if there is a legal play left on the board;
       *         false otherwise.
       */
       @Override

       public boolean anotherPlayIsPossible() {
              /* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
                     for(int size = 0; size < cardIndexes().size(); size++) {
                           for(int size1 = 0; size1 < cardIndexes().size(); size1++) {
                                  if(cardAt(cardIndexes().get(size1)).getPointValue()+(cardAt(cardIndexes().get(size)).getPointValue()) ==11){
                                         return true;
                                  }
                           } 
                     }
                     boolean jack = false;
                     boolean queen = false;
                     boolean king = false;
                     for(int i = 0; i< size(); i++) {
                           if(cardAt(i) != null) {
                                  if (cardAt(i).getRank() == "jack") {
                                         jack = true;
                                  }
                                  if (cardAt(i).getRank() == "queen") {
                                         queen = true;
                                  }
                                  if (cardAt(i).getRank() == "king") {
                                         king = true;
                                  }
                           }
                     }
                     if (jack && queen && king) {
                           return true;
                     }
                     return false;
       }
      
       /**
       * Check for an 11-pair in the selected cards.
       * @param selectedCards selects a subset of this board.  It is list
       *                      of indexes into this board that are searched
       *                      to find an 11-pair.
       * @return true if the board entries in selectedCards
       *              contain an 11-pair; false otherwise.
       */

       protected boolean containsPairSum11(ArrayList<Integer> selectedCards) {
              /* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
            
              if(selectedCards.size() == 2) {
                     if(cardAt(selectedCards.get(1)).getPointValue() + cardAt(selectedCards.get(0)).getPointValue() ==11){
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

       protected boolean containsJQK(ArrayList<Integer> selectedCards) {
              /* *** TO BE IMPLEMENTED IN ACTIVITY 3 *** */
              if (selectedCards.size() == 3 &&
                           cardAt(selectedCards.get(0)).getPointValue() + cardAt(selectedCards.get(1)).getPointValue() + 
                           cardAt(selectedCards.get(2)).getPointValue()== 0 &&
                           cardAt(selectedCards.get(0)).getRank() != cardAt(selectedCards.get(1)).getRank() &&
                           cardAt(selectedCards.get(1)).getRank() != cardAt(selectedCards.get(2)).getRank() &&
                           cardAt(selectedCards.get(2)).getRank() != cardAt(selectedCards.get(0)).getRank()) {
                     return true;
              }
              return false;
       }

       /**
       * Attempts to play either a pair that sums to 11 or a JQK triplet
       * @return true if there was a legal move to play; otherwise false
       */
       
       protected boolean playIfPossible() {
              /* *** TO BE IMPLEMENTED IN ACTIVITY 5 *** */
              if(anotherPlayIsPossible()) {
                     return playPairSum11IfPossible() || playJQKIfPossible() ;
              }
              return false;
       }

       /**
       * Attempts to play a pair that sums to 11
       * @return true if there was a legal move to play; otherwise false
       */

       protected boolean playPairSum11IfPossible() {
              /* *** TO BE IMPLEMENTED IN ACTIVITY 5 *** */
              if (findPairSum11(cardIndexes()).size() ==2 ) {
              replaceSelectedCards(findPairSum11(cardIndexes()));
              return true;
              }
              return false;
      
       }

       /**
       * Attempts to play a JQK triplet
       * @return true if there was a legal move to play; otherwise false
       */

       protected boolean playJQKIfPossible() {
              /* *** TO BE IMPLEMENTED IN ACTIVITY 5 *** */
              ArrayList<Integer> arr = new ArrayList<Integer>();
              arr = findJQK(cardIndexes());
              if (arr.size() != 3 ) {  
                     return false;
                     }
              replaceSelectedCards(arr);
              return true;
              

       }
      
       /**
       * Check for a pair that sums to 11 in the selected cards.
       * @param selectedCards selects a subset of this board.  It is list
       *                      of indexes into this board that are searched
       *                      to find an 11-pair.
       * @return an ArrayList containint the pair of cards that sum to 11; otherwise an empty ArrayList.
       */

       protected ArrayList<Integer> findPairSum11(ArrayList<Integer> selectedCards) {
              /* *** TO BE IMPLEMENTED IN ACTIVITY 5 *** */
              ArrayList<Integer> arr = new ArrayList<Integer>();
                    
                     for(int i = 0; i < selectedCards.size(); i++) {
                           for(int j = 0; j < selectedCards.size(); j++) {
                                         if(cardAt(selectedCards.get(i)).getPointValue()+ cardAt(selectedCards.get(j)).getPointValue() ==11){
                                                arr.add(selectedCards.get(i));
                                                arr.add(selectedCards.get(j));
                                                return arr;  
                                         }
                                  }
                     	}
                     return arr;
       		}

       /**
       * find a JQK in the selected cards.
       * @param selectedCards selects a subset of this board.  It is list
       *                      of indexes into this board that are searched
       *                      to find a JQK group.
       * @return an ArrayList containint the triplet of face cards; otherwise an empty ArrayList.
       */
       
       protected ArrayList<Integer> findJQK(ArrayList<Integer> selectedCards) {
              /* *** TO BE IMPLEMENTED IN ACTIVITY 5 *** */
              ArrayList<Integer> arr = new ArrayList<Integer>();
              ArrayList<Integer> arr2 = new ArrayList<Integer>();
              boolean J = true;
              boolean Q = true;
              boolean K = true;
             
              for(int i = 0; i < selectedCards.size(); i++) {
              if (J && cardAt(selectedCards.get(i)).getRank().equals("jack")) {
                     J = false;
                     arr.add(selectedCards.get(i));
              }
              else if (Q && cardAt(selectedCards.get(i)).getRank().equals("queen")) {
                     Q = false;
                     arr.add(selectedCards.get(i));
              }
              else if (K && cardAt(selectedCards.get(i)).getRank().equals("king")) {
                     K = false;
                     arr.add(selectedCards.get(i));
              }    
          }

              if (arr.size() !=3) {
                     return arr2;
              }
              return arr;
       }
}
