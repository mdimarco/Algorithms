import java.util.ArrayList;
import java.util.HashMap;


public class FindAllAnagrams {

	
	public static void fizz_buzz()
	{
		for(int i =0; i<100;i++){
			if( i%3 == 0 && i%5==0){
				System.out.println("fizz buzz");
			}
			else if( i%3 == 0){
				System.out.println("fizz");
			}
			else if( i%5 == 0){
				System.out.println("buzz");
			}
		}
	}
	
	
	public static ArrayList<ArrayList<String>> find_all_anagrams( ArrayList<String> words ){
		          ArrayList<ArrayList<String>> anagrams_list = new ArrayList<ArrayList<String>>();
		
		
		//iterate through all words in given list
		int i =0;
		while( words.size() > 0){

			//get word to compare
			String to_compare = words.get(i);
	
			ArrayList<String> anns = new ArrayList<String>();
			anns.add(to_compare);
			
			HashMap<Character, Integer> letters = form_freq_table( to_compare );
			//Check all words in list vs frequency table
			
			for(int j =0; j<words.size(); j++){
				if( i!=j && same_char_freq(letters, words.get(j))){
					System.out.println(to_compare+ " "+words.get(j));
					anns.add( words.get(j) );
				}
			}
			
			
			anagrams_list.add(anns);
			for(int k = 0; k<anns.size(); k++){
				words.remove(k);
			}
			
		}
		return anagrams_list;
	}
	
	
	public static HashMap<Character, Integer> form_freq_table(String s){
		HashMap<Character,Integer> letters = new HashMap<Character,Integer>();

		//Form frequency table
		for(int k =0; k<s.length();k++){
			char letter = s.charAt(k);
			if(letters.containsKey( letter ) )
			{
				letters.put(letter, letters.get(letter)+1);
			}
			else{
				letters.put(letter, 1);
			}	
		}
		return letters;
	}
	
	
	public static boolean same_char_freq(HashMap<Character,Integer> letters, String word){
		
		for(int i = 0; i<word.length(); i++){
			char letter = word.charAt(i);
			if( !letters.containsKey(letter)){
				return false;
			}
			else{
				letters.put(letter, letters.get(letter)-1);
			}
		}
		
		for(Character let: letters.keySet())
		{
			if(letters.get(let) != 0){
				return false;
			}
		}
		
		
		return true;
	}
	
	
	public static void main(String[] args){
		//fizz_buzz();
		ArrayList<String> words = new ArrayList<String>();
		words.add("earr");
		words.add("erra");
		words.add("rae");
		words.add("lol");
		words.add("abcdef");
		words.add("oll");
		System.out.println(find_all_anagrams(words));
	}
}
