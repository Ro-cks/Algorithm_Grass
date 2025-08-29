import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int answer;
    static int[][] map;
    static boolean[] visited;

    // 우하 -> 좌하 -> 좌상 -> 우상
    static int[][] dir = { {1, 1}, {1, -1}, {-1, -1}, {-1, 1} };

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; ++tc) {
            init();
            
            solution();
            
            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }
        
        System.out.print(sb);
    }
    
    static void init() throws IOException {
        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];
        answer = -1;
        
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // a: 첫번째, 세번째 변의 길이
                // b: 두번째, 네번째 변의 길이
                for (int a = 1; a < N; a++) {
                    for (int b = 1; b < N; b++) {
                        search(i, j, a, b);
                    }
                }
            }
        }
    }

    /**
     * 정해진 시작점과 변의 길이로 사각형 경로를 시뮬레이션하는 함수
     * @param r 시작 행
     * @param c 시작 열
     * @param a 변1, 변3의 길이
     * @param b 변2, 변4의 길이
     */
    static void search(int r, int c, int a, int b) {
        visited = new boolean[101];
        int currR = r;
        int currC = c;

        // 각 4개의 방향으로 정해진 길이(a, b)만큼 이동 시도
        for (int d = 0; d < 4; d++) {
            int len = (d % 2 == 0) ? a : b; // 0,2번 방향은 a만큼, 1,3번 방향은 b만큼

            for (int i = 0; i < len; i++) {
                currR += dir[d][0];
                currC += dir[d][1];

                // 1. 맵을 벗어나는지 확인
                if (currR < 0 || currR >= N || currC < 0 || currC >= N) {
                    return;
                }

                // 2. 이미 먹은 디저트인지 확인
                if (visited[map[currR][currC]]) {
                    return;
                }

                visited[map[currR][currC]] = true;
            }
        }
        
        // 4개 변을 모두 통과했다면 정답 갱신
        answer = Math.max(answer, 2 * (a + b));
    }
}