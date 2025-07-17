import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while (true) {
            String input = br.readLine();
            if (input.equals("0")) break;
            
            boolean isPalindrome = true;
            int length = input.length();
            
            for (int i = 0; i < length / 2; ++i) {
                if (input.charAt(i) != input.charAt(length - 1 - i)) {
                    bw.write("no\n");
                    isPalindrome = false;
                    
                    break;
                }
            }
            
            if (isPalindrome) {
                bw.write("yes\n");
            }
        }
        
        bw.flush();
        bw.close();
    }
}