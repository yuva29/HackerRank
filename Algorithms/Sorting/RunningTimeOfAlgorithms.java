import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int  i = 0; i<n; i++)
            ar[i] = in.nextInt();
        System.out.println(countShiftsIS(ar));
    }
    
    private static int countShiftsIS(int[] ar){
        int shifts = 0;
        for(int i = 1; i<ar.length; i++) {
            int tmp = ar[i];
            int j = i-1;
            for(; j>=0 && ar[j]>tmp; j--) {
                shifts++;
                ar[j+1] = ar[j];
            }
            ar[j+1] = tmp;
        }
        return shifts;
    }
}