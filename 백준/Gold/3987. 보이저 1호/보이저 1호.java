import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int PR;
    static int PC;
    static int distance;
    static String answer;
    static String[] dirs;
    static int[] distances;
    static char[][] map;

    static final String VOYAGER = "Voyager";

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] changeDir = {
            {1, 0, 3, 2},
            {3, 2, 1, 0}
    };

    static class Point {
        int r;
        int c;
        int way;
        int dist;

        public Point(int r, int c, int way, int dist) {
            this.r = r;
            this.c = c;
            this.way = way;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        solution();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; ++i) {
            String input = br.readLine().trim();

            for (int j = 0; j < M; ++j) {
                map[i][j] = input.charAt(j);
            }
        }

        st = new StringTokenizer(br.readLine().trim());
        PR = Integer.parseInt(st.nextToken()) - 1;
        PC = Integer.parseInt(st.nextToken()) - 1;

        distance = 0;
        dirs = new String[] {"U", "R", "D", "L"};
        distances = new int[4];
    }

    static void solution() {
        for (int i = 0; i < 4; ++i) {
            bfs(i);
        }

        for (int i = 0; i < 4; ++i) {
            if (distances[i] > distance) {
                distance = distances[i];
                answer = dirs[i];
            }
        }

        System.out.println(answer);
        System.out.print(distance);
    }

    static void bfs(int dir) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(PR, PC, dir, 1));

        while (!q.isEmpty()) {
            Point curr = q.poll();
            int cr = curr.r;
            int cc = curr.c;
            int way = curr.way;
            int dist = curr.dist;

            if (dist > N * M * 2) {
                answer = dirs[dir];

                System.out.println(answer);
                System.out.print(VOYAGER);
                System.exit(0);
            }

            if (dist > distances[dir]) {
                distances[dir] = dist;
            }

            int nr = cr + dr[way];
            int nc = cc + dc[way];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if (map[nr][nc] == 'C') continue;

            if (map[nr][nc] == '/') {
                way = changeDir[0][way];
            }

            if (map[nr][nc] == '\\') {
                way = changeDir[1][way];
            }

            q.offer(new Point(nr, nc, way, dist + 1));
        }
    }
}
