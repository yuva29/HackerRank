import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static boolean visited[][];
    public static void main(String[] args) {
        int startI = -1; int startJ = -1;
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(in.readLine());
            for(int i = 0; i<t; i++) {
                String[] temp = in.readLine().split(" ");
                int n = Integer.parseInt(temp[0]);
                int m = Integer.parseInt(temp[1]);
                char[][] mat = new char[n][m];
                visited = new boolean[n][m];
                for(int j = 0; j<n; j++) {
                    String str = in.readLine();
                    for(int x = 0; x<m; x++) {
                        mat[j][x] = str.charAt(x);
                        if(mat[j][x] == 'M') {
                            startI = j;
                            startJ = x;
                        }
                        visited[j][x] = false;
                    }
                }
                int k = Integer.parseInt(in.readLine());
                if(k == countLuck(mat, n, m, startI, startJ, 0))
                    System.out.println("Impressed");
                else
                    System.out.println("Oops!");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private static boolean isPosSafe(char[][] mat, int n, int m, int i, int j) {
        if(i>=0 && i<n && j>=0 && j<m && mat[i][j] != 'X' && !visited[i][j])
            return true;
        return false;
    }
    
    private static int findNumPosSafe(char[][] mat, int n, int m, int i, int j) {
        int rowIndex[] = {0, 0, 1, -1};
        int colIndex[] = {-1, 1, 0, 0}; 
        int count = 0;
        for(int ind = 0; ind<4; ind++) {
            int tempR = i + rowIndex[ind];
            int tempC = j + colIndex[ind];            
            if(isPosSafe(mat, n, m, tempR, tempC)) {
                count++;
            }
        }
        return count;
    }
    
    private static int countLuck(char[][] mat, int n, int m, int i, int j, int steps) {
        int rowIndex[] = {0, 0, 1, -1};
        int colIndex[] = {-1, 1, 0, 0};
        visited[i][j] = true;
        if(mat[i][j] == '*') 
            return steps;
        int numPosSafe = findNumPosSafe(mat, n, m, i, j);
        if(numPosSafe>1) steps = steps+1;        
        for(int ind = 0; ind<4; ind++) {
            int tempR = i + rowIndex[ind];
            int tempC = j + colIndex[ind];            
            if(isPosSafe(mat, n, m, tempR, tempC)) {                
                int res = countLuck(mat, n, m, tempR, tempC, steps);
                if(res !=0 ) {
                    return res;
                }
            }
        }
        return 0; // blocked
    }
}