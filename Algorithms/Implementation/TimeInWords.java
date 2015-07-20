import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int h = in.nextInt();
        int m = in.nextInt();
        
        assert h>=1 && h<=12;
        assert m>=0 && m<60;
        
        String[] tensNames = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] numNames = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        
        if(m == 0) {
            System.out.println(numNames[h] +" o' clock");
        }else if(m == 15) {
            System.out.println("quarter past " + numNames[h]);
        } else if(m == 30) {
            System.out.println("half past " + numNames[h]);
        } else if(m == 45) {
            System.out.println("quarter to "+ numNames[h+1]);
        } else if(m > 30) {
            m = 60-m;
            handleEverythingElse(m, "to", numNames, tensNames, h+1);
        } else { //m < 30
            handleEverythingElse(m, "past", numNames, tensNames, h);
        }
    }
    public static void handleEverythingElse(int m, String keyword, String[] numNames, String[] tensNames, int h) {
        if(m <= numNames.length){
            System.out.println(numNames[m] + " minutes " + keyword +" " + numNames[h]);
        } else if( m <= tensNames.length){
            System.out.println(tensNames[m] + " minutes " + keyword + " " +numNames[h]);
        } else { // e.g. case 27
            int lastDigit =  m%10;
            int firstDigit =  m/10;
            System.out.println(tensNames[firstDigit] + " " + numNames[lastDigit] +" minutes "+ keyword + " "+ numNames[h]);
        }        
    }
}