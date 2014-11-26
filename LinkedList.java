
public class LinkedList<E> {
      Node<E> head;
	
	public LinkedList( Node<E> head ){
		this.head = head;
	}
	
	
	
	public Node reverse(){
		if(head == null || head.next == null){
			return head;
		}
		
		Node past = head;
		Node current = head.next;
		past.next = null;
		Node future;
		
		while(current != null){
			//Set up future
			future = current.next;
			
			//Reverse current & past
			current.next = past;
			
			//Bump up one list movement
			past = current;		
			current = future;
		}
		
		
		return past;
	}
	
	
	@SuppressWarnings("rawtypes")
	public Node reverseRecurse(Node head){
		if( head == null || head.next == null){
			return head;
		}
		System.out.println(head.getData());
		Node current = head;
		Node rest = current.next;
		
		
		Node newHead = reverseRecurse(rest);

		rest.next = current;
		current.next = null;

		
		return newHead;
	}
	
	public void illustrate(){
		Node current = head;
		while(current != null){
			System.out.print(current.getData());
			current = current.next;
		}
		System.out.println();
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder();
		Node current = head;
		while(current != null){
			s.append(current.getData());
			current = current.next;
		}
		return s.toString();
	}
	
	public static void main(String[] args){
		Node a,b,c;
		a = new Node("A");
		b = new Node("B");
		c = new Node("C");
		a.next = b;
		b.next = c;
		LinkedList aList = new LinkedList(a);
		
		Node newhead = aList.reverseRecurse(aList.head);
		(new LinkedList(newhead)).illustrate();
	}

}


