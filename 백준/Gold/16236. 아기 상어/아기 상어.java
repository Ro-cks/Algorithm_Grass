import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] map;
    static Shark shark;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    static class Shark {
        int r;
        int c;
        int size;
        int count;
        int time;

        public Shark(int r, int c) {
            this.r = r;
            this.c = c;
            this.size = 2;
            this.count = 0;
            this.time = 0;
        }

        public void eat(Fish fish) {
            ++count;
            if (count == size) {
                ++size;
                count = 0;
            }

            map[fish.r][fish.c] = 0;

            time += fish.dist;
        }
    }

    static class Fish implements Comparable<Fish> {
        int r;
        int c;
        int dist;

        public Fish(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish f) {
            // 1. 거리(dist) 오름차순
            if (this.dist != f.dist) {
                return Integer.compare(this.dist, f.dist);
            }

            // 2. 거리가 같다면, 행(r) 오름차순 (더 위쪽)
            if (this.r != f.r) {
                return Integer.compare(this.r, f.r);
            }

            // 3. 거리와 행이 모두 같다면, 열(c) 오름차순 (더 왼쪽)
            return Integer.compare(this.c, f.c);
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        solution();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine().trim());

            for (int j = 0; j < N; ++j) {
                int val = Integer.parseInt(st.nextToken());

                map[i][j] = val;

                if (val == 9) {
                    shark = new Shark(i, j);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void solution() {
        int answer = 0;

        while (true) {
            Fish target = BFS();

            if (target == null) {

                break;
            }

            shark.eat(target);
            shark.r = target.r;
            shark.c = target.c;
        }

        answer = shark.time;

        System.out.print(answer);
    }

    static Fish BFS() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {shark.r, shark.c, 0});

        boolean[][] visited = new boolean[N][N];
        visited[shark.r][shark.c] = true;

        List<Fish> fishes = new ArrayList<>();
        // int minDistance = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cr = curr[0];
            int cc = curr[1];
            int dist = curr[2];

            // if (dist >= minDistance) continue;

            for (int d = 0; d < 4; ++d) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visited[nr][nc]) continue;

                // 상어의 크기보다 크면 이동 불가능
                if (map[nr][nc] > shark.size) continue;

                // 먹을 수 있는 물고기면
                if (map[nr][nc] > 0 && map[nr][nc] < shark.size) {
                    // minDistance = dist + 1;
                    fishes.add(new Fish(nr, nc, dist + 1));
                }

                visited[nr][nc] = true;
                q.offer(new int[] {nr, nc, dist + 1});
            }
        }

        if (fishes.isEmpty()) {
            return null;
        } else {
            Collections.sort(fishes);
            Fish fish = fishes.get(0);

            return fish;
        }
    }
}
