import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T;
    static int N;
    static int M;
    static int K;
    static int[][] map;
    static PriorityQueue<Cell> pq;
	
	static final int MAP_SIZE = 700;
	static final int MAP_CENTER = MAP_SIZE / 2 - 1;
	
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    
    private static class Cell {
    	int r;
    	int c;
    	int life;
    	int waitTime;	// 비활성 시간
    	int activeTime; // 활성 시간
    	
    	public Cell(int r, int c, int life) {
    		this.r = r;
    		this.c = c;
    		this.life = life;
    		this.waitTime = life;
    		this.activeTime = life;
    	}
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; ++tc) {
            init();

            sb.append('#').append(tc).append(' ');

            simulate();
        }

        System.out.print(sb);
    }
    
    static void init() throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.life, o2.life) * -1);
        map = new int[MAP_SIZE][MAP_SIZE];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < M; ++j) {
                int val = Integer.parseInt(st.nextToken());
                
                if (val > 0) {
                	int r = i + MAP_CENTER;
                    int c = j + MAP_CENTER;
                    map[r][c] = val; // map에 생명력 저장. 디버깅에 용이함 하하
                    pq.add(new Cell(r, c, val));
                }
            }
        }
    }

    static void simulate() {
    	
    	// K 시간 동안 시뮬레이션
        for (int time = 0; time < K; ++time) {
        	
        	Queue<Cell> tmp = new LinkedList<>();
        	while (!pq.isEmpty()) {
        		Cell cell = pq.poll();
        		
        		// 번식 시도 -> 활성, 비활성 관리 -> 생존 여부 판단 -> 번식 결과 처리
        		// 1. 번식 시도
        		if (cell.waitTime == 0) {
        			// 사방 탐색
        			for (int d = 0; d < 4; ++d) {
        				int nr = cell.r + dr[d];
        				int nc = cell.c + dc[d];
        				
        				// 번식 가능한 땅이면
        				if (map[nr][nc] == 0) {
        					
        					// 번식
        					map[nr][nc] = cell.life;
        					
        					// 임시 큐에 추가, 이 while문 밖에서 lazy하게 처리
        					tmp.offer(new Cell(nr, nc, cell.life));
        				}
        			}
        		}
        		
        		// 2. 활성 및 비활성 상태 관리
        		
        		// 비활성 상태이면 비활성 시간 감소
        		if (cell.waitTime > 0) {
        			--cell.waitTime;
        		// 활성 상태이면 활성 시간 감소
        		} else {
        			--cell.activeTime;
        		}
        		
        		// 3. 살아있으면 다시 큐에 추가
        		if (cell.activeTime > 0) {
        			tmp.offer(cell);
        		} else {
        			map[cell.r][cell.c] = -1;
        		}
        	}
        	
        	// 번식된, 생존한 세포들을 큐에 추가
        	while (!tmp.isEmpty()) {
        		pq.offer(tmp.poll());
        	}
        	
//        	System.out.println("time: " + time);
//        	for (int i = 0; i < map.length; ++i) {
//        		System.out.println(Arrays.toString(map[i]));
//        	}
//        	System.out.println("=======================");
        }

        // 활성 및 비활성 상태인 살아있는 세포 수가 답
        sb.append(pq.size()).append('\n');
    }
}