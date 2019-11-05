package LearnJava;
/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.


A sudoku puzzle...


...and its solution numbers marked in red:

Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.

A filled sudoku:
{
  {'5','3','4','6','7','8','9','1','2'},
  {'6','7','2','1','9','5','3','4','8'},
  {'1','9','8','2','4','2','5','6','7'},
  {'8','5','9','7','6','1','4','2','3'},
  {'4','2','6','8','5','3','7','9','1'},
  {'7','1','3','9','2','4','8','5','6'},
  {'9','6','1','5','3','7','2','8','4'},
  {'2','8','7','4','1','9','6','3','5'},
  {'3','4','5','2','8','6','1','7','9'}
}
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
  {'5','3','4','6','7','8','9','1','2'},
  {'6','7','2','1','9','5','3','4','8'},
  {'1','9','8','2','4','2','5','6','7'},
  {'8','5','9','7','6','1','4','2','3'},
  {'4','2','6','8','5','3','7','9','1'},
  {'7','1','3','9','2','4','8','5','6'},
  {'9','6','1','5','3','7','2','8','4'},
  {'2','8','7','4','1','9','6','3','5'},
  {'3','4','5','2','8','6','1','7','9'}
};
    	obj.solveSudoku(board);
    }
}
