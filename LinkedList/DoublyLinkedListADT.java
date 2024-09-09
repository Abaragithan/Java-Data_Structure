public class DoublyLinkedListADT{
	private Node head;
	private int size;
	public DoublyLinkedListADT(){
		this.head = null;
		this.size = 0;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	public int getSize(){
		return size;
	}
	public void insertAtFirst(int data){
		Node node = new Node(data);
		if(isEmpty()){
			head = node;
			size++;
			return;
		}
		node.next = head;
		head.prev = node;
		head = node;
		size++;
	}
	public void insertAtLast(int data){
		Node node = new Node(data);
		if(isEmpty()){
			head = node;
			size++;
			return;
		}
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = node;
		node.prev = temp;
		size++;
	}
	public void insertAt(int index, int data){
		Node node = new Node(data);
		if(index > size + 1 || index < 1){
			System.out.println("Invalid index ");
			return;
		}
		if(index == 1){
			insertAtFirst(data);
			return;
		}
		if(index == size + 1){
			insertAtLast(data);
			return;
		}
		Node temp = head;
		for(int i = 1; i < index; i++){
			temp = temp.next;
		}
		node.next = temp.next;
		temp.next.prev = node;
		temp.next = node;
		node.prev = temp;
		size++;
		
	}
	public void deleteAtFirst(){
		if(isEmpty()){
			System.out.println("Linked list Empty");
			return;
		}
		if(head.next == null){
			head = null;
			size--;
			return;
		}
		head = head.next;
		head.prev = null;
		size--;
	}
	public void deleteAtLast(){
		if(isEmpty()){
			System.out.println("Linked list Empty");
			return;
		}
		if(head.next == null){
			head = null;
			size--;
			return;
		}
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.prev.next = null;
		size--;
	}
	public void deleteAt(int index){
		if(index > size || index < 1){
			System.out.println("Invalid index ");
			return;
		}
		if(index == 1){
			deleteAtFirst();
			return;
		}
		if(index == size){
			deleteAtLast();
			return;
		}
		Node temp = head;
		for(int i = 1; i < index; i++){
			temp = temp.next;
		}
		temp.next.prev = temp.prev;
		temp.prev.next = temp.next;
		size--;
		
	}
	public int search(int data){
		Node temp = head;
		for(int i = 1; i < size + 1; i++){
			if(temp.data == data){
				return i;
			}
			temp = temp.next;
		}
		return -1;
	}
	public void delete(int val){
		int index = search(val);
		if(index == -1)
			System.out.println("No such element found");
		else{
			deleteAt(index);
			System.out.println("Succcesfully Deleted.");
		}
	}
	public void reverse(){
		if(isEmpty()){
			System.out.println("Linked list Empty");
			return;
		}
		Node current = head;
		Node previous = null;
		Node temp = null;
		while(current != null){
			temp = current.next;
			current.next = previous;
			current.prev = temp;
			previous = current;
			current = temp;
		}
		head = previous;
		display();
	}
	
	public void display(){
		if(isEmpty()){
			System.out.println(" Linked list Empty");
			return;
		}
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
		System.out.println();
	}
	public class Node{
		private int data;
		private Node next;
		private Node prev;
		
		public Node(int data){
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	
	public static void main(String[] args){
		DoublyLinkedListADT list = new DoublyLinkedListADT();
		
		list.insertAtFirst(4);
		list.insertAtFirst(9);
		list.insertAtFirst(3);
		list.insertAtLast(8);
		list.insertAtLast(5);
		list.insertAt(2,2);
		list.insertAt(3,7);
		list.display();
		//list.deleteAtLast();
		//list.deleteAtFirst();
		//list.display();
		//list.deleteAtLast();
		//list.display();
		//list.deleteAt(2);
		//list.deleteAt(2);
		//list.display();
		//list.delete(4);
		//System.out.println("Search index : "+ list.search(2));
		list.reverse();
		//list.display();
	
	}
}