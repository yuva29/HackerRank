import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            System.out.println(Solve(in.nextInt(), in.nextInt(), in.nextInt()));
        }
    }
    
    private static long Solve(int N, int C, int M) {
        long chocosInHand = 0;
        long wrappersInHand = 0;
        while(N>0) {
            if(N>=C) { 
                N = N-C;
                chocosInHand++;
                wrappersInHand++;
            } else
                return chocosInHand;
            if(wrappersInHand >= M) {
                wrappersInHand-=M;
                chocosInHand++;
                wrappersInHand++;
            }
        }
        if(wrappersInHand>=M)
            chocosInHand++;
        return chocosInHand;
    }
    
    
}
