

import java.util.Scanner;

class Solution {
    public static int[] kcal;
    public static int[] scores;
    public static int answer;
    public static int target;
    public static int N;

    public static void main(String args[]) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            target = sc.nextInt();
            kcal = new int[N];
            scores = new int[N];

            for (int i = 0; i < N; i++) {
                scores[i] = sc.nextInt();
                kcal[i] = sc.nextInt();
            }

            answer = 0;
            dfs(0, 0, 0);

            System.out.println("#" + test_case + " " + answer);
        }
        sc.close();
    }

    public static void dfs(int sum, int score, int index) {
        if (sum > target) {
            return;
        }

        if (index == N) {
            answer = Math.max(answer, score);
            return;
        }

        // Include current item
        dfs(sum + kcal[index], score + scores[index], index + 1);

        // Exclude current item
        dfs(sum, score, index + 1);
    }
}
