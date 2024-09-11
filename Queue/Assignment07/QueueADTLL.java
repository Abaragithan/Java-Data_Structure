public class QueueADTLL{
	private Node front;
	private Node rear;
	
	public QueueADTLL(){
		this.front = null;
		this.rear = null;
	}
	public boolean isEmpty(){
		return (rear == null && front == null);
	}
	public void enqueue(int data){
		Node node = new Node(data);
		if(isEmpty()){
			front = rear = node;
			return;
		}
		rear.next = node;
		rear = node;
	}
	public void display(){
		if(isEmpty()){
			System.out.println("Queue is underflow");
			return;
		}
		Node current = front;
		while(current != null){
			System.out.print(current.data + ", ");
			current = current.next;
		}
		System.out.println();
	}
	public int dequeue(){
		int value = 0;
		if(rear.next != front){
			value = front.data;
			front = front.next;
		}else{
			front = null;
			rear = null;
		}
		if(isEmpty()){
			System.out.println("Queue is underflow");
			return 0;
		}
		return value;
	}
	public int peek(){
		if(isEmpty()){
			System.out.println("Queue is underflow");
			return 0;
		}
		return front.data;
	}
	private class Node{
		private Node next;
		private int data;
		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	public static void main(String[] agrs){
		QueueADTLL queue = new QueueADTLL();
		
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(8);
		System.out.println("peek : "+queue.peek());
		queue.enqueue(9);
		queue.enqueue(2);
		queue.display();
		System.out.println("deQueue : "+queue.dequeue());
		System.out.println("deQueue : "+queue.dequeue());
		System.out.println("deQueue : "+queue.dequeue());
		System.out.println("deQueue : "+queue.dequeue());
		System.out.println("deQueue : "+queue.dequeue());
		System.out.println("deQueue : "+queue.dequeue());

	}
}