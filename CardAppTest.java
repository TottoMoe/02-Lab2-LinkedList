/**
 * Card.java 
 * @author	Jenny Deng
 * @author	Yupeng Ni
 * CIS 22C, Lab 2
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class CardAppTest {
	private CardApp app1;
	private CardApp app2;

	private void setUp() {
		app1 = new CardApp();
		app2 = new CardApp();
		// read in from cards1.txt and cards2.txt here and insert the Cards into the
		// CardApps

		app1.setList(readCardFile("src/card1.txt"));
		app2.setList(readCardFile("src/card2.txt"));

	}

	private LinkedList<Card> readCardFile(String path) {
		LinkedList<Card> list = new LinkedList<Card>();
		
		File card1File = new File(path);
		Scanner scanner = null;
		try {
			scanner = new Scanner(card1File);
			String str = null;
			
			while (scanner.hasNext()) {
				str = scanner.next();
				// Get the last byte for suit, the rest for rank
				String rank = str.substring(0, str.length() - 1);
				String suit = str.substring(str.length() - 1, str.length());

				// add the card to the list
				Card card = new Card(rank, suit);
				list.addLast(card);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
		
	}

	@Test
	void testCardEquals() {
		Card c1 = new Card("10", "S");
		Card c2 = new Card("2", "S");
		assertFalse(c1.equals(c2));
		c1 = new Card("2", "S");
		assertTrue(c1.equals(c2));
		c2 = null;
		assertFalse(c1.equals(c2));
		CardApp c = new CardApp();
		assertFalse(c1.equals(c));
	}

	@Test
	void testCardCompareTo() {

		Card c1 = new Card("10", "S");
		Card c2 = new Card("2", "S");
		assertFalse(c1.compareTo(c2) < 0);
		c2 = new Card("q", "h");
		assertEquals("QH", c2.toString());
		assertTrue(c2.compareTo(c1) < 0);
		c2 = new Card("10", "D");
		assertTrue(c2.compareTo(c1) < 0);
		c2 = new Card("10", "s");
		assertEquals(c2, c1);
	}

	@Test
	void testToString() {
		setUp();
		assertEquals("2H 3H 4H 5H 6H 7H 8H 9H 10H JH \n", app1.toString());
		assertEquals(
				"AS 2S 3S 4S 5S 6S 7S 8S 9S 10S JS QS KS " + "AC 2C 3C 4C 5C 6C 7C 8C 9C 10C JC QC KC "
						+ "AH 2H 3H 4H 5H 6H 7H 8H 9H 10H JH QH KH " + "AD 2D 3D 4D 5D 6D 7D 8D 9D 10D JD QD KD \n",
				app2.toString());
	}

	@Test
	void testShuffle() {
		setUp();
		app1.shuffle();
		assertEquals("JH 8H 3H 10H 5H 9H 7H 2H 4H 6H \n", app1.toString());
		app2.shuffle();
		assertEquals("KD 7S 2S 9S 4S JS 6S KS 8S 2C 10S" + " 4C QS 6C AC 8C 3C 10C 5C QC 7C AH 9C"
				+ " 3H JC 5H KC 7H 2H 9H 4H JH 6H KH 8H 2D" + " 10H 4D QH 6D AD 8D 3D 10D 5D QD 7D JD 9D"
				+ " AS 3S 5S \n", app2.toString());
	}

	@Test
	void testSort() {
		setUp();

		app1.shuffle();
		app1.sort();
		assertEquals("2H 3H 4H 5H 6H 7H 8H 9H 10H JH \n", app1.toString());

		app2.shuffle();
		app2.sort();
		assertEquals(
				"2C 3C 4C 5C 6C 7C 8C 9C 10C JC QC KC AC " + "2D 3D 4D 5D 6D 7D 8D 9D 10D JD QD KD AD "
						+ "2H 3H 4H 5H 6H 7H 8H 9H 10H JH QH KH AH " + "2S 3S 4S 5S 6S 7S 8S 9S 10S JS QS KS AS \n",
				app2.toString());
		app1.clearDeck();
		app2.clearDeck();

	}

}