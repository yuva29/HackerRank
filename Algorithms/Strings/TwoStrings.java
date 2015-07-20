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
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            System.out.println(longestCommonSubString(str1, str2));
        }
    }
    
    private static String longestCommonSubString(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(s1.equals(s2)) return "YES";
        
        HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
        for(int i = 0; i<n; i++) {
            char tmp = s1.charAt(i);
            if(charCount.containsKey(tmp))
                charCount.put(tmp, charCount.get(tmp)+1);
            else
                charCount.put(tmp,1);
        }
        
        for(int i = 0; i<m; i++) {
            char tmp = s2.charAt(i);
            if(charCount.containsKey(tmp))
                return "YES";
        }            
        return "NO";
    }
    
    
}