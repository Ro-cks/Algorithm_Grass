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
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[N][N];
        Queue<Point> q = new ArrayDeque<>();
        for (int i = 0; i < K; ++i) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            q.offer(new Point(r, c));
            visited[r][c] = true;
        }

        System.out.println(bfs(q, visited, map, N));
    }

    private static int bfs(Queue<Point> q, boolean[][] visited, int[][] map, int N) {
        int count = 0;

        while (!q.isEmpty()) {
            Point curr = q.poll();
            ++count;

            for (int d = 0; d < 4; ++d) {
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];
                if (!inRange(N, nr, nc) || map[nr][nc] == 1 || visited[nr][nc]) continue;

                q.offer(new Point(nr, nc));
                visited[nr][nc] = true;
            }
        }

        return count;
    }

    private static boolean inRange(int N, int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}