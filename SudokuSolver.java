package LearnJava;
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
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
    	
    	for(int i=0; i<9; i++){
    		for(int j=0; j<9; j++){
    			if(board[i][j]=='.'){
    				for(char k=1; k<=9; k++){
    					board[i][j]=k;
        				ValidSudoku obj = new ValidSudoku();
        				if(obj.isValidSudoku(board)){
        					solveSudoku(board);
        				}
    				  }
    				}
    			}
    		}
    }
    
    public static void main(String[] args){
    	SudokuSolver obj = new SudokuSolver();
    	char[][] board = {
  			  {'5','3','.','.','7','.','.','.','.'},
  			  {'6','.','.','1','9','5','.','.','.'},
  			  {'.','9','8','.','.','.','.','6','.'},
  			  {'8','.','.','.','6','.','.','.','3'},
  			  {'4','.','.','8','.','3','.','.','1'},
  			  {'7','.','.','.','2','.','.','.','6'},
  			  {'.','6','.','.','.','.','2','8','.'},
  			  {'.','.','.','4','1','9','.','.','5'},
  			  {'.','.','.','.','8','.','.','7','9'}
  			};
    	obj.solveSudoku(board);
    }
}
