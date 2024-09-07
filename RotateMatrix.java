import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int row = 0; row < n / 2; row ++) {
            int end = n - row - 1; 
            for(int col = row; col < end; col ++) {
                int offset = col - row;
                int top = matrix[row][col]; 
                int right = matrix[col][end];
                int bottom = matrix[end][end - offset]; 
                int left = matrix[end - offset][row]; 
                matrix[row][col] = left;
                matrix[col][end] = top;
                matrix[end][end - offset] = right;
                matrix[end - offset][row] = bottom;
            }
        }
    }
    public static void main(String[] args) {
        /*
         *  [[1, 2, 3],
         *   [4, 5, 6],
         *   [7, 8, 9]]
         * 
         * 1 -> 0, 0 -> 0, 2
         * 2 -> 0, 1 -> 1, 1
         * 5 -> 1, 1 -> 1, 1
         * 9 -> 2, 2 -> 2, 0
         * 8 -> 2, 1 -> 1, 0
         * 
         *  [[7, 4, 1],
         *   [8, 5, 2],
         *   [9, 6, 3]
         *  ]]
         */
        int[][] matrix = {
            {5,1,9,11},
            {2,4,8,10},
            {13,3,6,7},
            {15,14,12,16}
        };
        new RotateMatrix().rotate(matrix);
    }
}