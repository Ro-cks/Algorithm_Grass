import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 0; test_case < T; ++test_case) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int re = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            
            for (int i = 0; i < str.length(); ++i) {
                for (int j = 0; j < re; ++j) {
                    sb.append(String.valueOf(str.charAt(i)));
                }
            }
            
            bw.write(sb.toString() + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}