import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(in.readLine());
            int[] a = new int[n];
            String[] temp = in.readLine().split(" ");
            int i = 0;
            HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
            for(String s : temp) {
                int val = Integer.parseInt(s); 
                a[i++] = val;
                if(count.containsKey(val))
                    count.put(val, count.get(val)+1);
                else
                    count.put(val, 1);                
            }
            

            ArrayList<Integer> missingNumbers = new ArrayList<Integer>();
            int m = Integer.parseInt(in.readLine());            
            int[] b = new int[m];
            temp = in.readLine().split(" ");
            i = 0;
            for(String s : temp) {
                int val = Integer.parseInt(s); 
                b[i++] = val;
                if(count.containsKey(val)&& count.get(val)>0)
                    count.put(val, count.get(val)-1);
                else
                    missingNumbers.add(val);
            }

            Collections.sort(missingNumbers);
            Set<Integer> missNums = new LinkedHashSet<Integer>(missingNumbers);
            // remove duplications
            for(Integer miss : missNums)
                System.out.print(miss + " ");
                
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
}