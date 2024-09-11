public class QueueADTgenLL<T>{
	private Node<T> front;
	private Node<T> rear;
	
	public QueueADTgenLL(){
		this.front = null;
		this.rear = null;
	}
	public boolean isEmpty(){
		return (rear == null && front == null);
	}
	public void enQueue(T data){
		Node<T> node = new Node<>(data);
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
		Node<T> current = front;
		while(current != null){
			System.out.print(current.data + ", ");
			current = current.next;
		}
		System.out.println();
	}
	public T deQueue(){
		T value = null;
		if(rear.next != front){
			value = front.data;
			front = front.next;
		}else{
			front = null;
			rear = null;
		}
		if(isEmpty()){
			System.out.println("Queue is underflow");
			return null;
		}
		return value;
	}
	public T peek(){
		if(isEmpty()){
			System.out.println("Queue is underflow");
			return null;
		}
		return front.data;
	}
	private class Node<T>{
		private Node<T> next;
		private T data;
		public Node(T data){
			this.data = data;
			this.next = null;
		}
	}
	
	public static void main(String[] agrs){
		QueueADTgenLL<Integer> queue = new QueueADTgenLL<>();
		
		queue.enQueue(4);
		queue.enQueue(5);
		queue.enQueue(8);
		System.out.println("peek : "+queue.peek());
		queue.enQueue(9);
		queue.enQueue(2);
		queue.display();
		System.out.println("deQueue : "+queue.deQueue());
		System.out.println("deQueue : "+queue.deQueue());
		System.out.println("deQueue : "+queue.deQueue());
		System.out.println("deQueue : "+queue.deQueue());
		System.out.println("deQueue : "+queue.deQueue());
		System.out.println("deQueue : "+queue.deQueue());

	}
}