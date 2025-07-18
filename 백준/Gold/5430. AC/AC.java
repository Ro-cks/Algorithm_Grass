import java.util.*;
import java.io.*;

public class Main {
    
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Deque<Integer> deque;
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int testCase = 0; testCase < T; ++testCase) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            
            st = new StringTokenizer(br.readLine(), "[],");
            
            deque = new ArrayDeque<Integer>();
            for (int i = 0; i < n; ++i) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            
            proc(command, deque);
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    
    public static void proc(String command, Deque<Integer> deque) {
        boolean isRight = true;
        
        for (char cmd : command.toCharArray()) {
            if (cmd == 'R') {
                isRight = !isRight;
                continue;
            }
            
            if (isRight) {
                if (deque.pollFirst() == null) {
                    sb.append("error\n");
                    
                    return;
                }
            } else {
                if (deque.pollLast() == null) {
                    sb.append("error\n");
                    
                    return;
                }
            }
        }
        
        make(deque, isRight);
    }
    
    public static void make(Deque<Integer> deque, boolean isRight) {
        sb.append('[');
        
        if (deque.size() > 0) {
            if (isRight) {
                sb.append(deque.pollFirst());
                
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            } else {
                sb.append(deque.pollLast());
                
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }
        
        sb.append(']').append('\n');
    }
}