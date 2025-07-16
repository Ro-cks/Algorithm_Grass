import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int answer = 0;
        
        for (int i = 0; i < input; ++i) {
            int value = i;
            int sum = 0;
            
            while (value > 0) {
                sum += value % 10;
                value /= 10;
            }
            
            if (sum + i == input) {
                answer = i;
                
                break;
            }
        }
        
        System.out.println(answer);
    }
}