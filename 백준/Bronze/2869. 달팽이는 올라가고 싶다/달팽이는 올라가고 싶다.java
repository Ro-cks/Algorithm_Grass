import java.util.*;
import java.io.*;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        System.out.println(calDay(A, B, V));
    }
    
    public static int calDay(int A, int B, int V) {
        
        int day = (V - B) / (A - B);
        
        if ((V - B) % (A - B) != 0) {
            ++day;
        }
        
        return day;
    }
}