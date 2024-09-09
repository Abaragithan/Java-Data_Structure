public class LinkedListGenADT<T>{
	private Node<T> head;
	private int size;
	public LinkedListGenADT(){
		this.head = null;
		this.size = 0;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public void insertAtFirst(T data){
		Node<T> node = new Node<>(data);
		if(isEmpty()){
			head = node;
			size++;
			return;
		}
		node.next = head;
		head = node;
		size++;
	}
	public void insertAtLast(T data){
		Node<T> node = new Node<>(data);
		if(isEmpty()){
			head = node;
			size++;
			return;
		}
		Node<T> temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = node;
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
		Node<T> temp = head;
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
		head = head.next;
		size--;
	}
	public void deleteAtLast(){
		if(isEmpty()){
			System.out.println("Linked list Empty");
			return;
		}
		Node<T> temp = head;
		for(int i = 1; i < size; i++){
			temp = temp.next;
		}
		temp.next = null;
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
		Node<T> temp = head;
		for(int i = 0; i < index - 1; i++){
			temp = temp.next;
		}
		temp.next = temp.next.next;
	}
	public int search(T data){
		Node<T> temp = head;
		for(int i = 0; i < size; i++){
			if(temp.data == data){
				return i;
			}
			temp = temp.next;
		}
		return -1;
	}
	public void delete(T val){
		int index = search(val);
		if(index == -1)
			System.out.println("No such element found");
		else{
			deleteAt(index);
			System.out.println("Succcesfully Deleted.");
		}
	}

	public void display(){
		if(isEmpty()){
			System.out.println(" Linked list Empty");
			return;
		}
		Node<T> temp = head;
		while(temp != null){
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
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
		LinkedListGenADT<Integer> list = new LinkedListGenADT<>();
		
		list.insertAtFirst(23);
		/*list.insertAtFirst(2);
		list.insertAtFirst(212);
		list.insertAtFirst(21);
		list.insertAtFirst(23);
		list.insertAtFirst(53);
		list.insertAtLast(7);
		list.insertAt(2,8);
		
		list.display();
		list.deleteAtFirst();
		list.deleteAtLast();
		list.deleteAt(4);
		list.display();
		System.out.println(" index is : "+ list.search(21));
		list.delete(21);
		list.display();
		list.delete(5);*/
		list.display();
		list.delete(23);
		list.display();
	}
}