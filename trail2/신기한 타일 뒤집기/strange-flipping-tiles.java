import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int x = 0;
        int white = 0;
        int black = 0;
        int position = 100000;
        String d;

        int[] tiles = new int[200001];
        // 1: white, 2: black

        for (int n = 0; n < N; ++n) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            d = st.nextToken();

            if (d.equals("L")) {
                for (int i = position; i > position - x; --i) {
                    tiles[i] = 1;
                }

                position = position - x + 1;
            } else {
                for (int i = position; i < position + x; ++i) {
                    tiles[i] = 2;
                }

                position = position + x - 1;
            }
        }

        for (int i = 0; i < 200001; ++i) {
            if (tiles[i] == 0) continue;

            if (tiles[i] == 1) {
                ++white;
            } else {
                ++black;
            }
        }

        System.out.println(white + " " + black);
    }
}