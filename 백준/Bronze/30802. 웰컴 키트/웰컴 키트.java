import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sizes = new int[6];
        
        for (int i = 0; i < 6; ++i) {
            sizes[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        int answerT = 0;
        int answerP = 0;
        int oneP = 0;
        
        for (int i = 0; i < 6; ++i) {
            answerT += Math.ceil(sizes[i] / (double)T);
        }
        
        answerP = N / P;
        oneP = N % P;
        
        System.out.println(answerT);
        System.out.println(answerP + " " + oneP);
    }
}