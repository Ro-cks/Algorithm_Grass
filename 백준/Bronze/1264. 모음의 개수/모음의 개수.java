import java.io.*;
import java.util.*;

public class Main {
    static Set<Character> VOWELS = new HashSet<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        VOWELS.add('A');
        VOWELS.add('I');
        VOWELS.add('O');
        VOWELS.add('E');
        VOWELS.add('U');
        
        while (true) {
            String input = br.readLine().toUpperCase();
            if (input.equals("#")) break;
            int count = 0;
            
            for (char ch : input.toCharArray()) {
                if (VOWELS.contains(ch)) ++count;
            }
            
            sb.append(count).append('\n');
        }
        
        System.out.print(sb.toString());
    }
}