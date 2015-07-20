import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] mat = new int[m][n];
        visited = new boolean[m][n];
        for(int  i = 0; i<m; i++) {
            for(int j = 0; j<n; j++)  {
                mat[i][j] = in.nextInt();
                visited[i][j] = false;
            }
            
        }
        int maxValue = Integer.MIN_VALUE;
        for(int  i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) 
                if(mat[i][j] == 1 && !visited[i][j]) {
                    int val = findConnectedGrid(mat, m, n, i, j);
                    if(val>maxValue) maxValue = val;
                }
        }
        System.out.println(maxValue);        
    }
    private static boolean isPosSafe(int r, int c, int m, int n, int[][] mat) {
        if(r>=0 && r<m && c>=0 && c<n && mat[r][c] == 1 && !visited[r][c])
                return true;
        
        return false;
    }
    private static int findConnectedGrid(int[][] mat, int m, int n, int i, int j) {
        int rowIndex[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int colIndex[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        visited[i][j] = true;
        int res = 1;
        for(int k = 0; k<8; k++) {
            int updatedRow = i + rowIndex[k];
            int updatedCol = j + colIndex[k];
            if(isPosSafe(updatedRow, updatedCol, m, n, mat)) {                
                res+= findConnectedGrid(mat, m, n, updatedRow, updatedCol);
            }
        }
        return res;
    }
}