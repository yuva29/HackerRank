import java.util.*;
public class Solution {
       
       static void partition(int[] ar) {
           int pivot = ar[0];
           int left = 0;
           int right = ar.length-1;
           while(left<right) {
               while(ar[left] < pivot) 
                  left++;                
               while(ar[right]>pivot) 
                   right--;
               // swap right and left
               if(left<right) {
                   int tmp = ar[left];
                   ar[left] = ar[right];
                   ar[right] = tmp;                             
               }
           }
           ar[left] = pivot;
           printArray(ar);
       }   
 
 static void printArray(int[] ar) {
         for(int n: ar){
            System.out.print(n+" ");
         }
           System.out.println("");
      }
       
      public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt(); 
           }
           partition(ar);
       }    
   }
