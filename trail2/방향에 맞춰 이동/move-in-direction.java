import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int answerC = 0;
        int answerR = 0;
        for (int n = 0; n < N; ++n) {
            st = new StringTokenizer(br.readLine());

            String direction = st.nextToken();
            int distance = Integer.parseInt(st.nextToken());

            switch (direction) {
                case "W":
                answerC -= distance;
                break;
                case "S": 
                answerR -= distance;
                break;
                case "N": 
                answerR += distance;
                break;
                case "E":
                answerC += distance;
                break;
                default:
                System.out.println("올바르지 않은 입력입니다.");
            }
        }

        System.out.println(answerC + " " + answerR);
    }
}