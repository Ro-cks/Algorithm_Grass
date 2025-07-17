import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        
        int answer = 0;
        int digit = 0;
        for (char ch : str.toCharArray()) {
            answer += (ch - 96) * Math.pow(31, digit++);
        }
        
        System.out.println((int) (answer % 1234567891));
    }
}