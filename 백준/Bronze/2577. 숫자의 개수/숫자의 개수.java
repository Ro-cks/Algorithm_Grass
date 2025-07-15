import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] answer = new int[10];
        int num = 1;
        
        for (int i = 0; i < 3; ++i) {
            num *= Integer.parseInt(br.readLine());
        }
        
        while (num > 0) {
            ++answer[num % 10];
            num /= 10;
        }
        
        for (int i = 0; i < 10; ++i) {
            bw.write(String.valueOf(answer[i]) + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}