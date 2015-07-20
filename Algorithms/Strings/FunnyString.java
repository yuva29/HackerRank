import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try(BufferedReader inp = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(inp.readLine());
            while(t>0) {
                String input = inp.readLine();
                ArrayList<Integer> abss = new ArrayList<Integer>();
                for(int i = 1; i<input.length(); i++) {
                    int temp = Math.abs(input.charAt(i) - input.charAt(i-1));
                    abss.add(i-1, temp);
                }
                int right = abss.size()-1;
                int left = 0;
                boolean found = false;
                while(right > left) {
                    if(abss.get(left) != abss.get(right)) {
                        System.out.println("Not Funny");
                        found = true;
                        break;
                    }
                    left++;
                    right--;
                }
                if(!found)
                    System.out.println("Funny");
                t--;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}