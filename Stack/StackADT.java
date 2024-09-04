public class StackADT{
	private int[] stack;
	private int top = -1;
	private final int DEFAULT_SIZE = 10;
	
	public StackADT(){
		stack = new int[DEFAULT_SIZE];
	}
	public StackADT(int capacity){
		stack = new int[capacity];
	}
	
	public boolean isFull(){
		return top == stack.length-1;
	}
	public boolean isEmpty(){
		return top == -1;
	}
	public void push(int element){
		if(isFull()){
			System.out.println("Stack is full");
			return;
		}
		stack[++top] = element;
	}
	public void display(){
		System.out.print("[ ");
		for(int i = 0; i <= top; i++){
			System.out.print(stack[i]+", ");
		}
		System.out.println("]");
	}
	public int pop(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return 0;
		}
		return stack[top--];
	}
	public int peek(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return 0;
		}
		return stack[top];
	}
	public static void main(String[] args){
		StackADT stack = new StackADT(10);
		
		stack.push(3);
		stack.display();
		stack.push(5);
		stack.display();
		stack.push(8);
		stack.display();
		System.out.println("peek : "+stack.peek());
		stack.display();
		stack.pop();
		stack.display();
		stack.pop();
		stack.display();
		System.out.println("peek : "+stack.peek());
		stack.pop();
		stack.display();
		stack.pop();
		stack.display();
	}
}