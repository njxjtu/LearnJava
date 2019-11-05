package LearnJava;

import java.util.ArrayList;
import java.util.Arrays;

/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.


A sudoku puzzle...


...and its solution numbers marked in red.

Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.

A filled sudoku:
{
    			  {'3', '1', '6', '5', '7', '8', '4', '9', '2'},
    			  {'5', '2', '9', '1', '3', '4', '7', '6', '8'},
    			  {'4', '8', '7', '6', '2', '9', '5', '3', '1'},
    			  {'2', '6', '3', '4', '1', '5', '9', '8', '7'},
    			  {'9', '7', '4', '8', '6', '3', '1', '2', '5'},
    			  {'8', '5', '1', '7', '9', '2', '6', '4', '3'},
    			  {'1', '3', '8', '9', '4', '7', '2', '5', '6'},
    			  {'6', '9', '2', '3', '5', '1', '8', '7', '4'},
    			  {'7', '4', '5', '2', '8', '6', '3', '1', '9'}
    			}
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        fillGrid(board);
    	
    }

    boolean fillGrid(char[][] board){
    	System.out.println("In fillGrid ");
    	boolean fill = true;
    	char[] candi={'1','2','3','4','5','6','7','8','9'};
    	int k =0, p=-1, q=-1;
    	for(int i=0; i<9; i++){
    		for(int j=0; j<9; j++){
    			if(board[i][j]<'1'){
    				p=i;
    				q=j;
    			}
    		}
    		
    	}
    	System.out.println("p: "+p+" q: "+q);
    	if(p!=-1){
    		for(k=0; k<9;k++){
    			board[p][q]=candi[k];
    			System.out.println("k: "+k);
    			System.out.println("validSudoku: "+isValidSudoku(board));
    			if(isValidSudoku(board)&&fillGrid(board)){
    				System.out.println(" both valid");
    				return true;}
    		}
    		
    	}
    		
    	return fill;
    }
    
    boolean isValidSudoku(char[][] board) {
        //check rows
    	for(int i=0; i<board.length; i++){
    		if(!isValid9(board[i])){
    			return false;
    		}
    	}
    	//check columns
    	for(int j=0; j<board.length; j++){
    		char[] tempc = new char[9];
    		for(int k=0; k<board.length; k++){
    			tempc[k]=board[k][j];
    		}
    		if(!isValid9(tempc)){
    			return false;
    		}
    	}
    	//check subgrid
    	for(int i=0; i<9; i+=3){
    		for(int j=0; j<9; j+=3){
    			char[] tempc = new char[9];
    			int k=0;
    			for(int p=i; p<i+3; p++){
    				for(int q=j; q<j+3; q++){
    					tempc[k]=board[p][q];
    					k++;
    				}
    			}
    			if(!isValid9(tempc)){
    				return false;
    			}
    		}
    	}
    	return true;
    }
    boolean isValid9(char[] carr){
    	int[] count = new int[10];
    	for(int i=0; i<10; i++){
    		count[i] = 0;
    	}
    	for(int i=0; i<carr.length; i++){
    		//System.out.println("i: "+i+" carr[i]: "+carr[i]);
    		//System.out.println("Character.getNumericValue(carr[i]): "+Character.getNumericValue(carr[i]));
    		if(carr[i]=='.'){
    			continue;
    		}
    		else if(count[Character.getNumericValue(carr[i])]>=1){
    			return false;
    		}
    		else if(count[Character.getNumericValue(carr[i])]==0){
    			count[Character.getNumericValue(carr[i])]++;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args){
    	SudokuSolver obj = new SudokuSolver();
    	char[][] board = {
  			  {'3', '1', '.', '.', '7', '8', '4', '9', '2'},
  			  {'5', '2', '9', '1', '3', '4', '7', '6', '8'},
  			  {'4', '8', '7', '6', '2', '9', '5', '3', '1'},
  			  {'2', '6', '3', '4', '1', '5', '9', '8', '7'},
  			  {'9', '7', '4', '8', '6', '3', '1', '2', '5'},
  			  {'8', '5', '1', '7', '9', '2', '6', '4', '3'},
  			  {'1', '3', '8', '9', '4', '7', '2', '5', '6'},
  			  {'6', '9', '2', '3', '5', '1', '8', '7', '4'},
  			  {'7', '4', '5', '2', '8', '6', '3', '1', '9'}
  			};
    	obj.solveSudoku(board);
    	for(int i=0; i<9; i++){
    		for(int j=0; j<9; j++){
    			System.out.print(board[i][j]+", ");
    			}
    		System.out.println("");
    		}
    	
    }
}
