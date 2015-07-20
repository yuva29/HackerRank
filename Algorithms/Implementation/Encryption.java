import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        
        int r = (int) Math.floor(Math.sqrt(input.length()));
        int c = (int) Math.ceil(Math.sqrt(input.length()));
        while(r*c < input.length()) {
            r = (int) Math.ceil(Math.sqrt(input.length()));
        }
        char[][] grid = new char[r][c];
        
        int count = 0;
        breakEverything:
        for(int i = 0; i<r; i++) {
            for(int j = 0; j<c; j++) {
                grid[i][j] = input.charAt(count++);
                if(count>=input.length()) 
                    break breakEverything;                
            }
        }
        
        // print col wise
        for(int j = 0; j<c; j++) { 
            for(int i = 0; i<r; i++) {
                if(grid[i][j] == '\0') 
                    break;
                System.out.print(grid[i][j]);
            }
            System.out.print(" ");
        }
    }
}