import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 0; test_case < T; ++test_case) {
            int score = 0;
            int stack = 1;
            boolean flag = false;
            String OX = br.readLine();
            
            for (int i = 0; i < OX.length(); ++i) {
                if (flag) {
                    stack += 1;
                } else {
                    stack = 1;
                }
                
                if (OX.charAt(i) == 'O' && flag) {
                    score += stack;
                } else if (OX.charAt(i) == 'O'){
                    score += 1;
                    flag = true;
                } else {
                    flag = false;
                }
            }
            
            System.out.println(score);
        }
    }
}