import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T;
	static int winCase;
	static int loseCase;
	static int[] cards;
	static int[] insCards;
	static int[] sequence;
	static boolean[] visited;
	static boolean[] selected;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; ++tc) {
			init();
			
			dfs(0);
			
			sb.append('#').append(tc).append(' ').append(winCase).append(' ').append(loseCase).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void dfs(int depth) {
		if (depth == 9) {
			int iny = 0;
			int gyu = 0;
			
			for (int i = 0; i < 9; ++i) {
				int ins = sequence[i];
				int gyus = cards[i];
				
				if (ins > gyus) {
					iny += ins + gyus;
				} else {
					gyu += ins + gyus;
				}
			}
			
			if (gyu > iny) {
				++winCase;
			} else if (iny > gyu) {
				++loseCase;
			}
			
			return;
		}
		
		for (int i = 0; i < 9; ++i) {
			if (visited[i]) {
				
				continue;
			}
				
			sequence[depth] = insCards[i];
			visited[i] = true;
			dfs(depth + 1);
			visited[i] = false;
		}
	}
	
	static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		
		winCase = 0;
		loseCase = 0;
		
		cards = new int[9];
		insCards = new int[9];
		sequence = new int[9];
		visited = new boolean[9];
		selected = new boolean[19];
		
		for (int i = 0; i < 9; ++i) {
			int val = Integer.parseInt(st.nextToken());
			cards[i] = val;
			selected[val] = true;
		}
		
		int idx = 1;
		for (int i = 0; i < 9; ++i) {
			for (int j = idx; j <= 18; ++j) {
				if (!selected[j]) {
					insCards[i] = j;
					idx = j + 1;
					
					break;
				}
			}
		}
	}
}
