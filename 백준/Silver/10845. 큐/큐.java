import java.util.*;
import java.io.*;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int N = Integer.parseInt(br.readLine());
        List<Integer> queue = new ArrayList<>();
        
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            
            myQueue(queue, st.nextToken());
        }
        
        System.out.print(sb);
    }
    
    public static void myQueue(List<Integer> queue, String cmd) {
        
        if (cmd.equals("push")) {
            
            int value = Integer.parseInt(st.nextToken());
            queue.add(value);
        } else if (cmd.equals("pop")) {
            
            if (queue.size() > 0) {
                sb.append(queue.get(0)).append('\n');
                queue.remove(0);
            } else {
                sb.append(-1).append('\n');
            }
        } else if (cmd.equals("size")) {
            
            sb.append(queue.size()).append('\n');
        } else if (cmd.equals("empty")) {
            
            if (queue.isEmpty()) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        } else if (cmd.equals("back")) {
            
            if (queue.size() > 0) {
                sb.append(queue.get(queue.size() - 1)).append('\n');
            } else {
                sb.append(-1).append('\n');
            }
        } else {
            
            if (queue.size() > 0) {
                sb.append(queue.get(0)).append('\n');
            } else {
                sb.append(-1).append('\n');
            }
        }
    }
}