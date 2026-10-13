import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int count = 0;
        int answer = 0;
        int[] inputs = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < inputs.length; ++i) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < inputs.length; ++i) {
            if (i > 0 && inputs[i] > T) {
                ++count;
            } else {
                if (inputs[i] > T) {
                    count = 1;
                } else {
                    count = 0;
                }
            }

            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}
