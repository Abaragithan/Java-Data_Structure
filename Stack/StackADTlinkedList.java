public class StackADTlinkedList{
	private Node top;
	private int size;
	public StackADTlinkedList(){
		this.top = null;
		this.size = 0;
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public void push(int data){
		Node node = new Node(data);
		if(isEmpty()){
			top = node;
			size++;
			return;
		}
		node.next = top;
		top = node;
		size++;
		
	}
	public int pop(){
		if(isEmpty()){
			System.out.println("Linked list Empty");
			return 0;
		}
		int val = top.data;
		top = top.next;
		size--;
		return val;
	}
	public void display(){
		if(isEmpty()){
			System.out.println(" Linked list Empty");
			return;
		}
		Node temp = top;
		System.out.println();
		while(temp != null){
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
		System.out.println();
	}
	public int peek(){
		Node temp = top;
		while(temp.next != null){
			temp = temp.next;
		}
		return temp.data;
	}
	
	public class Node{
		private int data;
		private Node next;
		
		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	public static void main(String[] args){
		StackADTlinkedList list = new StackADTlinkedList();
		
		list.push(23);
		list.push(25);
		list.push(22);
		list.push(21);
		list.push(23);
		list.push(53);
		list.display();
		System.out.print("pop : "+list.pop());
		list.display();
		list.pop();
		list.display();
		list.pop();
		list.display();
		list.pop();
		list.display();
		//System.out.print("peek : "+list.peek());
		list.pop();
		list.display();
		list.pop();
		list.display();
		

	}
}