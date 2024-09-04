public class BalancedParentheses{
	public static void main(String[] args){
		
	String exp = "{12we(ds[23+()67](2*3[3d]sa@){})sa}";
		System.out.println(isBalanced(exp));
	}
	public static boolean isBalanced(String exp){
		int length = exp.length();
		StackADTlinkedList stack = new StackADTlinkedList();
		for(int i=0; i < length; i++){
			char c = exp.charAt(i);
			if(c == '(' || c== '[' || c== '{')
				stack.push(c);
		}
		for(int i=0; i < length; i++){
			char c = exp.charAt(i);
			if(stack.isEmpty())
				return false;
			if(c == ')' || c== ']' || c== '}')
				stack.pop();
		}
		return stack.isEmpty();
	}
}