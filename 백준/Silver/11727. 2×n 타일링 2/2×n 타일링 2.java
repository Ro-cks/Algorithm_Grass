import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine().trim());
		
		int[] func = new int[n + 2];
		func[0] = 0;
		func[1] = 1;
		func[2] = 3;
		
		for (int i = 3; i <= n; ++i) {
			func[i] = (2 * func[i - 2] + func[i - 1]) % 10007;
		}
		
		System.out.print(func[n]);
	}
}
