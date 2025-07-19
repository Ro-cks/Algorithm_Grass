import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int girl = Integer.parseInt(st.nextToken());
        int boy = Integer.parseInt(st.nextToken());
        int intern = Integer.parseInt(st.nextToken());
        
        int[] cases = new int[3];
        cases[0] = girl / 2;
        cases[1] = boy;
        cases[2] = (girl + boy - intern) / 3;
        
        Arrays.sort(cases);
        
        System.out.println(cases[0]);
    }
}