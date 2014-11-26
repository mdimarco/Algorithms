


import java.io.*;
import java.util.*;


public class TicTacToeTerview {

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

  
  static class TicTacToe {
    private char[][] board;
    private int board_size;
    private int moves_made;
    
    
    
    // 0 if game continuing
    // 1 if x won
    // 2 if o won
    // 3 if tie
    private int game_state;
    
    public TicTacToe( int board_size ){
      
      this.board = new char[board_size][board_size];
      this.board_size = board_size;
      for(int i = 0; i<board_size; i++){
        for( int j = 0; j<board_size; j++){
          this.board[i][j] = '_';
        }
      }  
      
      this.moves_made = 0;
      this.game_state = 0;

    }
    
    
    
   
    //return false if bad move
    public boolean move(int i, int j, char board_char){
      
      if( valid_move(i,j) ){
          board[i][j] = board_char;
          moves_made++;
      }
      else{
          return false;
      }
      
      check_game_state(i,j, board_char);
      return true;
    }
    
    
    public boolean valid_move(int i, int j){
        if(i<0 || j<0){
          return false;
        }
        else if(i >= board_size || j >= board_size){
          return false;
        }
        
        else if( board[i][j] != '_'){
          return false;
        }
        else{
          return true;
        }    
    }
    
    
    
    private void check_game_state(int i, int j, char board_char){
        if(moves_made == board_size*board_size){
          game_state = 3;
        }
      
        
      
       //Begin vertical check
        int curr_i = 0;
        while( curr_i < board_size ){
          if( board[curr_i][j] == board_char){
              curr_i++;
          }
          else{
              break;
          }
        }
      
      
        if( curr_i == board_size){
           set_game_state( board_char ); 
           return;
        }
      
      //End vertical check
      
      
      
      //Begin horizontal check
      int curr_j = 0;
      while( curr_j < board_size ){
        if( board[i][curr_j] == board_char ){
          curr_j++;
        }
        else{
          break;
        }
      }
      
      if( curr_j == board_size){
        set_game_state( board_char ); 
        return;
      }
      //End horizontal check
    
   
      
      
      //Top left to bottom right
      curr_i = 0;
      curr_j = 0;
      
      int counter = 0;
      while( curr_i < board_size && curr_j<board_size){
          if( board[curr_i][curr_j] == board_char ){
                counter++;
          }
          else{
            break;
          }
          curr_i++;
          curr_j++;
      }
      
      if( counter == board_size ){
         set_game_state( board_char );
         return;
      }
      
      //End top left to bottom right
      
      
      //bottom left to top right
      curr_i = 0;
      curr_j = board_size-1;
      counter = 0;
      
      while( curr_i < board_size && curr_j >= 0 ){
        if( board[curr_i][curr_j] == board_char){
          counter++;
        }
        else{
          break;
        }
        curr_i++;
        curr_j--;
      }
      
      if( counter == board_size) {
        set_game_state( board_char);
      }
      //end bottom left to top right
      
      
    }
    
    
    public void set_game_state( char board_char ){
            if( board_char == 'x'){
               game_state = 1;
             }
             else{
               game_state = 2;
             } 
    }
    
    
    public void print_board(){
      
        for(int i =0; i<this.board_size;i++){
          for(int j =0; j<this.board_size; j++){
             System.out.print( this.board[i][j] + " ");
          }
          System.out.println();
        }
 
    }
    
  }
  
  
  
  
  public static void main(String[] args) {
    TicTacToe ttt;
    
    int i =0;
    int j =0;
    
    
    Random randInt = new Random();
    
    
    
    int counter = 0;
    do{
    	ttt = new TicTacToe(5);
    	int inner_counter = 0;
	    while( ttt.game_state == 0 ){
	        i = randInt.nextInt(ttt.board_size);
	        j = randInt.nextInt(ttt.board_size);
	      
	        char board_char;
	        if( inner_counter % 2 == 0){
	          board_char = 'x';
	        }
	        else{
	          board_char = 'o';
	        }
	        
	        
	        if( ttt.move(i,j,board_char) ){
	        	inner_counter++;
	            //ttt.print_board();
	            //System.out.println();
	        }
	       
	    
	    }
	    counter++;
	    if(counter % 100000 == 0){
	    	System.out.println(counter);
	    }
	    
	  }while(ttt.game_state == 3);
    	
	    System.out.println("Game ended after "+counter+" Iterations");
	    System.out.println();
	    ttt.print_board();
	    System.out.println();
	    if( ttt.game_state == 1 ){
	      System.out.println( "Player 1 wins");
	    }
	    else if( ttt.game_state == 2){
	      System.out.println( "Player 2 wins");
	    }
	    else{
	      System.out.println( "It's a tie!");
	    }
	}


}
