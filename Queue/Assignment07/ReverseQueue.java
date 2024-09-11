public class ReverseQueue{
	public static void reverseFirstKElements(QueueADT queue, int k){
		StackADT stack = new StackADT(queue.size());
		for(int i = 0; i < k; i++){
			stack.push(queue.dequeue());
		}
		while(!stack.isEmpty()){
			queue.enqueue(stack.pop());
		}
	}
	public static void main(String[] args){
		QueueADT queue = new QueueADT();
		
		queue.enqueue(4);
		queue.enqueue(3);
		queue.enqueue(5);
		queue.enqueue(2);
		queue.enqueue(1);
		queue.enqueue(7);
		queue.enqueue(9);
		
		queue.display();
		
		reverseFirstKElements(queue,3);
		
		queue.display();
	}
}