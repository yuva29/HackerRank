import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//*** IMP Qucik sort solution is in earlier submission ***
public class Solution {

    public static void main(String[] args) {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(in.readLine());
            int[] ar = new int[n];
            String[] temp = in.readLine().split(" ");
            int i = 0;
            for(String s: temp) {
                ar[i++] = Integer.parseInt(s);
            }
            Arrays.sort(ar);
            System.out.print(ar[n/2]);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static void findMedian(int[] ar, int left, int right) {
        if(left<right) {
            int index = quickSort(ar, left, right);
            if(left<index-1)
                findMedian(ar, left, index-1);
            if(right>index+1)
                findMedian(ar, index+1, right);
        }
    }
    private static int quickSort(int[] ar, int left, int right) {
        int mid = left+(right-left)/2;
        mid++;
        if(left<right) {
            int pivot = ar[mid];
            while(left<right) {
                while(ar[left]<pivot) 
                    left++;
                while(ar[right]>pivot)
                    right--;
                if(left<right) {
                    int tmp = ar[left];
                    ar[left] = ar[right];
                    ar[right] = tmp;
                    left++;
                    right--;
                }                
            }
            ar[left] = pivot;
        }
        return left;
    }
}