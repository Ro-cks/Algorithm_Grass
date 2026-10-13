import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        int count = 0;
        int preInput = -1;

        for (int n = 0; n < N; ++n) {
            int input = Integer.parseInt(br.readLine());

            if (n > 0 && preInput == input) {
                ++count;
            } else {
                count = 1;
            }

            preInput = input;
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}