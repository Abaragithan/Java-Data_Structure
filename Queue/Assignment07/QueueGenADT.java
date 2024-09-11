public class QueueGenADT<T>{
	private Object[] queueArray;
	private int front = 0;
	private int rear = -1;
	private final int defalt_size = 10;
	
	public QueueGenADT(){
		queueArray = new Object[defalt_size];
	}
	public QueueGenADT(int capacity){
		queueArray = new Object[capacity];
	}
	public boolean isEmpty(){
		return rear == -1;
	}
	public boolean isFull(){
		return rear == queueArray.length -1;
	}
	public void enQueue(T data){
		if(isFull()){
			System.out.println("Queue is overflow");
			return;
		}
		queueArray[++rear] = data;
	}
	/*public Object deQueue(){
		if(isEmpty()){
			System.out.println("Queue is underflow");
			return 0;
		}
		T element = queueArray[front];
		for(int i = front+1; i<=rear; i++){
			queueArray[i-1] = queueArray[i];
		}
		rear--;
		return element;
	}*/
	public Object deQueue(){
		if(front>rear){
			front = 0;
			rear = -1;
		}
		if(isEmpty()){
			System.out.println("Queue is underflow");
			return null;
		}
		return queueArray[front++];
	}
	public Object peek(){
		return queueArray[front];
	}
	public void display(){
		if(isEmpty()){
			System.out.println("Queue is underflow");
			return;
		}
		for(int i = front; i <= rear; i++){
			System.out.print(queueArray[i]+", ");
		}
		System.out.println();
	}
	public static void main(String[] agr){
		QueueGenADT<Integer> queue = new QueueGenADT<>();
		
		queue.enQueue(4);
		queue.enQueue(5);
		queue.enQueue(8);
		queue.enQueue(9);
		queue.enQueue(2);
		System.out.println("peek : "+queue.peek());
		queue.display();
		System.out.println("deQueue : "+queue.deQueue());
		System.out.println("deQueue : "+queue.deQueue());
		System.out.println("deQueue : "+queue.deQueue());
		System.out.println("deQueue : "+queue.deQueue());
		System.out.println("deQueue : "+queue.deQueue());
		System.out.println("deQueue : "+queue.deQueue());
	}
}