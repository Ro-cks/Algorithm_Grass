import java.io.*;
import java.util.*;
import java.math.BigDecimal;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static BigDecimal A;
	static BigDecimal B;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		A = new BigDecimal(st.nextToken());
		B = new BigDecimal(st.nextToken());
		
		System.out.print(A.add(B));
	}
}
