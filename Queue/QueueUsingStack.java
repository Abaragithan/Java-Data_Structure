public class QueueUsingStack{
	private StackADT queue;
	private StackADT temp;
	
	public QueueUsingStack(int capacity){
		queue = new StackADT(capacity);
		temp = new StackADT(capacity);
	}
	public boolean isEmpty(){
		return (temp.isEmpty() && queue.isEmpty());
	}
	public boolean isFull(){
		return (queue.isFull() || temp.isFull());
	}
	public void enqueue(int data){
		if(isFull()){
			System.out.println("Queue is overflow");
			return;
		}
		queue.push(data);
	}
	
	public int dequeue(){
		if(isEmpty()){
			System.out.println("Queue is underflow");
			return 0;
		}
		while(!queue.isEmpty()){
			temp.push(queue.pop());
		}
		int val = temp.pop();
		while(!temp.isEmpty()){
			queue.push(temp.pop());
		}
		return val;
	}
	public int peek(){
		if(isEmpty()){
			System.out.println("Queue is underflow");
			return 0;
		}
		while(!queue.isEmpty()){
			temp.push(queue.pop());
		}
		int val = temp.peek();
		while(!temp.isEmpty()){
			queue.push(temp.pop());
		}
		return val;
	}
	
	public void display(){
		while(!queue.isEmpty()){
			temp.push(queue.pop());
		}
		while(!temp.isEmpty()){
			System.out.print(temp.peek()+", ");
			queue.push(temp.pop());
		}
		System.out.println();
	}
	private class StackADT{
		private int[] stack;
		private int rear = -1;
		
		public StackADT(int capacity){
			stack = new int[capacity];
		}
		public boolean isEmpty(){
			return rear == -1;
		}
		public boolean isFull(){
			return rear == stack.length - 1;
		}
		
		public boolean push(int data){
			if(isFull()){
				return false;
			}
			stack[++rear] = data;
			return true;
		}
		public int pop(){
			if(isEmpty()){
				return 0;
			}
			return stack[rear--];
		}
		public int peek(){
			if(isEmpty()){
				return 0;
			}
			return stack[rear];
		}
	}
	
	public static void main(String[] args){
		
		QueueUsingStack queue = new QueueUsingStack(10);
		
		queue.enqueue(3);
		queue.enqueue(5);
		queue.enqueue(8);
		queue.enqueue(2);
		queue.enqueue(4);
		queue.enqueue(1);
		queue.enqueue(3);
		queue.enqueue(7);
		queue.enqueue(9);
		queue.enqueue(6);
		queue.enqueue(10);
		queue.display();
		System.out.println("dequeue : "+queue.dequeue());
		System.out.println("peek : "+queue.peek());
		System.out.println("dequeue : "+queue.dequeue());
		System.out.println("dequeue : "+queue.dequeue());
		System.out.println("peek : "+queue.peek());
		System.out.println("dequeue : "+queue.dequeue());
		System.out.println("dequeue : "+queue.dequeue());
		System.out.println("dequeue : "+queue.dequeue());
		System.out.println("dequeue : "+queue.dequeue());
		System.out.println("dequeue : "+queue.dequeue());
		System.out.println("dequeue : "+queue.dequeue());
		System.out.println("dequeue : "+queue.dequeue());
		
	}
	
}