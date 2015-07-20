import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int nT = in.nextInt();
        
  
        while(nT>0) {
            int n = in.nextInt();
            int height = 1;
            boolean firstCycle = true;
            while(n>0){
            if(firstCycle) {
                height = height*2;
                firstCycle = false;
            }else{
                height++;
                firstCycle = true;
            }
                n--;
            }
            System.out.println(height);
            nT--;
        }
        
    }
}