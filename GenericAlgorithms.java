


public class GenericAlgorithms {

	StringBuilder s = new StringBuilder();
	
	
	public static String reverseString(String s){
		if(s.length() <2){
			return s;
		}
		else{
			String end = s.substring(s.length()-1);
			String middle = s.substring(1, s.length()-1);
			String beginning = s.substring(0,1);
			
			return end + reverseString( middle ) + beginning;
			}
	}
	
	public static void main(String[] args){
		StringBuilder test = new StringBuilder("ABCDE");
		System.out.println(reverseString(test.toString()));
	}
	
	
}
