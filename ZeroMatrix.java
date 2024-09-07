import java.util.Set;
import java.util.HashSet;

class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();
        for(int row = 0; row < matrix.length; row ++) {
            for(int col = 0; col < matrix[0].length; col ++) {
                if(matrix[row][col] == 0) {
                    rows.add(row);
                    cols.add(col);
                }
            }
        }
        for(int row = 0; row < matrix.length; row ++) {
            boolean markRow = rows.contains(row);
            for(int col = 0; col < matrix[0].length; col ++) {
                if(markRow || cols.contains(col)) {
                    matrix[row][col] = 0;
                }
            }
        }   
    }
}