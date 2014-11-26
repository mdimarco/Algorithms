import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Solution {

	
	/**
	 *Data transformation from 2 strings to matrix
	 *
	 * @param dimensions
	 * @return
	 */
	public static int[][] genMatrix(String[] dimensions){
		int rows = Integer.parseInt(dimensions[0]);
		int cols = Integer.parseInt(dimensions[1]);
		
		return new int[rows][cols];
	}
	
	/**
	 * Uses helper function findAnswerForEmployee to find the answer
	 * then subsequently prints them out
	 * 
	 * @param matrix
	 * @param employees
	 */
	public static void findAnswer(int[][] matrix, int[][]employees){
		
		for(int[] employee:employees){
			int answer = findAnswerForEmployee(matrix, employee);
			System.out.println(answer);
		}
	}
	
	/**
	 * 
	 * @param matrix
	 * @param employee
	 * @return
	 */
	public static int findAnswerForEmployee(int[][] matrix, int[] employee){
			int[] goalLocation = new int[2];
			goalLocation[0] = matrix.length-1;
			goalLocation[1] = matrix[0].length-1;
			int empX = employee[0];
			int empY = employee[1];
			//if( atGoal(goalLocation, employee) ){
				//return matrix[employee[0]][employee[1]];
			//}
		
			PriorityQueue< State > open = new PriorityQueue<State>();
			open.add( new State(empX, empY, matrix[empX][empY]) );
			
			ArrayList<State> closed = new ArrayList<State>();
			
			
			
			while( !open.isEmpty() ){
				
					State current = open.poll();
										
					
					if( atGoal(goalLocation, current) ){
						return current.weight;
					}
					
					
					if( !closed.contains(current)  ){
						
						closed.add( current );

						
						if(goalLocation[0] > current.i){
							int newWeight = matrix[current.i+1][current.j]  + current.weight;
							open.add( new State(current.i+1, current.j, newWeight) );
						}
						
						if(goalLocation[1] > current.j){
							int newWeight = matrix[current.i][current.j+1] + current.weight;
							open.add( new State(current.i, current.j+1, newWeight));
						}
						
					}
				
			}
			
			return -1;
		
			
	}
	
	
	public static boolean atGoal(int[] goalLocation, State current ){
			if( goalLocation[0] == current.i && goalLocation[1] == current.j){
				return true;
			}
			return false;
	}
	

	
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] dimensions = br.readLine().split(" ");
		
		int[][] matrixValues = genMatrix(dimensions);		
		
		
		//Populating Matrix
		//Iterate through num rows
		for(int i = 0; i<matrixValues.length; i++){
			String[] row = br.readLine().split(" ");
			//Iterator through num cols
			for(int j = 0; j<matrixValues[0].length; j++){
				matrixValues[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		
		int numEmployees = Integer.parseInt(br.readLine());
		int[][] employeeValues = new int[numEmployees][2];
		
		for(int i =0; i<employeeValues.length; i++){
			String[] coordinates = br.readLine().split(" ");
			employeeValues[i][0] = Integer.parseInt(coordinates[0]);
			employeeValues[i][1] = Integer.parseInt(coordinates[1]);
		}
		
		findAnswer(matrixValues, employeeValues);
		
	}
}


class State implements Comparator<State>{
	int i;
	int j;
	int weight;
	
	public State(int i, int j, int weight  ){
		this.i = j;
		this.i = j;
		this.weight = weight;
	}
	
	@Override
	public int compare(State o1, State o2) {

		if(o1.weight < o2.weight ){
			return 1;
		}
		if(o2.weight < o1.weight ){
			return -1;
		}
		
		return 0;
	}
	
	@Override
	public boolean equals(Object o2){
			if(this.i == ((State)o2).i && this.j == ((State)o2).j && this.weight == ((State)o2).weight){
				return true;
			}
			else{
				return false;
			}
	}
	
}
