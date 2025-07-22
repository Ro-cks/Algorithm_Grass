import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		char[] ISBN = br.readLine().toCharArray();
		
		int index = 0;
		int sum = 0;
		
		for (int i = 0; i < 12; ++i) {
			if (ISBN[i] == '*') {
				index = i;
			} else {
				if (i % 2 == 0) {
					sum += ISBN[i] - '0';
				} else {
					sum += (ISBN[i] - '0') * 3;
				}
			}
		}
		
		int value = (index % 2 == 0) ? 1 : 3;
		
		for (int i = 0; i < 10; ++i) {
			if ((10 - (sum + i * value) % 10) % 10 == ISBN[12] - '0') {
				System.out.println(i);
				
				break;
			}
		}
	}
}
