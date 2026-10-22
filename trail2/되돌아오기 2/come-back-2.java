import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int r = 0;
        int c = 0;
        int d = 0;
        int time = 0;

        String commands = br.readLine();
        for (int i = 0; i < commands.length(); ++i) {
            char command = commands.charAt(i);
            ++time;

            if (command == 'L') {
                d = (d + 4 - 1) % 4;
            } else if (command == 'R') {
                d = (d + 4 + 1) % 4;
            } else {
                r += dr[d];
                c += dc[d];

                if (r == 0 && c == 0) {
                    System.out.println(time);
                    System.exit(0);
                }
            }
        }

        System.out.println(-1);
    }
}