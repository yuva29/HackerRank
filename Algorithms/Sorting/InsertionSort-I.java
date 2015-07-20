import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void insertIntoSorted(int[] ar) {
        for(int i = ar.length-1; i<ar.length; i++) {
            int j = i-1;
            int tmp = ar[i];
            for(; j>=0; j--) {
                if(ar[j] > tmp)
                    ar[j+1] = ar[j];
                else
                    break;
                printArray(ar);
            }
            ar[j+1] = tmp;
            printArray(ar);
        }
    }
    
/* Tail starts here */
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
         for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
         }
         insertIntoSorted(ar);
    }
    
    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
    
    
}
 
