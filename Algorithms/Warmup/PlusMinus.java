import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int positiveCount = 0;
        int negativeCount = 0;
        int zerosCount = 0;
        int N = in.nextInt();
        for(int i = 0; i < N; i++) {
            int temp = in.nextInt();
            if(temp > 0) {
                positiveCount++;
            } else if(temp == 0) {
                zerosCount++;
            } else {
                negativeCount++;
            }
        }
        double temp = (double) positiveCount/N;
        System.out.println(String.format("%.6f", temp));
        temp = (double) negativeCount/N;
        System.out.println(String.format("%.6f", temp));
        temp = (double) zerosCount/N;
        System.out.println(String.format("%.6f", temp));
        
        
    }
}