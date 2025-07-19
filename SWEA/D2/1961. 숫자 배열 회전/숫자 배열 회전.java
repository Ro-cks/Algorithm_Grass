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
            for (int i = 0; i < n; ++i) { // matrix rotate
                for (int j = n - 1; j >= 0; --j) {
                    deg90Matrix[j][n - 1 - i] = matrix[i][j];
                }
            }
            
            int[][] deg180Matrix = new int[n][n];
            for (int i = 0; i < n; ++i) { // matrix rotate
                for (int j = n - 1; j >= 0; --j) {
                    deg180Matrix[j][n - 1 - i] = deg90Matrix[i][j];
                }
            }
            
            int[][] deg270Matrix = new int[n][n];
            for (int i = 0; i < n; ++i) { // matrix rotate
                for (int j = n - 1; j >= 0; --j) {
                    deg270Matrix[j][n - 1 - i] = deg180Matrix[i][j];
                }
            }
            
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
}