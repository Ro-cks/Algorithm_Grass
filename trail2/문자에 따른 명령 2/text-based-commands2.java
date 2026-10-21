import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String commands = br.readLine();

        int c = 0;
        int r = 0;
        int d = 0;
        for (int i = 0; i < commands.length(); ++i) {
            char command = commands.charAt(i);
            switch (command) {
                case 'L': d = (d + 4 - 1) % 4; break;
                case 'R': d = (d + 4 + 1) % 4; break;
                case 'F':
                c += dc[d];
                r += dr[d];
                break;
                default: System.out.println("올바르지 않은 명령입니다.");
            }
        }

        System.out.println(c + " " + r);
    }
}