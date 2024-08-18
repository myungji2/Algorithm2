import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] time = new int[n];
        int[] pay = new int[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            time[i] = Integer.parseInt(input[0]);
            pay[i] = Integer.parseInt(input[1]);
        }

        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, dp[i]);
            int endTime = i + time[i];
            if (endTime <= n) {
                dp[endTime] = Math.max(dp[endTime], maxProfit + pay[i]);
            }
        }

        maxProfit = Math.max(maxProfit, dp[n]);
        System.out.println(maxProfit);
    }
}
