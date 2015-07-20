import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        BigInteger fact = BigInteger.valueOf(1);
        for(int i = 1; i<=N; i++)
            fact = fact.multiply(BigInteger.valueOf(i));
        System.out.println(fact);
    }
}