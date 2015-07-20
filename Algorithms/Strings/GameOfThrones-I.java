import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();
       
        String ans;
        ans = checkPalindromExists(inputString);
        System.out.println(ans);
        myScan.close();
    }
    
    private static String checkPalindromExists(String str) {
        HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
        for(int i = 0; i<str.length(); i++) {
            char tmp = str.charAt(i);
            if(charCount.containsKey(tmp))
                charCount.put(tmp, charCount.get(tmp)+1);
            else 
                charCount.put(tmp, 1);
        }
        
        //everything shld appear even num times except one character
        int onlyOnce = 0;
        for(char c: charCount.keySet()) {
            if(charCount.get(c)%2 == 1)
                onlyOnce++;
            if(onlyOnce>1) 
                return "NO";
        }
        return "YES";
            
    }
}
