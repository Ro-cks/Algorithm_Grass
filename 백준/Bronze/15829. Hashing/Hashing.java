import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final int M = 1234567891;
        final int r = 31;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        
        long answer = 0;
        long pow = 1;
        for (char ch : str.toCharArray()) {
            answer = (answer + (ch - 'a' + 1) * pow % M) % M;
            pow = pow * r % M;
        }
        
        System.out.println(answer);
    }
}