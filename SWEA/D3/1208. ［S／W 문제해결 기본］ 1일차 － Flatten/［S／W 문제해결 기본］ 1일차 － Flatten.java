import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int WIDTH = 100;
        
        for (int tc = 1; tc <= 10; ++tc) {
            int dump = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int[] heights = new int[WIDTH];
            for (int i = 0; i < WIDTH; ++i) {
                heights[i] = Integer.parseInt(st.nextToken());
            }
            
            for (int i = 0; i < dump; ++i) {
                int maxIdx = findMaxIndex(heights);
                int minIdx = findMinIndex(heights);
                
                --heights[maxIdx];
                ++heights[minIdx];
            }
            
            int max = heights[findMaxIndex(heights)];
            int min = heights[findMinIndex(heights)];
            
            bw.write("#" + tc + " " + (max - min) + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    static int findMaxIndex(int[] heights) {
        int max = heights[0];
        int idx = 0;
        
        for (int i = 1; i < heights.length; ++i) {
            if (heights[i] > max) {
                max = heights[i];
                idx = i;
            }
        }
        
        return idx;
    }
    
    static int findMinIndex(int[] heights) {
        int min = heights[0];
        int idx = 0;
        
        for (int i = 1; i < heights.length; ++i) {
            if (heights[i] < min) {
                min = heights[i];
                idx = i;
            }
        }
        
        return idx;
    }
}