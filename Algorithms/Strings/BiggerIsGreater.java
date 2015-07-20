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
            System.out.println(calculateNextGreaterString(str));
        }
    }
    
    private static String calculateNextGreaterString(String str) {
        String temp = str;        
        char[] inp = str.toCharArray(); // processing on char array is faster than charAt
        temp = temp.replaceAll(String.valueOf(inp[0]), "");
        
        if(temp.isEmpty()) // all the characters are same            
            return "no answer";
        
        int n = str.length();
        int i = n-1;
        for(; i>0; i--) {
            if(inp[i-1]<inp[i]) // i can be swapped with i-1;
                break;
        }
        if(i == 0) return "no answer";
        //find min from i to n
        int minPos = findMinPos(inp, i, inp[i-1]);
        char tmp = inp[minPos];
        inp[minPos] = inp[i-1];
        inp[i-1] = tmp;
        
        //sort the characters from ith pos
        Arrays.sort(inp, i, n);
        return new String(inp);
    }
    
    private static int findMinPos(char[] inp, int start, char t) {
        int minPos = start;
        for(int i = start+1; i<inp.length; i++) {
            if(inp[i]>t && inp[i]<inp[minPos])
                minPos = i;
        }
        return minPos;
    }
}