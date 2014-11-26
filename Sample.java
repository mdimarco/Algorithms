import java.io.*;
import java.util.HashMap;


public class Sample {

	/**
	 * 
	 * Takes in two parameters,
	 * returns whether or not they are an anagram
	 * runs in O(n) time due to use of a HashMap
	 * 
	 *  IO will run in standard hackerrank fashion
	 *  Inputs -> standard console (separated by new line)
	 *  Outputs -> standard console
	 * 
	 * @param s
	 * @param s2
	 * @return
	 */
	
	public static String anagramFinder(String s, String s2){
		HashMap<Character,Integer> string1Counter = new HashMap<Character,Integer>();
		
		
		char[] sAsArray = s.toCharArray();
		char[] s2AsArray = s2.toCharArray();
		
		for(char letter : sAsArray){
			
			if(string1Counter.get(letter) == null){
				string1Counter.put(letter,1);
			}
			else{
			string1Counter.put(letter, string1Counter.get(letter)+1);
			}
		
		}
			
		for(char letter : s2AsArray){

			if(string1Counter.get(letter) == null || string1Counter.get(letter) == 0){
				return "Not anagrams!" ;
			}
			else{
				string1Counter.put(letter, string1Counter.get(letter)-1);
			}			
		}
		
		//Mop up
		for(Character key : string1Counter.keySet() ){
			if(string1Counter.get(key) != 0){
				return "Not anagrams!";
			}
		}
			
		return "Anagrams!";
	}
	
	
	public static void main(String args[]) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String line2 = br.readLine();
		
		
		System.out.println(anagramFinder(line, line2));
		
	}
	
	
}
