import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int T;
	static int N;
	static int peopleCnt;
	static int answer;
	static boolean[] selected;
	static int[][] map;
	static PriorityQueue<Person> moving;

	static Stair[] stairs;
	static Person[] people;

	static class Person implements Comparable<Person> {
		int r;
		int c;
		int dist;
		int height;
		int stairNum;
		int waitingNum;
		boolean isWait = false;
		boolean isDown = false;

		public Person(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public Person(Person original) {
			this.r = original.r;
			this.c = original.c;
		}

		@Override
		public int compareTo(Person p) {

			return Integer.compare(this.dist, p.dist);
		}
	}

	static class Stair {
		int r;
		int c;
		int height;

		public Stair(int r, int c, int height) {
			this.r = r;
			this.c = c;
			this.height = height;
		}
	}

	static class Timer {
		int dist;
		int height;

		public Timer(int dist, int height) {
			this.dist = dist;
			this.height = height;
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

	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		people = new Person[10];
		stairs = new Stair[2];
		answer = Integer.MAX_VALUE;
		peopleCnt = 0;
		int stairCnt = 0;

		moving = new PriorityQueue<>();

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine().trim());

			for (int j = 0; j < N; ++j) {
				int val = Integer.parseInt(st.nextToken());
				map[i][j] = val;

				if (val == 1) {
					people[peopleCnt++] = new Person(i, j);
				} else if (val > 1) {
					stairs[stairCnt++] = new Stair(i, j, val);
				}
			}
		}

		selected = new boolean[peopleCnt];
	}

	static void solution() {
		subset(0);
	}

	static void subset(int depth) {
		if (depth == peopleCnt) {
			answer = Math.min(answer, calTime());

			return;
		}

		selected[depth] = true;
		subset(depth + 1);
		selected[depth] = false;
		subset(depth + 1);
	}

	/* 총 시간 = 계단 입구까지 이동 + 마지막 사람이 계단을 다 내려간 시점의 소요 시간
	 * */
	static int calTime() {
		// TODO: selected index로 people 배열에서 사람 가져오기, stairs 배열과 매칭
		int waitingNum = 0;

		moving = new PriorityQueue<>();
		for (int i = 0; i < peopleCnt; ++i) {
			Person clone = new Person(people[i]);

			if (selected[i]) {
				int dist = calDist(clone, stairs[0]);
				clone.dist = dist;
				clone.height = stairs[0].height + 1;
				clone.stairNum = 0;
				clone.waitingNum = waitingNum++;
				moving.offer(clone);
			} else {
				int dist = calDist(clone, stairs[1]);
				clone.dist = dist;
				clone.height = stairs[1].height + 1;
				clone.stairNum = 1;
				clone.waitingNum = waitingNum++;
				moving.offer(clone);
			}
		}

		return goDown();
	}

	static int calDist(Person p, Stair s) {

		return Math.abs(p.r - s.r) + Math.abs(p.c - s.c);
	}

	static int goDown() {
		int time = 0;
		int oneSize = 0; // 1번 계단을 내려가고 있는 사람 수
		int twoSize = 0; // 2번 계단을 내려가고 있는 사람 수

		PriorityQueue<Person> firstTmp = new PriorityQueue<>();
		PriorityQueue<Person> secondTmp = new PriorityQueue<>();

		while (!moving.isEmpty()) {
			Person p = moving.poll();

			if (p.stairNum == 0) {
				firstTmp.offer(p);
			} else {
				secondTmp.offer(p);
			}
		}

		while (!firstTmp.isEmpty() || !secondTmp.isEmpty()) {
			//System.out.println(time + "분 후");
			
			while (!firstTmp.isEmpty()) {
				moving.offer(firstTmp.poll());
			}

			while (!secondTmp.isEmpty()) {
				moving.offer(secondTmp.poll());
			}

			while (!moving.isEmpty()) {
				Person p = moving.poll();
				
				// 내려가는 중인 사람이 아니면
				if (!p.isWait) {
					--p.dist;
					
					if (p.dist <= 0) {
						p.isWait = true;
						//System.out.printf("%d번 사람이 %d번 계단 입구 도착%n", p.waitingNum, p.stairNum);
					}
					
					if (p.stairNum == 0) {
						firstTmp.offer(p);
					} else {
						secondTmp.offer(p);
					}
					
					continue;
				}

				// 계단 입구에 도착, 내려가는 상태가 아닌 사람이면
				if (p.isWait && !p.isDown) {
					// 계단에 자리가 있으면
					if (p.stairNum == 0 && oneSize < 3) {
						++oneSize;

						p.isDown = true;
						//System.out.printf("%d번 사람이 %d번 계단을 내려가기 시작%n", p.waitingNum, p.stairNum);
						--p.height;
						
						firstTmp.offer(p);
					// 계단에 자리가 있으면
					} else if (p.stairNum == 1 && twoSize < 3) {
						++twoSize;

						p.isDown = true;
						--p.height;
						
						secondTmp.offer(p);
					// 자리 없으면
					} else {
						// --p.dist;
						
						if (p.stairNum == 0) {
							firstTmp.offer(p);
						} else {
							secondTmp.offer(p);
						}
					}

					continue;
				}

				// 내려가는 중이던 사람이면
				if (p.isDown) {
					--p.height;

					if (p.height == 0) {
						//System.out.printf("%d번 사람이 이동 완료%n", p.waitingNum);
						if (p.stairNum == 0) {
							--oneSize;
							
							if (!firstTmp.isEmpty() && firstTmp.peek().isWait && !firstTmp.peek().isDown) {
								moving.offer(firstTmp.poll());
							}
						} else {
							--twoSize;
							
							if (!secondTmp.isEmpty() && secondTmp.peek().isWait && !secondTmp.peek().isDown) {
								moving.offer(secondTmp.poll());
							}
						}
						
						
					// 아직 다 안 내려갔으면 큐에 추가
					} else {
						if (p.stairNum == 0) {
							firstTmp.offer(p);
						} else {
							secondTmp.offer(p);
						}
					}
				}
			}

			++time;
			//System.out.println("=========================");
		}

		return time;
	}
}