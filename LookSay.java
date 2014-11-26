import java.util.ArrayList;
import java.util.Scanner;


public class LookSay {

	/**
	 * LookSay
	 *  
	 * It's base case is input n==0, which simply returns "1"
	 * 
	 * for any after, it will "say" the value returned by lookSay(n-1)
	 * 
	 * lookSay(1) -> "11"
	 * This corresponds to looking at lookSay(0), which is 1, and saying
	 * "there is one 1"
	 * 
	 * lookSay(2) -> "21"
	 * essentially a way of saying "there are two 1's"
	 * 
	 * lookSay(3) -> "1211"
	 * a way of saying "there is one 2 and 1 one"
	 * 
	 * This expects an input via the console on running, and will print
	 * the output to console (as is standard for hackerrank)
	 * 
	 * @param n
	 * @return
	 */
	
	
	public static String lookSay(int n){
		if(n < 0){   return null; }
		if( n == 0){ return "1";  }
		
		
		else{
			//Get previous lookSay value
			String lastAnswer = lookSay(n-1);
			
			//Hold Final list of ints
			ArrayList<Integer> endInts = new ArrayList<Integer>();
			
			//Get the previous value for comparison
			int previous = Integer.parseInt( lastAnswer.substring(0,1) );
			int counter = 1;
			
			for(int i = 1; i<lastAnswer.length(); i++){

				int current = Integer.parseInt(lastAnswer.substring(i,i+1));
				if(previous == current ){
					counter++;
				}
				else{
					endInts.add(counter);
					endInts.add(previous);
					previous = current;
					counter = 1;
				}
			}
			
			//Wrap up
			endInts.add(counter);
			endInts.add(previous);
			
			
			//Format as string
			StringBuilder endString = new StringBuilder();
			for(Integer elem : endInts){
				endString.append( elem );
			}
			return endString.toString();	
		}
		
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		System.out.println(lookSay(n));
		System.out.println();
		
	}
	
}
