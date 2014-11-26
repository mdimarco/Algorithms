import java.util.HashMap;
import java.util.HashSet;

public class MinWindowProblem{
	



	
	public static String min_window( String S, String T ){

		if( S.length() == 0 || T.length() == 0 || S.length() < T.length()){
			return "";
		}
		
		
		HashMap<Character, Integer> freq_table = new HashMap<Character, Integer>();
		HashSet<Character> in_T = new HashSet<Character>();

		for( char c: T.toCharArray() ){

			if( !in_T.contains(c)) {
				freq_table.put( c, 1 ); 
			}
			else{
				freq_table.put( c, freq_table.get(c) +1);
			}
			in_T.add(c);
		}

		int start = 0;
		int end = 0;
		int min_start = 0;
		int min_end = 0;
		int min_dist, k, counter;

		char[] S_Char = S.toCharArray();
		while( end < S.length() ){
			if( in_T.contains( S_Char[end] ) ){
				freq_table.put( S_Char[end] , freq_table.get( S_Char[end] )-1 );
			}

			//Check if we can trim the left
			if( freq_table.get( S_Char[start] ) < 0 || !in_T.contains( S_Char[start]) ){
				k = start;
				while(k < end){
					if( !in_T.contains(S_Char[k]) ){
						k++;
					}
					else if( freq_table.get( S_Char[k]) < 0 ){
						freq_table.put( S_Char[k], freq_table.get(S_Char[k])+1);
						k++;
					}
					else{
						break; //This character is necessary for our substring, have to end here
					}
				}
				start = k;
			}

			counter = 0;
			for( Character c : T.toCharArray()){ //Can be optimized by char[256], worth it if T.length()>>256
				if( freq_table.get(c) <= 0){
					counter++;
				}
				else{
					break;
				}
			}
			//got through all of T, this is a valid substring
			if( counter == T.length() ){
				min_dist = min_end - min_start;
				if(min_dist == 0 || (end-start) < min_dist){
					min_end = end;
					min_start = start;
				}
			}
			end++;
		}
		return S.substring(min_start, min_end+1);

	}
	
	public static void main(String[] args){
		String big = "ADOBEECEEEBANCC";
		String small = "ABCC";
		
		System.out.println( min_window(big,small) );
		
	}

	


}