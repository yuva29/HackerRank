import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(in.readLine());
            for(int  i = 0; i<t; i++) {
                int n = Integer.parseInt(in.readLine());
                String temp[] = in.readLine().split(" ");
                int[] ar = new int[n];
                int index = 0;
                for(String s: temp)
                    ar[index++] = Integer.parseInt(s);
                System.out.println(findEqualSum(ar, n));
            }            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static String findEqualSum(int[] ar, int n) {
        int left = 0;
        int right = n-1;
        long leftSum = 0;
        long rightSum = 0;
        while(left<right) {
                if(leftSum>rightSum) {
                    rightSum+=ar[right];
                    right--;
                } else {
                    leftSum+=ar[left];
                    left++;
                }
        }
        if(leftSum == rightSum && left == right)
            return "YES";
        return "NO";
        
    }
}