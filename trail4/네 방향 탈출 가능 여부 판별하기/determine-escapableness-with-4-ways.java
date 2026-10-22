import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println((bfs(map, N, M)) ? 1 : 0);
    }

    private static boolean bfs(int[][] map, int N, int M) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Point curr = q.poll();
            if (curr.r == N - 1 && curr.c == M - 1) return true;

            for (int d = 0; d < 4; ++d) {
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];
                if (!inRange(N, M, nr, nc) || map[nr][nc] == 0) continue;
                if (visited[nr][nc]) continue;

                q.offer(new Point(nr, nc));
                visited[nr][nc] = true;
            }
        }

        return false;
    }

    private static boolean inRange(int N, int M, int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}