import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int N = in.nextInt();
        int[] ar = new int[N];
        int[] count = new int[100];
        for(int i = 0; i<N; i++)
            ar[i] = in.nextInt();
        for(int i = 0; i<N; i++)
            count[ar[i]]++;
        for(int i = 0; i<100; i++) {
            if(count[i]!=0) {
                int tmp = count[i];
                while(tmp-->0)
                    System.out.print(i+ " ");
            }
                
        }
    }
}