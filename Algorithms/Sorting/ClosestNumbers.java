import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{

       public static void main(String[] args) {
           try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
               int n = Integer.parseInt(in.readLine());
               Long[] ar = new Long[n];
               String temp[] = in.readLine().split(" ");
               int index = 0;
               for(String s : temp) 
                   ar[index++] = Long.parseLong(s);
               findClosest(ar);
           } catch(Exception e) {
               e.printStackTrace();
           }
       }
    
    private static void findClosest(Long[] ar) {
        Arrays.sort(ar);
        long minDiff = Integer.MAX_VALUE;
        ArrayList<Long> results = new ArrayList<Long>();
        for(int i = 0; i<ar.length-1; i++) {
            long diff = Math.abs(ar[i]-ar[i+1]);
            if(diff < minDiff) {
                results.clear();
                results.add(ar[i]);
                results.add(ar[i+1]);
                minDiff = diff;
            } else if(diff == minDiff) {
                results.add(ar[i]);
                results.add(ar[i+1]);                
            }                                                              
        }
        for(Long l: results)
            System.out.print(l+" ");
    }
}