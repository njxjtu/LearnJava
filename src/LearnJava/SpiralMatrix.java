package LearnJava;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

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

            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new ArrayList<Integer>();
            };
            
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



            return result;
        
    }

    public static void main(String args[]) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        SpiralMatrix sm = new SpiralMatrix();
        List<Integer> result = sm.spiralOrder(matrix);

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
    }
    
}
