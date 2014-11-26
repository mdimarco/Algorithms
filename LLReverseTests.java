import static org.junit.Assert.*;

import org.junit.Test;

public class LLReverseTests {

	@Test
	public void test() {
		assertEquals(5,5);

	}
	
	@Test
	public void test2(){
		assertEquals(6,6);
	}
	
	@Test
	public void NodeTest(){
		Node test1 = new Node(5);
	}
	
	@Test
	public void LinkedListTest(){
		LinkedList test1 = new LinkedList(new Node(6));
		assert(test1.head instanceof Node);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void createAndReverse(){
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		
		a.next = b;
		b.next = c;
		
		LinkedList test1 = new LinkedList(a);
		test1.illustrate();		
		LinkedList test1Reversed = new LinkedList(test1.reverse());
		test1Reversed.illustrate();
		assertEquals(test1Reversed.toString(), GenericAlgorithms.reverseString("ABC"));
		
	}
	
	@Test
	public void recurseReverseTest(){
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		a.next = b;
		b.next = c;
		
		LinkedList test1 = new LinkedList(a);
		//LinkedList test1Reverse = new LinkedList( test1.reverseRecurse(test1.head));
		//assertEquals(test1Reverse.toString(), GenericAlgorithms.reverseString("ABC"));
	}
}


