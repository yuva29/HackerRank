import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        try(BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(input.readLine());
            HashMap<Character, Integer> countMap =  new HashMap<Character, Integer>();
            
            for(int i = 0; i<T; i++) {
                String inp = input.readLine();
                inp = inp.replaceAll("\\s+","");
                if(inp.length()%2 == 1) { //not possible for 2 strings of unequal length to be anagram
                    System.out.println("-1");
                    continue;
                }   
                int mid = inp.length()/2;                
                String s1 = inp.substring(0, mid);
                String s2 = inp.substring(mid, inp.length());
                if(s1.equals(s2)) {
                    System.out.println("0");
                    continue;
                }
                
                HashMap<Character, Integer> mapCount = new HashMap<Character, Integer>();
                for(int j = 0; j<s2.length(); j++) {
                    char temp = s2.charAt(j);
                    if(mapCount.containsKey(temp)) 
                        mapCount.put(temp, mapCount.get(temp)+1);
                    else
                        mapCount.put(temp, 1);                               
                }
                
                for(int j = 0; j<s1.length(); j++) {
                    char temp = s1.charAt(j);
                    if(mapCount.containsKey(temp) && mapCount.get(temp)>0)
                         mapCount.put(temp, mapCount.get(temp)-1);
                }
                
                int count = 0;
                for(char c: mapCount.keySet())
                    if(mapCount.get(c)>0)
                        count+=mapCount.get(c);
                System.out.println(count);
                
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}