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
            System.out.println(findIndexToRemove(str));
        }
    }
    
    private static int findIndexToRemove(String s) {
        String tmp = s;
        char[] inp = s.toCharArray();
        tmp = tmp.replaceAll(String.valueOf(inp[0]), "");
        if(tmp.isEmpty()) // all chars are same
            return -1;
        
        int left = 0;
        int right = s.length()-1;
        while(left<right) {
            if(inp[left] != inp[right]) {
                int res = (isPalindrome(left+1, right, inp)) ? left : right;
                return res;
            }
                
            left++;
            right--;
        }
        return -1;
    }
        
    private static boolean isPalindrome(int start, int end, char[] inp) {
        while(start<end) {
            if(inp[start] !=inp[end])
                return false;
            start++;
            end--;
        }
        return true;
    }
}

