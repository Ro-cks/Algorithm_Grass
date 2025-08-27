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
	static int answer;
	static List<Micro> micros;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	private static class Micro implements Comparable<Micro> {
		int r;
		int c;
		int pop;
		int dir;
		
		public Micro(int r, int c, int pop, int dir) {
			this.r = r;
			this.c = c;
			this.pop = pop;
			this.dir = dir - 1;
		}
		
		public void changeDir() {
			switch (dir) {
				case 0:
					dir = 1;
					break;
				case 1:
					dir = 0;
					break;
				case 2:
					dir = 3;
					break;
				default:
					dir = 2;
			}
		}
		
		public void move() {
			r += dr[dir];
			c += dc[dir];
		}
		
		public void crush() {
			pop /= 2;
			
			changeDir();
		}
		
		@Override
		public int compareTo(Micro m) {
			
			return Integer.compare(m.pop, this.pop);
		}
	}
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			solution();
			
			sb.append('#').append(tc).append(' ').append(answer).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void solution() {
		for (int time = 0; time < M; ++time) {
			
			for (Micro micro : micros) {
				micro.move();
			}
			
			List<Micro>[][] map = new ArrayList[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    map[i][j] = new ArrayList<>();
                }
            }

            for (Micro micro : micros) {
                map[micro.r][micro.c].add(micro);
            }
            
            List<Micro> nextMicros = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j].isEmpty()) continue;

                    // 경계 처리
                    if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
                        Micro micro = map[i][j].get(0); // 경계에는 하나만 있거나, 합쳐지기 전 여러개가 있을 수 있지만, 문제 조건상 하나씩 처리됨
                        micro.crush();
                        if (micro.pop > 0) {
                            nextMicros.add(micro);
                        }
                    }
                    // 병합 처리
                    else if (map[i][j].size() > 1) {
                        Collections.sort(map[i][j]); // pop 기준으로 내림차순 정렬
                        
                        Micro dominant = map[i][j].get(0);
                        int totalPop = 0;
                        for(Micro m : map[i][j]){
                            totalPop += m.pop;
                        }
                        dominant.pop = totalPop;
                        nextMicros.add(dominant);
                    }
                    // 단일 군집
                    else {
                        nextMicros.add(map[i][j].get(0));
                    }
                }
            }
            micros = nextMicros;
		}
		
        for (Micro micro : micros) {
            answer += micro.pop;
        }
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = 0;
		micros = new ArrayList<>();
		
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine().trim());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int pop = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			micros.add(new Micro(r, c, pop, dir));
		}
	}
}
