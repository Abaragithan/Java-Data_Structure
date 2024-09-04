public class StackADTgenLL<T>{
	private Node<T> top;
	private int size;
	public StackADTgenLL(){
		this.top = null;
		this.size = 0;
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public void push(T data){
		Node<T> node = new Node<>(data);
		if(isEmpty()){
			top = node;
			size++;
			return;
		}
		node.next = top;
		top = node;
		size++;
		
	}
	public T pop(){
		if(isEmpty()){
			System.out.println("Linked list Empty");
			return null;
		}
		T val = top.data;
		top = top.next;
		size--;
		return val;
	}
	public void display(){
		if(isEmpty()){
			System.out.println(" Linked list Empty");
			return;
		}
		Node<T> temp = top;
		System.out.println();
		while(temp != null){
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
		System.out.println();
	}
	public T peek(){
		Node<T> temp = top;
		while(temp.next != null){
			temp = temp.next;
		}
		return temp.data;
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
		StackADTgenLL<Integer> list = new StackADTgenLL<>();
		
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