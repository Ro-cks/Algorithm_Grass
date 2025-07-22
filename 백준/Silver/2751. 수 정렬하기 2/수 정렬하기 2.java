import java.util.*;
import java.io.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; ++i) {
            list.add(Integer.parseInt(br.readLine()));
        }
        
        Collections.sort(list);
        
        for (int i = 0; i < list.size(); ++i) {
            sb.append(list.get(i)).append('\n');
        }
        
        System.out.print(sb);
    }
}