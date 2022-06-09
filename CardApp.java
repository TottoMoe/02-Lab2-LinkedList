/**
 * Card.java 
 * @author	Jenny Deng
 * @author	Yupeng Ni
 * CIS 22C, Lab 2
 */
public class CardApp {
    
  private LinkedList<Card> list;
  

/**
   * Default constructor to initialize the deck
   */
  public CardApp() {
    list = new LinkedList<Card>();
  }
  
  public void setList(LinkedList<Card> list) {
  this.list = list;
}


public LinkedList<Card> getList() {
    return list;
  }
  
  /**
   * Inserts a new Card into the deck
   * @param card a playing Card
   */
  public void addCard(Card card) throws NullPointerException {
    if(null == card) {
      throw new NullPointerException();
    }
    list.addLast(card);
  }
  
  /**
   * Shuffles cards following this algorithm:
   * First swaps first and last card
   * Next, swaps every even card with the card 3 
   * nodes away from that card. Stops when it
   * reaches the 3rd to last node
   * Then, swaps ALL cards with the card that is 
   * 2 nodes away from it, stopping at the 3rd
   * to last node
   */
  public void shuffle() {
    
    
    //First swaps first and last card
    list.revolvingList(1);
    
    Card[] cards = listToArray(list);
    
    //swap set1
    for (int i = 0; i < cards.length; i++) {
      
      if((cards.length - i > 3) && i % 2 != 0) {
        
        Card temp = cards[i + 3];
        cards[i + 3] = cards[i];
        cards[i] = temp;
        
      }
      
  }
    
    //swap set2
    for (int i = 1; i < cards.length; i++) {
        
      if(cards.length - i > 2) {
          
        Card temp = cards[i + 2];
        cards[i + 2] = cards[i];
        cards[i] = temp;
          
      }
        
  }
    
    list = new LinkedList<Card>(cards);
    
  }
  
  /**
 * Convert LinkedList to Array
 * @precondition list != null
 * @throw NullPointerException when iterator is null
 * @return the card array with the copy of list
 */
  public Card[] listToArray(LinkedList<Card> list) throws NullPointerException {
    
    if(list.getLength() == 0) {
      throw new NullPointerException();
    }
    
    int length = list.getLength();
    Card[] cards = new Card[length];
    
    list.positionIterator();
    int i = 0;
    
    while(i < length) {
      cards[i] = list.getIterator();
      list.advanceIterator();
      i++;
    }
    
    return cards;
  }
 
  /**
   * Implements the bubble sort algorithm
   * to sort L into sorted order, first by suit
   * (alphabetical order)
   * then by rank from 2 to A
   */
  public void sort() {
    
    Card[] cards = listToArray(list);
    
    for (int i = 0; i < cards.length - 1; i++) {
    
      for (int j = 0; j < cards.length - 1 - i; j++) {
      
        Card first = cards[j];
      Card next = cards[j + 1];
      
        if(first.compareTo(next) > 0) {
          cards[j] = next;
          cards[j + 1] = first;
        }
        
    }
      
  }
    
    list = new LinkedList<Card>(cards);
    
  }
  
  /**
   * Returns the deck of cards with each card separated
   * by a blank space and a new line character at the 
   * end.
   */
  @Override 
  public String toString() {
      return list.toString();
  }


public void clearDeck() {
  list = null;
}

}