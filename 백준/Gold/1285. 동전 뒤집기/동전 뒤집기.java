import java.io.*;
import java.util.Scanner;

public class Main {
    static int n;
    static char[][] coins;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(br.readLine());
        
        coins = new char[n][n];

        for (int i = 0; i < n; i++) {
            coins[i] = (br.readLine()).toCharArray();
        }

        int result = solve();
        System.out.println(result);
    }

    public static int solve() {
        int minTails = INF;
        char[][] flippedCoins = new char[n][n];
        for (int mask = 0; mask < (1 << n); mask++) {
            

 
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((mask & (1 << i)) != 0) {
                        flippedCoins[i][j] = (coins[i][j] == 'H') ? 'T' : 'H';
                    } else {
                        flippedCoins[i][j] = coins[i][j];
                    }
                }
            }

            int tailsCount = 0;
            for (int j = 0; j < n; j++) {
                int columnTails = 0;
                for (int i = 0; i < n; i++) {
                    if (flippedCoins[i][j] == 'T') {
                        columnTails++;
                    }
                }

                tailsCount += Math.min(columnTails, n - columnTails);
            }

            minTails = Math.min(minTails, tailsCount);
        }

        return minTails;
    }
}
