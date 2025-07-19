import java.util.*;
import java.io.*;

public class Solution {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringBuilder sb;
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; ++testCase) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; ++i) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb = new StringBuilder();
            sb.append('#').append(testCase).append('\n');

            for (int i = 0; i < n; ++i) {
                // 90도
                for (int j = n - 1; j >= 0; --j) {
                    sb.append(matrix[j][i]);
                }
                sb.append(' ');

                // 180도
                for (int j = n - 1; j >= 0; --j) {
                    sb.append(matrix[n - 1 - i][j]);
                }
                sb.append(' ');

                // 270도
                for (int j = 0; j < n; ++j) {
                    sb.append(matrix[j][n - 1 - i]);
                }
                sb.append('\n');
            }
            
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
    }
}
