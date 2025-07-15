import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String S = br.readLine();
        int[] alphabet = new int[26];
        boolean[] isVisited = new boolean[26];
        
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            
            if (!isVisited[ch - 97]) {
                alphabet[ch - 97] = i;
                isVisited[ch - 97] = true;
            }
        }

        for (int i = 0; i < alphabet.length; ++i) {
            if (isVisited[i]) {
                System.out.print(alphabet[i] + " ");
            } else {
                System.out.print("-1 ");
            }
        }
    }
}