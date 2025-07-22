import java.util.*;
import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        
        int[] weights = new int[N];
        int[] heights = new int[N];
        int[] ranks = new int[N];
        
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            heights[i] = Integer.parseInt(st.nextToken());
            ++ranks[i];
        }
        
        for (int i = 0; i < N - 1; ++i) {
            for (int j = i + 1; j < N; ++j) {
                if (weights[i] > weights[j] && heights[i] > heights[j]) {
                    ++ranks[j];
                } else if (weights[i] < weights[j] && heights[i] < heights[j]) {
                    ++ranks[i];
                } else {
                    continue;
                }
            }
        }
        
        for (int i = 0; i < N; ++i) {
            sb.append(ranks[i]).append(' ');
        }
        
        System.out.println(sb);
    }
}