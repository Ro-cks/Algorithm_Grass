import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] men = new int[N][3];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; ++j) {
                men[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                for (int k = 0; k < N; ++k) {
                    int str = men[i][0];
                    int dex = men[j][1];
                    int intel = men[k][2];

                    int count = 0;
                    for (int m = 0; m < N; ++m) {
                        if (men[m][0] <= str && men[m][1] <= dex && men[m][2] <= intel) {
                            ++count;
                        }
                    }

                    if (count >= K) {
                        answer = Math.min(answer, str + dex + intel);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
