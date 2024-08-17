
import java.io.*;
import java.util.*;

class Node {
    int dp;
    List<Integer> list = new LinkedList<>();

    public void add(int n) {
        list.add(n);
    }

    Node(int n) {
        this.dp = n;
    }

    Node(int n, List<Integer> list, int add) {
        this.dp = n;
        this.list = new ArrayList<>(list);  
        this.list.add(add);
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt(br.readLine());

        Node[] dp = new Node[x + 1];

        dp[1] = new Node(0); 
      
        for (int i = 2; i <= x; i++) {
            dp[i] = new Node(dp[i - 1].dp + 1, dp[i - 1].list, i - 1);

            if (i % 2 == 0 && dp[i].dp > dp[i / 2].dp + 1) {
                dp[i] = new Node(dp[i / 2].dp + 1, dp[i / 2].list, i / 2);
            }

            if (i % 3 == 0 && dp[i].dp > dp[i / 3].dp + 1) {
                dp[i] = new Node(dp[i / 3].dp + 1, dp[i / 3].list, i / 3);
            }
        }

        bw.append(String.valueOf(dp[x].dp)).append('\n');
        bw.append(String.valueOf(x)).append(' ');

        for (int i = dp[x].list.size() - 1; i >= 0; i--) {
            bw.append(String.valueOf(dp[x].list.get(i))).append(' ');
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
