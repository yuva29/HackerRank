import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] ar = new int[N];
        for(int i = 0; i<N; i++) 
            ar[i] = in.nextInt();
        int[] counts = new int[100];
        for(int i = 0; i<N; i++)
            counts[ar[i]]++;
        for(int i = 0; i<100; i++)
            System.out.print(counts[i] + " ");
    }
}