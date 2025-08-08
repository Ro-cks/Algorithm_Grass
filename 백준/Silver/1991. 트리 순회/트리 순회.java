import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static Map<String, Node> tree = new HashMap<>();;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			String data = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			
			tree.putIfAbsent(data, new Node(data));
			
			Node cur = tree.get(data);
			
			if (!left.equals(".")) {
				tree.putIfAbsent(left, new Node(left));
				cur.left = tree.get(left);
			}
			
			if (!right.equals(".")) {
				tree.putIfAbsent(right, new Node(right));
				cur.right = tree.get(right);
			}
		}
		
		preOrder(tree.get("A"));
		sb.append('\n');
		inOrder(tree.get("A"));
		sb.append('\n');
		postOrder(tree.get("A"));
		
		System.out.print(sb);
	}
	
	public static void preOrder(Node node) {
		if (node == null) {
			
			return;
		}
		
		sb.append(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public static void inOrder(Node node) {
		if (node == null) {
			
			return;
		}
		
		inOrder(node.left);
		sb.append(node.data);
		inOrder(node.right);
	}
	
	public static void postOrder(Node node) {
		if (node == null) {
			
			return;
		}
		
		postOrder(node.left);
		postOrder(node.right);
		sb.append(node.data);
	}
}

class Node {
	String data;
	
	Node left;
	Node right;
	
	public Node(String data) {
		this.data = data;
	}
}
