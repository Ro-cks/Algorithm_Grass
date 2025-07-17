import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int testCase = 0; testCase < T; ++testCase) {
            String str = br.readLine();
            
            System.out.println(str.charAt(0) + "" + str.charAt(str.length() - 1));
        }
    }
}