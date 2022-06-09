/**
 * Card.java 
 * @author	Jenny Deng
 * @author	Yupeng Ni
 * CIS 22C, Lab 2
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
class LinkedListTest {

	@Test
	void testLinkedList() {
		LinkedList<String> list = new LinkedList<String>();
		
		assertThrows(NoSuchElementException.class, ()->{list.getFirst();}); //test 1
		
		list.addFirst("A");
		assertEquals("A", list.getFirst());	//test 2
		
		list.addFirst("B");
		assertFalse("B" == list.getLast());	//test 3
		
		assertEquals("A", list.getLast()); 	//test 4
		
	}

	@Test
	void testLinkedListTArray() {
		Integer[] arr = {1,2,3,4,5,6,7,8,9,10};
		LinkedList<Integer> list = new LinkedList<Integer>(arr);
		
		assertEquals("1 2 3 4 5 6 7 8 9 10 \n", list.toString());	//test 1
		
		list.addFirst(0);
		assertTrue("0 1 2 3 4 5 6 7 8 9 10 \n".equals(list.toString()));	//test 2
		
		list.removeFirst();
		assertFalse("0 1 2 3 4 5 6 7 8 9 10 \\n".equals(list.toString()));	//test 3
		
	}

	@Test
	void testLinkedListLinkedListOfT() {
	}

	@Test
	void testGetFirst() {
		
		LinkedList<String> list = new LinkedList<String>();
		
		assertThrows(NoSuchElementException.class, ()->{list.getFirst();}); //test 1
		
		list.addFirst("A");
		list.positionIterator();
		list.addIterator("C");
		list.addIterator("B");
		
		assertEquals("A", list.getFirst());	//test 2
		
		list.addFirst("D");
		assertTrue("D" == list.getFirst());	//test 3
		
	}

	@Test
	void testGetLast() {
		
		LinkedList<String> list = new LinkedList<>();
        assertThrows(NoSuchElementException.class, ()->{list.getLast();}); //test 1
        list.addFirst("A");
        assertEquals("A", list.getLast()); //test 2
        list.addLast("B");
        assertTrue(list.getLast().equals("B")); //test 3
        list.removeLast();
        assertNotEquals("B", list.getLast()); //test 4
		
	}

	@Test
	void testGetIterator() {
		LinkedList<String> list = new LinkedList<String>();
		
		assertThrows(NullPointerException.class, ()->{list.getIterator();}); //test 1
		
		list.addLast("D");
		list.positionIterator();
		assertEquals("D", list.getIterator());	//test 2
		
		list.addIterator("E");
		assertEquals("D", list.getIterator());	//test 3
		
		list.advanceIterator();
		assertEquals("E", list.getIterator());	//test 4
		
		
	}

	@Test
	void testGetLength() {
		LinkedList<String> list = new LinkedList<String>();
		
		assertTrue(0 == list.getLength()); //test 1
		
		list.addFirst("A");
		assertEquals(1, list.getLength());	//test 2
		
		list.addLast("B");
		assertNotEquals(1, list.getLength());	//test 3
		
	}

	@Test
	void testIsEmpty() {
		LinkedList<String> list = new LinkedList<String>();
		
		assertTrue(list.isEmpty());	//test 1

		list.addFirst("A");
		assertTrue(!list.isEmpty());	//test 2
		
		assertNotEquals(true, list.isEmpty());	//test 3
		
	}

	@Test
	void testOffEnd() {
		
		LinkedList<String> list = new LinkedList<String>();
		assertTrue(list.offEnd());	//test 1
		
		list.addFirst("A");
		list.positionIterator();
		assertTrue(!list.offEnd());	//test 2
		
		list.advanceIterator();
		assertTrue(list.offEnd());	//test 3
		
	}

	@Test
	void testAddFirst() {
		LinkedList<String> list = new LinkedList<String>();
		
		assertTrue(list.isEmpty());	//test 1
		
		list.addFirst("C");
		assertEquals("C", list.getFirst());	//test 2
		
		list.addFirst("B");
		assertEquals("B", list.getFirst());	//test 3
		
		list.addFirst("A");
		assertEquals("A", list.getFirst());	//test 4
	}

	@Test
	void testAddLast() {
		
		LinkedList<String> list = new LinkedList<String>();
		
		assertTrue(list.isEmpty());	//test 1
		
		list.addLast("C");
		assertEquals("C", list.getLast());	//test 2
		
		list.addLast("B");
		assertEquals("B", list.getLast());	//test 3
		
		list.addLast("A");
		assertNotEquals("C", list.getLast());	//test 4
		
		
	}

	@Test
	void testAddIterator() {
		LinkedList<String> list = new LinkedList<String>();
		
		assertThrows(NullPointerException.class, ()->{list.addIterator("A");}); //test 1
		
		list.addLast("A");
		list.positionIterator();
		list.addIterator("B");
		
		assertEquals("A", list.getIterator());	//test 2
		assertEquals("B", list.getLast());	//test 3
		
		list.advanceIterator();
		list.addIterator("C");
		assertEquals("C", list.getLast());	//test 4
		assertEquals("B", list.getIterator());	//test 5
		
	}

	@Test
	void testRemoveFirst() {
		
		LinkedList<String> list = new LinkedList<String>();
		
		assertThrows(NoSuchElementException.class, ()->{list.removeFirst();}); //test 1
		
		list.addFirst("A");
		list.addLast("B");
		list.addLast("C");
		
		assertEquals("A", list.getFirst());	//test 2
		list.removeFirst();
		assertTrue("B" == list.getFirst());	//test 3
		list.removeFirst();
		assertFalse("B" == list.getFirst());	//test 4
		
	}

	@Test
	void testRemoveLast() {
		
		LinkedList<String> list = new LinkedList<String>();
		
		assertThrows(NoSuchElementException.class, ()->{list.removeLast();}); //test 1
		
		list.addFirst("A");
		list.addLast("B");
		list.addLast("C");
		
		assertEquals("C", list.getLast());	//test 2
		list.removeLast();
		assertTrue("B" == list.getLast());	//test 3
		list.removeLast();
		assertFalse("A" != list.getLast());	//test 4
	}

	@Test
	void testRemoveIterator() {
		
		LinkedList<String> list = new LinkedList<String>();
		
		assertThrows(NullPointerException.class, ()->{list.removeIterator();}); //test 1
		
		list.addFirst("C");
		list.addFirst("B");
		list.addFirst("A");
		
		list.positionIterator();
		
		assertEquals(false, list.offEnd());	//test 2
		
		list.removeIterator();
		assertTrue("B" == list.getFirst());	//test 3
		
	}

	@Test
	void testPositionIterator() {
		
		LinkedList<String> list = new LinkedList<String>();

		list.positionIterator();
		assertFalse(!list.offEnd());	//test 1
		
		list.addFirst("C");
		list.addFirst("B");
		list.addFirst("A");
		
		list.positionIterator();
		
		assertEquals(false, list.offEnd());	//test 2
		
		list.removeIterator();
		assertTrue("B" == list.getFirst());	//test 3
		
	}

	@Test
	void testAdvanceIterator() {
		
		LinkedList<String> list = new LinkedList<String>();
		
		assertThrows(NullPointerException.class, ()->{list.advanceIterator();}); //test 1
		
		list.addFirst("C");
		list.addFirst("B");
		list.addFirst("A");
		
		list.positionIterator();
		list.advanceIterator();
		list.advanceIterator();
		
		assertEquals(false, list.offEnd());	//test 2
		
		list.removeIterator();
		assertTrue("A" == list.getFirst());	//test 3
		assertEquals("B",list.getLast());	//test 4
		
	}

	@Test
	void testReverseIterator() {
		LinkedList<String> list = new LinkedList<String>();
		
		assertThrows(NullPointerException.class, ()->{list.reverseIterator();}); //test 1
		
		list.addFirst("C");
		list.addFirst("B");
		list.addFirst("A");
		
		list.positionIterator();
		list.removeIterator();
		assertTrue(list.offEnd());	//test 2
		
		list.positionIterator();
		list.advanceIterator();
		list.reverseIterator();
		assertEquals("B", list.getIterator());	//test 3
		
	}

	@Test
	void testToString() {
		
		LinkedList<String> list = new LinkedList<String>();
		
		assertEquals("\n", list.toString());	//test 1
		
		list.addFirst("A");
		
		assertEquals("A \n" , list.toString());	//test 2
		
		list.addLast("B");
		assertNotEquals("A \n" , list.toString());	//test 3
		
	}

	@Test
	void testEqualsObject() {
		LinkedList<String> list = new LinkedList<String>();
		list.addFirst("C");
		list.addFirst("B");
		list.addFirst("A");
		
		LinkedList<String> list2 = new LinkedList<String>();
		list2.addFirst("C");
		list2.addFirst("B");
		list2.addFirst("A");
		
		assertTrue(list.equals(list2));	//test1
		list2.addLast("D");
		assertFalse(list.equals(list2));	//test2
		list.addLast("D");
		assertEquals(true, list.equals(list2));	//test3
		
	}

	@Test
	void testRevolvingList() {
		
		LinkedList<String> list = new LinkedList<String>();
		
		assertThrows(IllegalArgumentException.class, ()->{list.revolvingList(0);}); //test 1
		
		list.addFirst("6");
		list.addFirst("5");
		list.addFirst("4");
		list.addFirst("3");
		list.addFirst("2");
		list.addFirst("1");
		
		list.revolvingList(5);
		assertEquals("6 2 3 4 5 1 \n", list.toString());	//test 2
		
		list.revolvingList(5);
		assertFalse("6 2 3 4 5 1 \n".equals(list.toString()));	//test 3
		
	}

	@Test
	void testInterlockLists() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addLast(1);
		list.addLast(3);
		list.addLast(5);
		list.addLast(7);
		list.addLast(9);
		
		LinkedList<Integer> list2= new LinkedList<Integer>();
		list2.addLast(2);
		list2.addLast(4);
		list2.addLast(6);
		list2.addLast(8);
		list2.addLast(10);
		
		LinkedList<Integer> newList = list.interlockLists(list2);
		
		assertEquals("1 2 3 4 5 6 7 8 9 10 \n", newList.toString());	//test 1
		
		assertFalse("1 2 3 4 5 6 7 8 9 10 \n".equals(list.interlockLists(newList).toString()));	//test 2
		
		assertTrue("1 1 3 2 5 3 7 4 9 5 6 7 8 9 10 \n".equals(list.interlockLists(newList).toString()));	//test 3
		
	}


}