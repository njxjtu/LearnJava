package LearnJava;
/*
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
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
    	//check subgrids
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
    	ValidSudoku obj = new ValidSudoku();
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
    	System.out.println(obj.isValidSudoku(board));
    }
}
