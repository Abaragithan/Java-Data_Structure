public class DecimalToBinary{
	public static void main(String[] args){
		
		int decimal = 18;
		System.out.println(decimalToBinary(decimal));
	}
	
	// this is only for positive decimal numbers
	public static String decimalToBinary(int decimal){
		if(decimal<0)
			return "Only positive decimal numbers can be converted";
		if(decimal == 0)
			return "0";
		StackADT stack = new StackADT(32);
		int num = decimal, re = 0;
		String binary = "";
		while(num!=0){
			re = num%2;
			if(re==0)
				stack.push(48);
			else if(re==1)
				stack.push(49);
			num = num/2;
		}
		while(!stack.isEmpty()){
			binary += (char)stack.pop();
		}
		return binary;
	}
}