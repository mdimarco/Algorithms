import java.io.*;
import java.util.*;

public class gemFinder {

	
	
	
	
	
	public static void solveGemFinder(Scanner in){

		int commonCounter = Integer.parseInt( in.nextLine() );
		
		//Each row represents a gem, all elements found are marker true
		boolean[][] elementsFound = new boolean[commonCounter][26];
		
		for(int i = 0; i<commonCounter; i++){
				String gem = in.nextLine();
	
				for( int j = 0; j<gem.length(); j++){
					char element = gem.charAt(j);
					int elementAsIndex = (int)element - 97;
					elementsFound[i][elementAsIndex] = true;
				}
		}


		int commonGemCounter = 0;
		for(int i = 0; i<26; i++){
			boolean elementIsCommon = true;
			
			for(int j = 0; j<commonCounter; j++){
				
				if( !elementsFound[j][i] ){
					elementIsCommon = false;
				}
			}
			
			if(elementIsCommon){
				commonGemCounter++;
			}
		}

		
		System.out.println( commonGemCounter );
	}
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		solveGemFinder(in);
	}
}
