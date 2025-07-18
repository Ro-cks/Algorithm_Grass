import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String input = br.readLine();
        
        for (char ch : input.toCharArray()) {
            int val = 'a' - 'A';
            if (ch < 97) { // 대문자일 때
                sb.append((char) (ch + val));
            } else { // 소문자일 때
                sb.append((char) (ch - val));
            }
        }
        
        System.out.println(sb.toString());
    }
}