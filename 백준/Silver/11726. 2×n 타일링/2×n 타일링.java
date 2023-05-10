import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int DIV = 10_007;

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];    // n이 1부터 가능하기 때문에 크기를 n + 1로 선언하면 안 됨

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            // 점화식: an = a(n-1) + a(n-2)
            dp[i] = (dp[i - 1] + dp[i - 2]) % DIV;
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
    }
}