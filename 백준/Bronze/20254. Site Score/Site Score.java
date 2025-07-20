import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] scores = { 56, 24, 14, 6 };
        
        int answer = 0;
        for (int i = 0; i < 4; ++i) {
            answer += scores[i] * Integer.parseInt(st.nextToken());
        }
        
        System.out.println(answer);
    }
}