import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        for(int i = 0; i<T; i++) {
            String str = in.nextLine();
            System.out.println(countWhateverNeeded(str));
        }
    }
    public static int countWhateverNeeded(String str) {
        char[] inp = str.toCharArray();
        int totalCount = 0;
        for(int i = 1; i<str.length(); i++) {
            if(inp[i] == inp[i-1]) 
                totalCount++;
        }
        return totalCount;
    }
}