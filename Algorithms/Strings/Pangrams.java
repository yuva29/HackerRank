import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String input = in.nextLine().toLowerCase().trim();
        input = input.replaceAll("\\s",""); // removes all spaces
        HashMap<Character, Boolean> alphabetMap = new HashMap<Character, Boolean>();
        for(int i = 0; i<input.length();i++) {
            char temp = input.charAt(i);
            if(!alphabetMap.containsKey(temp)) { // alphabet
                alphabetMap.put(temp, true);
                if(alphabetMap.keySet().size() >= 26) {  // all 26 characters are included
                    System.out.println("pangram");
                    break;
                }
            }
        }
        if(alphabetMap.keySet().size() < 26)
            System.out.println("not pangram");
    }
}