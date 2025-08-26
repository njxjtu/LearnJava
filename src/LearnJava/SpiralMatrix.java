package LearnJava;

import java.util.List;
import java.util.ArrayList;

/*
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */
public class SpiralMatrix {
    
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
            for(int i=1; i<m; i++)
            result.add(matrix[i][n-1]);

            return result;
        
    }
    
}
