public class CircularQueueADT{
	private int[] queueArray;
	private int front = 0;
	private int rear = -1;
	private int size;
	
	public CircularQueueADT(){
		queueArray = new int[10];
	}
	public CircularQueueADT(int size){
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
		rear = rear % queueArray.length;
		size++;
	}
	public int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is underflow");
        }
        int removed = queueArray[front++];
        front = front % queueArray.length;
        size--;
        return removed;
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