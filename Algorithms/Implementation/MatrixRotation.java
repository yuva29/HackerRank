import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        try(BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            String configParameters[] = input.readLine().split(" ");
            int M = Integer.parseInt(configParameters[0]);
            int N = Integer.parseInt(configParameters[1]);
            int R = Integer.parseInt(configParameters[2]);
            int output[][] = new int[M][N];
            
            int mat[][]  = new int[M][N];
            for(int i = 0; i<M; i++) {
                String tempInput[] = input.readLine().split(" ");
                for(int j = 0; j<N; j++)
                   mat[i][j] = Integer.parseInt(tempInput[j]);
            }
            
            int numInnerSqs = Math.min(M, N)/2;
            
            // process input
            int tempI =  0;
            int tempJ = 0;
            int tempM = M;
            int tempN = N;
            while(numInnerSqs > 0) {
                int startI = tempI;
                int startJ = tempJ;
                int dummyR = R;
                if(0 != ( (tempM * 2) + (tempN - 2) * 2) )
                    dummyR = R % ((tempM*2) + (tempN - 2) * 2);
                //System.out.println("R :" + R);
                int tempR = dummyR;
                while(tempR > 0) {
                    if(tempI == startI && tempJ == N-1)
                        tempJ--;
                    else if(tempJ == N-1)
                        tempI--;
                    else if(tempI == M-1)
                        tempJ++;
                    else if(tempJ == startJ)
                        tempI++;     
                    else
                        tempJ--;
                   tempR--;
                }
                
                // form Q of layer elements
                Queue<Integer> queue = new LinkedList<Integer>();
                for(int i = startI; i<M; i++)
                    queue.add(mat[i][startJ]);
                for(int j = startJ+1; j<N; j++)
                    queue.add(mat[M-1][j]);
                for(int i = M-2; i>=startI; i--)
                    queue.add(mat[i][N-1]);
                for(int j = N-2; j>startJ; j--)
                    queue.add(mat[startI][j]);
                
               // System.out.println("Queue elements");
                for(Integer i : queue) {
                    mat[tempI][tempJ] = i;
                    if(tempI == M-1 && tempJ == N-1)
                        tempI--;
                    else if(tempI == startI && tempJ == N-1)
                        tempJ--;
                    else if(tempI == M-1 && tempJ == startJ)
                        tempJ++;
                    else if(tempI == startI && tempJ == startJ)
                        tempI++;
                    else if(tempI == M-1)
                        tempJ++;
                    else if(tempI == startI)
                        tempJ--;
                    else if(tempJ == N-1) // last col of first row
                        tempI--;
                    else if(tempJ == startJ)
                        tempI++;
                    else if(tempI<M-1)
                        tempI++;                     
                }

                numInnerSqs--;
                tempI = startI + 1;
                tempJ = startJ + 1;
                M = M-1;
                N = N-1;
                tempM = tempM-2;
                tempN = tempN-2;
                //System.out.println(tempI+","+tempJ + ":" +M+","+N);
            }
            printOutput(mat, mat.length, mat[0].length);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void printOutput(int[][] output, int M, int N){
        for(int i = 0; i<M; i++){
            for(int j = 0; j<N; j++) {
                System.out.print(output[i][j]+" ");
            }
            System.out.println();
        }
    }
}