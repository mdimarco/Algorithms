
public class Node<E> {

		private E data;
		Node<E> next;
		
		public Node(E data){
			this.setData(data);
			this.next = null;
		}
		
		
		public E getData() {
			return data;
		}
		
		
		public void setData(E data) {
			this.data = data;
		}
	
}
