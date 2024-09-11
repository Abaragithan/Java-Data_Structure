public class PriorityQueue{
	private int[] queueArray;
	private int front = 0;
	private int rear = -1;
	private final int default_size = 10;
	
	public PriorityQueue(){
		queueArray = new int[default_size];
	}
	
	public PriorityQueue(int capacity){
		queueArray = new int[capacity];
	}
	
	public boolean isFull(){
		return rear == queueArray.length-1;
	}
	public boolean isEmpty(){
		return rear == -1;
	}
	
	public void enqueue(int data){
		if(isFull()){
			System.out.println("Queue is overflow");
			return;
		}
		if (isEmpty()) {
        queueArray[++rear] = data;
        return;
		}
		int i;
		for (i = rear; i >= front; i--) {
			if (data >= queueArray[i]) {
				break;
			}
			queueArray[i + 1] = queueArray[i];
		}
		queueArray[i + 1] = data;
		rear++;
	
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
		PriorityQueue queue = new PriorityQueue();
		
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(8);
		queue.enqueue(9);
		queue.enqueue(2);
		queue.enqueue(6);
		//queue.enqueue(3);
		//System.out.println("peek : "+queue.peek());
		queue.display();
		//System.out.println("deQueue : "+queue.deQueue());
		//System.out.println("deQueue : "+queue.deQueue());
		//System.out.println("deQueue : "+queue.deQueue());
		//System.out.println("deQueue : "+queue.deQueue());
		//System.out.println("deQueue : "+queue.deQueue());
		//System.out.println("deQueue : "+queue.deQueue());
	}
}