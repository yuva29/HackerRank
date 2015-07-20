import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in  = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 0; i<T; i++) {
            int N = in.nextInt();
            int K = in.nextInt();
            int studentsPresent = 0;
            for(int  j = 0; j < N; j++) {
                if(in.nextInt()<=0) {
                    studentsPresent++;
                }
            }
            if(studentsPresent < K) {
                System.out.println("YES");
                continue;
            } 
            System.out.println("NO");
        }
    }
}