import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int nT = Integer.parseInt(in.nextLine());
        for(int _i_nT = 0; _i_nT < nT ; _i_nT++){
            int m = Integer.parseInt(in.nextLine());
            int n = Integer.parseInt(in.nextLine());
            String flavors = in.nextLine();
            String[] nFlavors = flavors.split(" ");
            
            int[] _a = new int[n];
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int count = 1;
            for(int _i = 0; _i<n; _i++){
                _a[_i] = Integer.parseInt(nFlavors[_i]);
                map.put(count,_a[_i]);
                count++;
            }
            
            int rem = 0;
            boolean found = false;
            for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
                rem = m-entry.getValue();
                found = false;
                for(Map.Entry<Integer, Integer> entry1:map.entrySet()) {
                    if(entry1.getValue() == rem && entry.getKey()!= entry1.getKey()){
                        System.out.println(entry.getKey() + " " + entry1.getKey());
                        found = true;                            
                        break;
                    }
                }
                if(found) break;
            }
        }
    }
}