import java.io.*;

class Main {
    public static long[] dp;
    public static long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dp = new long[Math.abs(n) + 3];
        long result = 0;
        dp[0] = 0;
        dp[1] = 1;

        if (n >= 0) {
            dp[2] = 1;
            result = find(n);
        } else if (n < 0) {
            dp[2] = -1;
            result = find2(Math.abs(n));
        }

        if (result > 0) {
            bw.append("1\n");
        } else if (result == 0) {
            bw.append("0\n");
        } else {
            bw.append("-1\n");
        }

        bw.append(String.valueOf(Math.abs(result) % MOD));
        bw.flush();
        bw.close();
        br.close();
    }

    public static long find(int n) {
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        return dp[n];
    }

    public static long find2(int n) {
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] - dp[i - 1]) % MOD;
        }
        return dp[n];
    }
}
