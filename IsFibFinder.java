import java.math.*;
import java.util.HashMap;
import java.util.Scanner;
public class IsFibFinder {

	
	/**
	 * 
	 * Below is my solutions to the hacker-rank challenge:
	 * fibfinder. When run, the console expects the input in 
	 * the form of a number, n, and n numbers after, each of them
	 * separated by new lines. 
	 * 
	 * My program will then print whether each number entered is
	 * or is not a fibonacci number (Hacker Rank generally organizes 
	 * it's problems to have the solutions printed to the console)
	 * 
	 * 
	 * Implementation: Basic fibonacci formula with memoization added in,
	 * speeding up the algorithm to O(n) time and adding in O(n) memory
	 * due to the addition of a HashMap.
	 * 
	 * Example Input (into console):
	 * 3 (this is the number of numbs to expect)
	 * 0
	 * 10
	 * 13
	 * 
	 * Output (from console):
	 * IsFibo
	 * IsNotFibo
	 * IsFibo
	 * 
	 * 
	 * (Note: The function does not check whether or not 3 is
	 * a fibonnacci number because 3 is simply a marker for how
	 * many future inputs to expect)
	 * 
	 * 
	 */
	
	
	
	
	public static HashMap<Integer, Long> fibCache = new HashMap<Integer, Long>();
	public static long fib( int n ){
		
		if( fibCache.get(n) != null){
			return fibCache.get(n);
		}
		
		if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		
		long answer = fib(n-1)+fib(n-2);
		fibCache.put(n, answer);
		return answer;
		
	}
	
	public static boolean isFib(long testMe){
		
		int counter = 0;
		while( fib(counter) < testMe) {
			counter++;
		}
		if(fib(counter) == testMe){
			return true;
		}
		return false;
		
	}
	
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		
		//Number of inputs to expect to take in
		long numb = Long.parseLong( scan.nextLine() );
		
		for(int i = 0; i<numb; i++){
			//Fib to test
			long testMe = Long.parseLong(scan.nextLine());
			
			if( isFib( testMe) ){
				System.out.println("IsFibo");
			}
			else{
				System.out.println("IsNotFibo");
			}
			
		}
		
	}
	
	
	
}
