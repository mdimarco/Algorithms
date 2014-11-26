
public class insertionSort {

	
	public static void insertionSort(int[] array){
		
		for(int i = 1; i<array.length; i++){
			insertElement(array, i-1, array[i]);
		}

	}

	public static void insertElement(int[] array,int end, int element){
		
		while(end >= 0 && element < array[end] ){
				array[end+1] = array[end];
				array[end] = element;
				end--;
		}
	}
	
}
