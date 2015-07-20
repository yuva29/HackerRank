import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        try(BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) { 
            int t = Integer.parseInt(input.readLine());
            //numbers that end with this cannot be squares (2,3,7,8)
            /*int[] notSq = {0,0,2,3,0,0,0,7,8,0};
            for(int x = 0; x < t; x++) {
                String temp[] = input.readLine().split(" ");
                int a = Integer.parseInt(temp[0]);
                int b = Integer.parseInt(temp[1]);
                int count = 0;
                for(int i = a; i <=b; i++) {
                    if(notSq[i%10] != 0) continue;
                    int sqNum = (int) Math.sqrt(i);
                    if((sqNum*sqNum) == i) 
                        count++;
                }
                System.out.println(count);
            }*/
            
            // Another easy solu
            for(int x = 0; x < t; x++) {
                String temp[] = input.readLine().split(" ");
                int a = Integer.parseInt(temp[0]);
                int b = Integer.parseInt(temp[1]);
                
                int c = (int) (Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1);
                System.out.println(c);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}