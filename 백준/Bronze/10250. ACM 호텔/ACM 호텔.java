import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 0; test_case < T; ++test_case) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int floor = n % height;
            int room = n / height + 1;
            
            if (floor == 0) {
                floor = height;
                room = n / height;
            }
            
            int answer = floor * 100 + room;
            
            bw.write(String.valueOf(answer) + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}