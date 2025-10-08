import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		sb.append("    8888888888  888    88888").append('\n');
		sb.append("   88     88   88 88   88  88").append('\n');
		sb.append("    8888  88  88   88  88888").append('\n');
		sb.append("       88 88 888888888 88   88").append('\n');
		sb.append("88888888  88 88     88 88    888888").append('\n');
		sb.append('\n');
		sb.append("88  88  88   888    88888    888888\n" + 
				"88  88  88  88 88   88  88  88\n" + 
				"88 8888 88 88   88  88888    8888\n" + 
				" 888  888 888888888 88  88      88\n" + 
				"  88  88  88     88 88   88888888");
		
		System.out.print(sb);
	}
}
