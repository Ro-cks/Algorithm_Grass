import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;

    public static void main(String[] args) throws IOException {
        init();

        solution();
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine().trim());
    }

    static void solution() {
        int answer = 0;

        while (true) {
            // 5원으로 나누어 떨어지는지 확인
            if (n % 5 == 0) {
                answer += n / 5;

                break;
            }

            // 5원으로 나눠지지 않으면 2원을 하나씩 빼기
            n -= 2;
            ++answer;

            // 거슬러 줄 수 없는 경우
            if (n < 0) {
                answer = -1;

                break;
            }
        }

        System.out.print(answer);
    }
}
