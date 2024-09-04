public class StackGenADT<T>{
	private Object[] stack;
	private int top = -1;
	private final int DEFAULT_SIZE = 10;
	
	public StackGenADT(){
		stack = new Object[DEFAULT_SIZE];
	}
	public StackGenADT(int capacity){
		stack = new Object[capacity];
	}
	
	public boolean isFull(){
		return top == stack.length-1;
	}
	public boolean isEmpty(){
		return top == -1;
	}
	public int getTop(){
		return top;
	}
	public void push(T element){
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
	public Object pop(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return 0;
		}
		return stack[top--];
	}
	public Object peek(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return 0;
		}
		return stack[top];
	}
	public static void main(String[] args){
		StackGenADT<Integer> stack = new StackGenADT<>(10);
		
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