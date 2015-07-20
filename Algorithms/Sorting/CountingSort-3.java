import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class inputStruct {
    int key;
    String value;
    inputStruct(int k, String val) {
        this.key = k;
        this.value = val;
    }
}
public class Solution {

    public static void main(String[] args) {    
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        inputStruct[] objs = new inputStruct[N];
        for(int i = 0; i<N; i++) {
            String[] inp = in.nextLine().split(" ");
            inputStruct newObj = new inputStruct(Integer.parseInt(inp[0]), inp[1]);
            objs[i] = newObj;
        }
        int count[] = new int[100];
        for(int i = 0; i<N; i++) {
            count[objs[i].key]++;
        }
        int startPos[] = new int[100];
        startPos[0] = count[0];
        for(int i = 1; i<100; i++) {
            startPos[i] = startPos[i-1]+count[i];
        }
        for(int i = 0; i<100; i++) {
            System.out.print(startPos[i] + " ");
        }
            
        
    }
}