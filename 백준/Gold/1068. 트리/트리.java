import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int root;
	static int deleteNode;
	static int answer;
	static List<Integer>[] tree;
	
	public static void main(String[] args) throws IOException {
		init();
		
		solution();
	}
	
	static void init() throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		answer = 0;
		
		tree = new ArrayList[N];
		for (int i = 0; i < N; ++i) {
			tree[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; ++i) {
			int num = Integer.parseInt(st.nextToken());
			
			if (num == -1) {
				root = i;
			} else {
				tree[num].add(i);
			}			
		}
		
		deleteNode = Integer.parseInt(br.readLine().trim());
	}
	
	static void solution() {
		if (deleteNode == root) {
			System.out.print(0);
			
			return;
		}
		
		dfs(root);
		
		System.out.print(answer);
	}
	
	static void dfs(int node) {
		boolean isLeaf = true;
		
		for (int child : tree[node]) {
			if (child == deleteNode) continue;
			
			isLeaf = false;
			dfs(child);
		}
		
		if (isLeaf) {
			++answer;
		}
	}
}
