import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 0; i<T; i++) {
            int N = in.nextInt();
            int tempN = N;
            int count = 0;
            while(tempN>0) {
                int temp = tempN%10;
                if(0 != temp) {
                     if(N%temp==0) 
                         count++;
                }
                tempN = tempN/10;
            }
            System.out.println(count);
        }
    }
}
}