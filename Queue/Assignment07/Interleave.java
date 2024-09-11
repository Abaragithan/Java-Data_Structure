public class Interleave{
	public static void main(String[] args){
		QueueADTLL queue = QueueADTLL();
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(3);
		queue.enqueue(5);
		queue.enqueue(6);
		
		queue.display();
		
		interleave(queue);
		
		queue.display();
	}
}