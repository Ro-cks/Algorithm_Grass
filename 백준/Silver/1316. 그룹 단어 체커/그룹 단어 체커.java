import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < N; ++i) {
            if (isGroupWord(br.readLine())) ++answer;
        }

        System.out.print(answer);
    }

    private static boolean isGroupWord(String word) {
        Set<Character> set = new HashSet<>();
        char[] chars = word.toCharArray();

        char before = word.charAt(0);
        set.add(word.charAt(0));

        for (int i = 1; i < chars.length; ++i) {
            if (chars[i] == before) continue;

            before = chars[i];

            if (set.contains(chars[i])) return false;
            set.add(chars[i]);
        }

        return true;
    }
}
