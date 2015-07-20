import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static String Repeat(String s, int n) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < n; i++)
            ret.append(s);
        return ret.toString();
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 0; i<T; i++) {
            int N = in.nextInt();
            if(N<3) { // no key code possible
                System.out.println("-1");
                continue;
            }
            String result = "";
            for(int j = N; j>=0; j--) {
                if(j%3==0 && (N-j)%5 == 0) {
                    result = Repeat("5", j) + Repeat("3", N-j);
                    break;
                }
            }
            if(result.isEmpty())
                System.out.println("-1");
            else 
                System.out.println(result);
        }
    }
}