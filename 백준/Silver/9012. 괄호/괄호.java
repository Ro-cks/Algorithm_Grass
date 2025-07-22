import java.util.*;
import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        
        for (int testCase = 1; testCase <= T; ++testCase) {
            String paren = br.readLine();
            
            int count = 0;
            
            for (char ch : paren.toCharArray()) {
                if (ch == '(') {
                    ++count;
                } else {
                    --count;
                    if (count < 0) break;
                }
            }
            
            if (count == 0) {
                sb.append("YES").append('\n');
            } else {
                sb.append("NO").append('\n');
            }
        }
        
        System.out.print(sb);
    }
}