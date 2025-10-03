import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int S;
    static int P;
    static int answer;
    static char[] DNA;
    static int[] ACGT;
    static int[] checkArr;

    public static void main(String[] args) throws IOException {
        init();

        solution();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine().trim());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        answer = 0;

        DNA = br.readLine().trim().toCharArray();

        st = new StringTokenizer(br.readLine().trim());
        ACGT = new int[4];
        for (int i = 0; i < 4; ++i) {
            ACGT[i] = Integer.parseInt(st.nextToken());
        }

        checkArr = new int[4];
    }

    static void solution() {
        for (int i = 0; i < P; ++i) {
            add(DNA[i]);
        }

        check();

        for (int i = P; i < S; ++i) {
            add(DNA[i]);
            int j = i - P;
            remove(DNA[j]);
            check();
        }

        System.out.println(answer);
    }

    static void add(char c) {
        switch (c) {
            case 'A':
                ++checkArr[0];
                break;
            case 'C':
                ++checkArr[1];
                break;
            case 'G':
                ++checkArr[2];
                break;
            case 'T':
                ++checkArr[3];
                break;
            default:
                System.out.println("==== IT'S INVALID INPUT ====");
        }
    }

    static void remove(char c) {
        switch (c) {
            case 'A':
                --checkArr[0];
                break;
            case 'C':
                --checkArr[1];
                break;
            case 'G':
                --checkArr[2];
                break;
            case 'T':
                --checkArr[3];
                break;
            default:
                System.out.println("==== IT'S INVALID INPUT ====");
        }
    }

    static void check() {
        int count = 0;

        for (int i = 0; i < 4; ++i) {
            if (checkArr[i] >= ACGT[i]) ++count;
        }

        if (count == 4) ++answer;
    }
}
