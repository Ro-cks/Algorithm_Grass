import java.util.Scanner;

public class Main {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.
        int[][] nums = new int[n][m];

        int r = 0;
        int c = 0;
        int d = 0;
        int num = 1;
        while (num <= n * m) {
            nums[r][c] = num++;
            r += dr[d];
            c += dc[d];

            if (r < 0 || r >= n || c < 0 || c >= m || nums[r][c] != 0) {
                r -= dr[d];
                c -= dc[d];

                d = (d + 4 + 1) % 4;
                r += dr[d];
                c += dc[d];
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }
}