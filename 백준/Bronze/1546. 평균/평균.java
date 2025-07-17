import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; ++i) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(scores);
        
        Double epsilon = 1E-5;
        double answer = 0;
        int max = scores[N - 1];
        
        for (int i = 0; i < N; ++i) {
            answer += (double)scores[i] / max * 100 - epsilon;
        }
        
        System.out.println(answer / N);
    }
}