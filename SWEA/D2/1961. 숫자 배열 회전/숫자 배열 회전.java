import java.util.*;
import java.io.*;

public class Solution {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringBuilder sb;
    public static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
                
        int T = Integer.parseInt(br.readLine());
        
        for (int testCase = 1; testCase <= T; ++testCase) {
            int n = Integer.parseInt(br.readLine());
            
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; ++i) { // matrix init
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int[][] deg90Matrix = new int[n][n];
            rotate(matrix, deg90Matrix, n);
            
            int[][] deg180Matrix = new int[n][n];
            rotate(deg90Matrix, deg180Matrix, n);
            
            int[][] deg270Matrix = new int[n][n];
            rotate(deg180Matrix, deg270Matrix, n);
            
            sb = new StringBuilder();
            
            if (testCase != 1) {
                sb.append('\n');
            }
            
            sb.append('#').append(testCase);
            
            for (int i = 0; i < n; ++i) {
                sb.append('\n');
                
                for (int j = 0; j < n; ++j) {
                    sb.append(deg90Matrix[i][j]);
                }
                
                sb.append(' ');
                
                for (int j = 0; j < n; ++j) {
                    sb.append(deg180Matrix[i][j]);
                }
                
                sb.append(' ');
                
                for (int j = 0; j < n; ++j) {
                    sb.append(deg270Matrix[i][j]);
                }
            }
            
            bw.write(sb.toString());
        }
        
        bw.flush();
        bw.close();
    }
    
    public static void rotate(int[][] matrix, int[][] newMatrix, int length) {
        for (int i = 0; i < length; ++i) { // matrix rotate
            for (int j = length - 1; j >= 0; --j) {
                newMatrix[j][length - 1 - i] = matrix[i][j];
            }
        }
    }
}