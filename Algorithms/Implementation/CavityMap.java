import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        try(BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(input.readLine());
            int mat[][] = new int[n][n];
            char output[][] = new char[n][n];
            for(int i = 0; i<n; i++) {
                String temp = input.readLine();
                for(int j = 0; j<n; j++) {
                    output[i][j] = temp.charAt(j);
                    mat[i][j] = (int)output[i][j];
                }
            }
            // leave out the outher elements as they cannot be cavity
            for(int i = 1; i<n-1; i++) {
                for(int j = 1; j<n-1; j++) {
                    if(mat[i][j] > mat[i-1][j] && mat[i][j] > mat[i][j-1] && mat[i][j] > mat[i+1][j] && mat[i][j] > mat[i][j+1]) {
                        //Cavity
                        output[i][j] = 'X';
                    }
                }
            }
            printOutput(output, n);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void printOutput(char[][] output, int n) {
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                System.out.print(output[i][j]);
            }
            System.out.println();
        }
    }
}