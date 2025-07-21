// 생성자가 있는 수인지 확인, 아니면 출력

public class Main {
    public static void main(String[] args) {
        boolean[] isNotSelfNumber = new boolean[10001];

        for (int i = 1; i < 10001; ++i) {
            int n = i;
            int sum = n;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            if (sum <= 10000) {
                isNotSelfNumber[sum] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10001; ++i) {
            if (!isNotSelfNumber[i]) {
                sb.append(i).append('\n');
            }
        }

        System.out.print(sb);
    }
}
