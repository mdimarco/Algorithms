import java.util.Scanner;


public class palindromeMakeCounter {

	/**
	 * 
	 * Another hackerrank challenge
	 * 
	 * 
	 * @param word
	 */
	
	public static void findNumbToConvert( char[] word ){

		System.out.println( findNumbToConvertHelper( word, 0, word.length-1 ));
	}

	public static int findNumbToConvertHelper( char[] word, int start, int stop ){
		if(stop-start <= 0){
			return 0;
		}
		if(stop-start == 1){
			return Math.abs( (int)word[ start ] - (int)word[ stop ]  );
		}
		else{
			int outer = Math.abs( (int)word[ start ] - (int)word[ stop ] );
			return outer+findNumbToConvertHelper( word, start+1, stop-1 );
		}
	}

	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int numWords = Integer.parseInt( scan.nextLine() );

		for(int i =0; i< numWords; i++){
				findNumbToConvert( scan.nextLine().toCharArray() ) ;
		}
	}
	
}
