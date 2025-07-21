import java.util.*;
import java.io.*;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        int N = Integer.parseInt(br.readLine());
        List<Integer> stack = new ArrayList<>();
        
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            
            myStack(stack, st.nextToken());
        }
        
        System.out.print(sb);
    }
    
    public static void myStack(List<Integer> stack, String cmd) {
        
        if (cmd.equals("push")) {
            
            int value = Integer.parseInt(st.nextToken());
            stack.add(value);
        } else if (cmd.equals("pop")) {
            
            if (stack.size() > 0) {
                sb.append(stack.get(stack.size() - 1)).append('\n');
                stack.remove(stack.size() - 1);
            } else {
                sb.append(-1).append('\n');
            }
        } else if (cmd.equals("size")) {
            
            sb.append(stack.size()).append('\n');
        } else if (cmd.equals("empty")) {
            
            if (stack.isEmpty()) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        } else {
            
            if (stack.size() > 0) {
                sb.append(stack.get(stack.size() - 1)).append('\n');
            } else {
                sb.append(-1).append('\n');
            }
        }
    }
}