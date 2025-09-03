import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine().trim());
        
        int[] func = new int[N + 2];
        func[0] = 0;
        func[1] = 1;
        func[2] = 2;
        
        for (int i = 3; i <= N; ++i) {
            func[i] = (func[i - 1] + func[i - 2]) % 10007;
        }
        
        System.out.print(func[N]);
    }
}