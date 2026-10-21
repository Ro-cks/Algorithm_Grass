import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0};   // U R D L
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char command = st.nextToken().charAt(0);

        int d;
        switch (command) {
            case 'U': d = 0; break;
            case 'R': d = 1; break;
            case 'D': d = 2; break;
            default:  d = 3; break;   // 'L'
        }

        for (int t = 0; t < T; t++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (inRange(N, nr, nc)) {
                r = nr;
                c = nc;
            } else {
                d = (d + 2) % 4;   // 반대 방향으로 전환, 이번 초는 이동 없음
            }
        }

        System.out.println(r + " " + c);
    }

    private static boolean inRange(int N, int r, int c) {
        return 1 <= r && r <= N && 1 <= c && c <= N;
    }
}