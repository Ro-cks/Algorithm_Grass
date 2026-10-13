import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int count = 0;
        boolean preMinus = false;

        for (int n = 0; n < N; ++n) {
            int input = Integer.parseInt(br.readLine());
            boolean isMinus = input < 0;

            if (n > 0 && isMinus == preMinus) {
                ++count;
            } else {
                count = 1;          // 첫 원소이거나 부호가 바뀜
            }
            preMinus = isMinus;
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}
