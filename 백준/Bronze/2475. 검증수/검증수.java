import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        
        while (st.hasMoreTokens()) {
            answer += Math.pow(Integer.parseInt(st.nextToken()), 2);
        }
        
        System.out.println(answer % 10);
    }
}