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

            int col = 0;
            for (int i=0; i<=m/2; i++) {
                for (int j=col; j<=n-col-1; j++){
                    result.add(matrix[i][j]);
                }
                for (int k=i+1; k<=m-i-1; k++) {
                    result.add(matrix[k][n-col-1]);
                }
                for (int l=n-col-2; l>=col; l--) {
                    result.add(matrix[m-i-1][l]);
                }
                for (int p=m-i-2; p>i; p--) {
                    result.add(matrix[p][col]);
                }

                System.out.println("When i="+i+", result="+result+", col="+col+" m/2="+m/2);

                col++;
                if(col>n/2){
                    break;
                }
            }



            return result;
        
    }

    public static void main(String args[]) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        SpiralMatrix sm = new SpiralMatrix();
        List<Integer> result = sm.spiralOrder(matrix);
        System.out.println(result);

        int[][] matrix2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        SpiralMatrix sm2 = new SpiralMatrix();
        List<Integer> result2 = sm2.spiralOrder(matrix2);
        System.out.println(result2);

        int[][] matrix3 = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        SpiralMatrix sm3 = new SpiralMatrix();
        List<Integer> result3 = sm3 .spiralOrder(matrix3);
        System.out.println(result3);
    }
    
}
