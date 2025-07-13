import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> lengths = new ArrayList<>(3);
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lengths.clear();
            
            for (int i = 0; i < 3; ++i) {
                lengths.add(Integer.parseInt(st.nextToken()));
            }
            
            if (lengths.get(0) == 0 && lengths.get(1) == 0 && lengths.get(2) == 0) {
                break;
            }
            
            Collections.sort(lengths);
            
            if (Math.pow(lengths.get(0), 2) + Math.pow(lengths.get(1), 2) 
                    == Math.pow(lengths.get(2), 2)) {
                bw.write("right\n");
            } else {
                bw.write("wrong\n");
            }
        }
        
        bw.flush();
        bw.close();
    }
}