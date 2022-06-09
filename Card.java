/**
 * Card.java 
 * @author	Jenny Deng
 * @author	Yupeng Ni
 * CIS 22C, Lab 2
 */
public class Card implements Comparable<Card>{
  private String rank;
  private String suit;
  
  /**
   * Constructor for the Card class
   * @param rank the rank of card from 2 to A
   * @param suit the suit of card C, D, H, or S
   */
  public Card(String rank, String suit) {
     this.rank = rank.toUpperCase();
     this.suit = suit.toUpperCase();
  }
  
  /**
   * Returns the card's rank 
   * @return rank a rank from 2 (low) to A (high)
   */
  public String getRank() {
      return rank;
  }
  
  /**
   * Returns the card's suit 
   * @return C, D, H, or S
   */
  public String getSuit() {
      return suit;
  }
  
  /**
   * Updates the card's rank
   * @param rank a new rank
   */
  public void setRank(String rank) {
     this.setRank(rank);
  }
  
  /**
   * Updates the card's suit
   * @param suit the new suit
   */
  public void setSuit(String suit) {
     this.setSuit(suit);
  }
  
  /**
   * Concatenates rank and suit
   */
  @Override 
  public String toString() {
      return rank.toUpperCase()+suit.toUpperCase();
  }
  
  /**
   * Overrides the equals method for Card
   * Compares rank and suit and 
   * follows the equals formula given in
   * Lesson 4 and also in Joshua Block's text
   * @precondition o!=null
   * @param obj another Object to compare for
   * equality
   * @return whether obj is a Card and, if so,
   * of equal rank and suit
   */
  @Override 
  public boolean equals(Object o) {
    if(o == this) {
          return true;
      } else if (!(o instanceof Card)) {
          return false;
      } else {
        Card tempCard = (Card) o;
        
        if(this == null || o == null ) {
          return this.equals(o);
        }
        
        if(this.rank.equals(tempCard.rank) && this.suit.equals(tempCard.suit)) {
          return true;
        }
        
        return false;
      }
  }
  
  /**
   * Orders two cards first by suit (alphabetically)
   * Next by rank. "A" is considered the high card
   * Order goes 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A
   * @param card another Card to compare to this Card
   * @return a negative number if this comes before c
   * and a positive number if c comes before this
   * and 0 if this and c are equal according to the above
   * equals method
   */
  @Override 
  public int compareTo(Card card) {
    
    if(this.equals(card)) {
      return 0;
    }
    
    String[] suitOrder = {"C","D","H","S"};
    String[] rankOrder = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    
    int suitIndex = -1;
    int cSuitIndex = -1;
    int rankIndex = -1;
    int cRankIndex = -1;
    
    //get the suit index for this and c
    for (int i = 0; i < suitOrder.length; i++) {
    if(suitOrder[i].equals(this.suit)) {
      suitIndex = i;
    }
    
    if(suitOrder[i].equals(card.suit)) {
      cSuitIndex = i;
    }
  }
    
    int suitResult = suitIndex - cSuitIndex;
    
    if(suitResult != 0) {
      return suitResult;
    }
    
    
    //get the rank index for this and c
    for (int i = 0; i < rankOrder.length; i++) {
    if(rankOrder[i].equals(this.rank)) {
      rankIndex = i;
    }
    if(rankOrder[i].equals(card.rank)) {
      cRankIndex = i;
    }
  }
    
    return rankIndex - cRankIndex;
    
  }

}