public class Palindrome{
	public static void main(String[] args){
		
		String str = "amaNap l*an+aca,N alp#anamA";
		System.out.println(isPalindrome(str));
	}
	
	public static boolean isPalindrome(String str){
		StackADTgenLL<Character> stack = new StackADTgenLL<>();
		String letters = str.replaceAll("[^a-zA-Z0-9]","").toUpperCase();
		for(int i=0; i<letters.length(); i++){
			stack.push(letters.charAt(i));
		}
		for(int i=0; i<letters.length(); i++){
			if(stack.pop()!=letters.charAt(i))
				return false;
		}
		return true;
	}
}