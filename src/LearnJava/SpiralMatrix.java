package LearnJava;

import java.util.List;
import java.util.ArrayList;

/*
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */
public class SpiralMatrix {
    
    public int[][] rotateMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        if (m == 0 || n == 0) {
            return matrix;
        }

        int[][] result = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][m - 1 - i] = matrix[i][j];
            }
        }

        return result;

    }

        public List<Integer> spiralOrder(int[][] matrix) {

            List<Integer> result = new ArrayList<Integer>();
            int m=matrix.length;
            int n=matrix[0].length;
            if(m==0)
            return result;
            if(n==0)
            return result;
            if(m==1)
            {
                for(int i=0; i<n; i++)
                result.add(matrix[0][i]);
                return result;
            }
            if(n==1)
            {
                for(int i=0; i<m; i++)
                result.add(matrix[i][0]);
                return result;
            }

            for(int i=0; i<n; i++)
            result.add(matrix[0][i]);

            int[][] temp = new int[m-1][n];
            for(int i=1; i<m; i++)
            {
                for(int j=0; j<n; j++)
                temp[i-1][j]=matrix[i][j];
            }
            
            result.addAll(spiralOrder(rotateMatrix(temp)));

            return result;
        
    }
    
}
