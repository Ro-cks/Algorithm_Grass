import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int intAnswer = 0;
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        
        intAnswer = A + B - C;
        sb.append(String.valueOf(A)).append(String.valueOf(B));
        int strAnswer = Integer.parseInt(sb.toString()) - C;
        
        System.out.println(intAnswer);
        System.out.println(strAnswer);
    }
}