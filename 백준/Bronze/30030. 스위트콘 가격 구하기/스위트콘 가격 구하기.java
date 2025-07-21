import java.util.*;
import java.io.*;

public class Main {
    
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        int B = Integer.parseInt(br.readLine());
        
        System.out.println(B * 10 / 11);
    }
}