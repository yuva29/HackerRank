import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class obj {
    int key;
    String value;
    obj(int k, String v) {
        this.key = k;
        this.value = v;
    }
}
public class Solution {

    public static void main(String[] args) {
        try(BufferedReader inp = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(inp.readLine());
            obj[] objs = new obj[n];
            int[] count = new int[100];
            for(int i = 0; i<n; i++) {
                String[] temp = inp.readLine().split(" ");
                obj o = new obj(Integer.parseInt(temp[0]), temp[1]);
                objs[i] = o;
                count[o.key]++;
            }
            int[] indices = new int[100];
            indices[0] = 0;
            for(int i = 1; i<100; i++) {
                indices[i] = indices[i-1]+count[i-1];
            }
            int[] correctOutputOrder = new int[n];
            for(int i = 0; i<n; i++) {
                int k = objs[i].key;
                correctOutputOrder[indices[k]++] = i; // indices[k] : gives the start position and increment it for the next 'k'
            }
            /*
            for(int i = 0; i<n; i++) {
                int index = correctOutputOrder[i];
                if(index == i) continue;
                obj tmp = objs[i];
                objs[i] = objs[index];
                objs[index]= tmp;
            }*/

            int threshold = n/2;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<n; i++) {
                int eltIndex = correctOutputOrder[i];
                if(eltIndex>=threshold)
                    sb.append(objs[eltIndex].value + " ");
                else
                    sb.append("- ");
            }
            System.out.print(sb);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}