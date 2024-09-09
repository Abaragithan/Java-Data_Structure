public class CircularLinkedListGenADT<T>{
	private Node<T> tail;
	private int size;
	
	public CircularLinkedListGenADT(){
		tail = null;
		size = 0;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public int getSize(){
		return size;
	}
	public void insertAtFirst(T data){
		Node<T> node = new Node<>(data);
		if(isEmpty()){
			tail = node;
			node.next = tail;
			size++;
			return;
		}
		node.next = tail.next;
		tail.next = node;
		node = tail;
		size++;
	}
	public void insertAtLast(T data){
		Node<T> node = new Node<>(data);
		if(isEmpty()){
			tail = node;
			node.next = tail;
			size++;
			return;
		}
		Node<T> temp = tail.next;
		tail.next = node;
		node.next = temp;
		tail = tail.next;
		size++;
		
	}
	public void insertAt(int index, T data){
		Node<T> node = new Node<>(data);
		if(index > size || index < 0){
			System.out.println("Invalid index ");
			return;
		}
		if(index == 0){
			insertAtFirst(data);
			return;
		}
		if(index == size){
			insertAtLast(data);
			return;
		}
		Node<T> temp = tail.next;
		for(int i = 1; i < index; i++){
			temp = temp.next;
		}
		node.next = temp.next;
		temp.next = node;
		size++;
	}
	public void deleteAtFirst(){
		if(isEmpty()){
			System.out.println("Linked list Empty");
			return;
		}
		Node<T> temp = tail.next.next;
		tail.next = temp;
		size--;
	}
	public void deleteAtLast(){
		if(isEmpty()){
			System.out.println("Linked list Empty");
			return;
		}
		Node<T> temp = tail;
		while(temp.next != tail){
			temp = temp.next;
		}
		temp.next = tail.next;
		tail = temp;
		size--;
	}
	public void deleteAt(int index){
		if(index > size || index < 0){
			System.out.println("Invalid index ");
			return;
		}
		if(index == 0){
			deleteAtFirst();
			return;
		}
		if(index == size){
			deleteAtLast();
			return;
		}
		Node<T> temp = tail;
		for(int i = 0; i < index; i++){
			temp = temp.next;
		}
		temp.next = temp.next.next;
		size--;	
	}
	public int search(T data){
		Node<T> temp = tail.next;
		for(int i = 0; i < size; i++){
			if(temp.data == data){
				return i;
			}
			temp = temp.next;
		}
		return -1;
	}
	public void display(){
		if(isEmpty()){
			System.out.println(" Linked list Empty");
			return;
		}
		Node<T> temp = tail.next;
		
		do{
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}while(temp != tail.next);
		System.out.println();
	}
	public class Node<T>{
		private T data;
		private Node<T> next;
		
		public Node(T data){
			this.data = data;
			this.next = null;
		}
	}
	
	public static void main(String[] args){
		CircularLinkedListGenADT<Integer> list = new CircularLinkedListGenADT<>();
		
		list.insertAtFirst(4);
		list.insertAtFirst(3);
		list.insertAtFirst(9);
		list.insertAtLast(2);
		list.insertAtLast(6);
		list.insertAtLast(8);
		list.insertAt(2,7);
		list.insertAt(3,7);
		list.insertAtFirst(4);
		list.display();
		list.deleteAtFirst();
		list.deleteAtLast();
		list.display();
		list.deleteAt(4);
		list.display();
		System.out.println("Search result : "+list.search(2));

	}
}	