import java.util.*;
import java.io.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		String can = br.readLine();
		String need = br.readLine();
		
		if (can.length() >= need.length()) {
			System.out.println("go");
		} else {
			System.out.println("no");
		}
	}
}
