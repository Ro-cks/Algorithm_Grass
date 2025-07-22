import java.util.*;
import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            int num = Integer.parseInt(st.nextToken());
            if (map.containsKey(num)) {
                int value = map.get(num);
                map.replace(num, ++value);
            } else {
                map.put(num, 1);
            }
        }
        
        int M = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; ++i) {
            int key = Integer.parseInt(st.nextToken());
            
            if (map.containsKey(key)) {
                sb.append(map.get(key)).append(' ');
            } else {
                sb.append(0).append(' ');
            }
        }
        
        System.out.print(sb);
    }
}