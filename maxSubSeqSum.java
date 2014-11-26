import java.util.Scanner;


public class maxSubSeqSum {

	
	public static int printMaxCONTINUOUSSeqSum(int[] keys, int[] vals){
		
		int max = -1;	
		int i = 0;
	
				
		while(i<keys.length){
			int running = vals[i];
			
			if( i+1<keys.length && keys[i] < keys[i+1]){
				while( i+1<keys.length && keys[i] < keys[i+1] ){
					i++;
					running+=vals[i];
				}
				i++;
			}
			else{
				i++;
			}
			
			
			if(running > max){ max = running; }
		}
		return max;
	}




	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);

		int numTestCases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i<numTestCases; i++){
			int sequenceLength = Integer.parseInt(scan.nextLine());

			String[] keysAsString = scan.nextLine().split(" ");
			String[] valsAsString = scan.nextLine().split(" ");

			int[] keys = new int[sequenceLength];
			int[] vals = new int[sequenceLength];

			for(int j = 0; j< sequenceLength; j++){
				keys[j] = Integer.parseInt( keysAsString[j] );
				vals[j] = Integer.parseInt( valsAsString[j] );
			}
			System.out.println(printMaxCONTINUOUSSeqSum( keys, vals ));
		}
	}
	
	
}
