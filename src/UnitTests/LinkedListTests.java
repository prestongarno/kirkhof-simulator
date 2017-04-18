package UnitTests;

import edu.gvsu.cis162.project4.LinkedList.CustomLinkedList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/** **************************************************
 * kirkhof-simulator - UnitTests - by Preston Garno on 3/27/17
 *
 * Just a few Unit tests to make sure the linkedList is working
 * ***************************************************/
public class LinkedListTests {
	
	private CustomLinkedList<String> list;
	
	@Before
	public void setUp() throws Exception {
		list = new CustomLinkedList<>();
	}
	
	@Test
	public void testAddRemoveSingleItem() {
		
		String item = "MY_ITEM";
		list.add(item);
		
		assertTrue(list.remove(item));
		assertEquals(0, list.size());
	}
	
	@Test
	public void testAddMultiple_SizeIsCorrect() throws Exception {
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		
		assertEquals(4, list.size());
	}
	
	@Test
	public void testAddRemove_SizeIsCorrect() throws Exception {
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		
		list.removeFirst();
		list.removeFirst();
		
		assertEquals(2, list.size());
	}
	
	
	@Test
	public void testAddRemove_SizeIsCorrect_2() throws Exception {
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		
		list.removeFirst();
		list.remove("2");
		
		assertEquals(2, list.size());
	}
	
	@Test
	public void testAddAllRemoveAll() throws Exception {
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		
		list.removeFirst();
		list.removeFirst();
		list.removeFirst();
		list.removeFirst();
		
		assertEquals(0, list.size());
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testIndexOutOfBounds() throws Exception {
		
		list.add("test_1");
		list.get(20);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testEmptyList() throws Exception {
				list.get(0);
	}
	
	@Test
	public void testGetMethodReturnCorrectly() throws Exception {
		list.add("a");
		list.add("r");
		list.add("h");
		list.add("y");
		list.add("g");
		
		list.remove("h");
		
		for (int i = 0; i < list.size(); i++) {
			assertFalse(list.get(i).equals("h"));
		}
	}
	
	@Test
	public void testInsertFirst() throws Exception {
		list.add("test");
		final String first = "shouldBeFirst";
		list.addFirst(first);
		assertEquals(first, list.get(0));
	}
	
	@Test
	public void testAddLastOnEmptyList() throws Exception {
		list.addLast("test");
		assertEquals("test", list.get(0));
		assertEquals(1, list.size());
	}
	
	@Test
	public void testGetWithOneItem() throws Exception {
		list.add("null");
		assertEquals("null", list.get(0));
	}
}
