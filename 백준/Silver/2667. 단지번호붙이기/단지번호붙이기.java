import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static ArrayList<Integer> counts = new ArrayList<>();
    static int houseCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0'; // 문자 '1'을 숫자 1로 변환
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    houseCount = 0; // 새로운 단지 시작
                    DFS(i, j);
                    counts.add(houseCount); // 단지 내 집 개수 저장
                }
            }
        }

        Collections.sort(counts); // 단지별 집 개수 오름차순 정렬
        System.out.println(counts.size()); // 총 단지 수
        for (int count : counts) {
            System.out.println(count); // 각 단지 내 집 개수
        }
    }

    static void DFS(int r, int c) {
        // 범위를 벗어나거나 집이 아니면 종료
        if (r < 0 || r >= N || c < 0 || c >= N || map[r][c] != 1) {
            return;
        }

        map[r][c] = 0; // 방문한 집은 0으로 표시 (방문 처리)
        houseCount++;

        // 상, 하, 좌, 우 인접한 집 탐색
        for (int d = 0; d < 4; d++) {
            DFS(r + dr[d], c + dc[d]);
        }
    }
}