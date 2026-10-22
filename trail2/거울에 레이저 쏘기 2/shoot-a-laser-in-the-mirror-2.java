import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        for (int i = 0; i < N; ++i) {
            String input = br.readLine();
            
            for (int j = 0; j < N; ++j) {
                map[i][j] = input.charAt(j);
            }
        }

        int K = Integer.parseInt(br.readLine());
        int side = (K - 1) / N;
        int idx = (K - 1) % N;
        int r, c, d;
        
        switch (side) {
            case 0:  r = 0;           c = idx;         d = 2; break;
            case 1:  r = idx;         c = N - 1;       d = 3; break;
            case 2:  r = N - 1;       c = N - 1 - idx; d = 0; break;
            default: r = N - 1 - idx; c = 0;           d = 1; break;
        }

        int count = 0;
        while (isValidPosition(N, r, c)) {
            ++count;
            d = (map[r][c] == '/') ? (d ^ 1) : (3 - d);
            r += dr[d];
            c += dc[d];
        }

        System.out.println(count);
    }

    private static boolean isValidPosition(int N, int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}