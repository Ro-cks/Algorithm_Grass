import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        String cmds = br.readLine();

        int[][] map = new int[N][N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int r = N / 2;
        int c = N / 2;
        int d = 0;
        int answer = map[r][c];
        for (int i = 0; i < cmds.length(); ++i) {
            char cmd = cmds.charAt(i);

            if (cmd == 'L') {
                d = (d + 4 - 1) % 4;
            } else if (cmd == 'R') {
                d = (d + 1) % 4;
            } else {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (!inRange(N, nr, nc)) continue;

                r = nr;
                c = nc;
                answer += map[r][c];
            }
        }

        System.out.println(answer);
    }

    private static boolean inRange(int N, int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}