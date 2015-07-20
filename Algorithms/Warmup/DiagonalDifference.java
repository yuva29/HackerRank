import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
        int N =  in.nextInt();
        int diag1 = 0;
        int diag2 = 0;
        int[][] mat = new int[N][N];
                
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++) {
                mat[i][j] = in.nextInt();
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++) {
                if( i == j) {
                    diag1+=mat[i][j];
                }
                if(i+j == N-1) {
                    diag2+=mat[i][j];
                }
            }
        }
        
        System.out.println(Math.abs(diag1-diag2));
        
    }
}