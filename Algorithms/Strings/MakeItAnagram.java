import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inp1 = in.nextLine();
        String inp2 = in.nextLine();
        HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
        
        int totalDeletions = inp1.length() + inp2.length();
        
        for(int i = 0; i<inp1.length(); i++) {
            char temp = inp1.charAt(i);
            if(countMap.containsKey(temp))
                countMap.put(temp, countMap.get(temp)+1);
            else 
                countMap.put(temp, 1);
        }
        int commonChars = 0;
        for(int i = 0; i<inp2.length(); i++) {
            char temp = inp2.charAt(i);
            if(countMap.containsKey(temp) && countMap.get(temp)>0) {
                commonChars++;
                countMap.put(temp, countMap.get(temp)-1);
            }
        }        
        totalDeletions-=(2*commonChars);
        System.out.println(totalDeletions);
    }
}