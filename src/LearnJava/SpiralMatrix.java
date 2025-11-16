package LearnJava;

import java.util.List;
import java.lang.reflect.Array;
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

        if (m ==1 && n ==1) {
            return matrix;
        }

        int[][] result = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                result[n- i-1][j] = matrix[j][i];
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
            if(m==2) {
                for(int i=0; i<n; i++)
                result.add(matrix[0][i]);
                for(int i=n-1; i>=0; i--)
                result.add(matrix[1][i]);
                return result;
            }

            for(int i=0; i<n; i++){
                result.add(matrix[0][i]);
            }

            int[][] tempMatrix = new int[m-1][n];

            for(int i=1; i<m; i++){
                    tempMatrix[i-1] = matrix[i];
            }
            
            result.addAll(spiralOrder(rotateMatrix(tempMatrix)));

            return result;
        
    }

    public static void main(String args[]) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        SpiralMatrix sm = new SpiralMatrix();
        //System.out.println(Arrays.deepToString(sm.rotateMatrix(matrix)));
        List<Integer> result = sm.spiralOrder(matrix);
        System.out.println(result);

        int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        SpiralMatrix sm2 = new SpiralMatrix();
        //System.out.println(Arrays.deepToString(sm2.rotateMatrix(matrix2)));
        List<Integer> result2 = sm2.spiralOrder(matrix2);
        System.out.println(result2);

        int[][] matrix3 = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        SpiralMatrix sm3 = new SpiralMatrix();
        List<Integer> result3 = sm3 .spiralOrder(matrix3);
        System.out.println(result3);
    }
    
}
