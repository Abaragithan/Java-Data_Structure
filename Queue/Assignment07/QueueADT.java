public class QueueADT{
	private int[] queueArray;
	private int front = 0;
	private int rear = -1;
	private int size;
	
	public QueueADT(){
		queueArray = new int[10];
	}
	public QueueADT(int size){
		queueArray = new int[size];
	}
	public int size(){
		return queueArray.length;
	}
	public boolean isEmpty(){
		return rear == -1;
	}
	public boolean isFull(){
		return rear == queueArray.length -1;
	}
	public void enqueue(int data){
		if(isFull()){
			System.out.println("Queue is overflow");
			return;
		}
		queueArray[++rear] = data;
	}
	/*public int dequeue(){
		if(isEmpty()){
			System.out.println("Queue is underflow");
			return 0;
		}
		int element = queueArray[front];
		for(int i = front+1; i<=rear; i++){
			queueArray[i-1] = queueArray[i];
		}
		rear--;
		return element;
	}*/
	public int dequeue(){
		if(front>rear){
			front = 0;
			rear = -1;
		}
		if(isEmpty()){
			System.out.println("Queue is underflow");
			return 0;
		}
		return queueArray[front++];
	}
	public int peek(){
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
		QueueADT queue = new QueueADT();
		
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(8);
		queue.enqueue(9);
		queue.enqueue(2);
		System.out.println("peek : "+queue.peek());
		queue.display();
		System.out.println("deQueue : "+queue.dequeue());
		System.out.println("deQueue : "+queue.dequeue());
		System.out.println("deQueue : "+queue.dequeue());
		System.out.println("deQueue : "+queue.dequeue());
		System.out.println("deQueue : "+queue.dequeue());
		System.out.println("deQueue : "+queue.dequeue());
	}
}