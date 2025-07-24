import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine()) - 4;
		
		// 2, 5, 5, 4, 5, 6, 3, 7, 6, 6
		Map<Integer, Integer> numbers = new HashMap<Integer, Integer>() {{
			put(0, 6);
			put(1, 2);
			put(2, 5);
			put(3, 5);
			put(4, 4);
			put(5, 5);
			put(6, 6);
			put(7, 3);
			put(8, 7);
			put(9, 6);
		}};
		
        boolean isPossible = false;
		A: for (int i = 0; i < 10; ++i) {
			for (int j = 0; j < 10; ++j) {
				for (int k = 0; k < 10; ++k) {
					for (int l = 0; l < 10; ++l) {
						for (int m = 0; m < 10; ++m) {
							for (int n = 0; n < 10; ++n) {
								if (numbers.get(i) + numbers.get(j) + 
										numbers.get(k) + numbers.get(l) + 
										numbers.get(m) + numbers.get(n) == N) {
									if ((i * 10 + j) + (k * 10 + l) == (m * 10 + n)) {
										System.out.printf("%d%d+%d%d=%d%d", i, j, k, l, m, n);
                                        isPossible = true;
										break A;
									}
								}
							}
						}
					}
				}
			}
		}
        
        if (!isPossible) {
            System.out.print("impossible");
        }
	}
}
