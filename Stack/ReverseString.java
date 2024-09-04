public class ReverseString{
	public static void main(String[] args){

		String str = "i am abaragithan";
		System.out.println(reverseStr(str));
	}
	
	public static String reverseStr(String str){
		int length = str.length();
		StackADT stack = new StackADT(length);
		String reversed = "";
		for(int i=0; i < str.length(); i++){
			stack.push(str.charAt(i));
		}
		while(!stack.isEmpty()){
			reversed += (char)stack.pop();
		}
		return reversed;
	}
}