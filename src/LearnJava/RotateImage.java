package LearnJava;
/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]

Example 3:
Input
[[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output
[[15,2,13,5],[14,4,3,1],[12,8,6,9],[16,10,7,11]]
Expected
[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
		*/
public class RotateImage {
    public void rotate(int[][] matrix) {
    	int n = matrix.length, tempint;
        int[] temprow = new int[n];
        for(int i=0; i<n/2; i++){
        		temprow = matrix[i];
        		matrix[i] = matrix[n-i-1];
        		matrix[n-i-1] = temprow;
        }
        for(int i=0; i<n; i++){
    		for(int j=0; j<=i; j++){
    			tempint = matrix[i][j];
    			matrix[i][j] = matrix[j][i];
    			matrix[j][i] = tempint;
    		}
    	}
    }
    
    public static void main(String[] args){
    	int[][] matrix = {{5,1,9,11},{2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
    	RotateImage obj = new RotateImage();
    	obj.rotate(matrix);
    	for(int i=0; i<matrix.length; i++){
    		System.out.println("");
    		for(int j=0; j<matrix.length; j++){
    			System.out.print(matrix[i][j]+", ");
    		}
    	}
    }
}
