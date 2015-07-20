import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        try(BufferedReader input = new BufferedReader(new InputStreamReader(System.in))){
            int numTestCases = Integer.parseInt(input.readLine());
            assert numTestCases >= 1 && numTestCases <= 5;
            ArrayList<String> grid;
            ArrayList<String> pattern;

            for(int t = 0; t < numTestCases; t++) {
                grid = solution.buildArrayList(input); 
                pattern = solution.buildArrayList(input);
                if(solution.findPattern(grid, pattern)){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
            
        }
    
        public boolean findPattern(ArrayList<String> grid, ArrayList<String> pattern) {
            int startRow = 0;
            int i = 0;
            boolean foundPattern = false;
            while(startRow < grid.size()) {                
                for(i = startRow; i<grid.size(); i++) { // Search for first row that matches pattern's first row                
                    if(-1 != grid.get(i).indexOf(pattern.get(0))) // Once the first row of pattern matches with grid row, break 
                        break;
                    startRow++;
                }
                if(startRow >= grid.size()) return false; // all gird rows are examined for pattern
                int startIndex = grid.get(startRow).indexOf(pattern.get(0)); // get the index where pattern starts in grid, this index should be same for all pattern rows.
                while(startIndex < grid.get(0).length()) {
                    int tempStartRow = startRow;
                    for(int j = 1; j<pattern.size(); j++) { // check all the remaining pattern rows in grid
                        if(startIndex!= grid.get(++tempStartRow).indexOf(pattern.get(j))) {  
                           break;
                        }
                        if(j == pattern.size()-1) // all pattern rows has been checked, grid contains pattern
                            return true;
                    }
                    startIndex = grid.get(startRow).indexOf(pattern.get(0), startIndex+1); // start looking from the next col in  earlier matched grid row
                    if(-1 == startIndex) 
                        break;
                }                
                i = ++startRow; // start looking from next row in grid
            }
            return false;
        }
    
        // Helper method to construct input array list
        public ArrayList<String> buildArrayList(BufferedReader input) throws IOException {
            String[] sizeParameters = input.readLine().split(" ");
            int rows = Integer.parseInt(sizeParameters[0]);
            int columns = Integer.parseInt(sizeParameters[1]);
            ArrayList<String> array = new ArrayList<String>();

            for(int i = 0; i < rows; i++){
                String rowOfNumbers = input.readLine();
                array.add(rowOfNumbers);
            }

            return array;
        }
   
}