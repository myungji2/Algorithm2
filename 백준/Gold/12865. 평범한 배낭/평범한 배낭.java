
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.IntPredicate;
import java.util.stream.Stream;
class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int[] w=new int[n+1];
		int[] v= new int[n+1];
		int[][] dp= new int[n+1][k+1];
		for(int i=0;i<n;i++) {
			st= new StringTokenizer(br.readLine());
			w[i+1]=Integer.parseInt(st.nextToken());
			v[i+1]=Integer.parseInt(st.nextToken());
			
		}
		for(int i=0;i<n+1;i++) {//i가 물건
			for(int j=0;j<k+1;j++) {//j가 무게
				if(i==0||j==0) {
					dp[i][j]=0;
				}else {
					if(j<w[i]) {
						dp[i][j]=dp[i-1][j];
					}else {
						dp[i][j]=Math.max(dp[i-1][j-w[i]]+v[i],dp[i-1][j]);
					}
				}
				
			}
			
		}
		System.out.println(dp[n][k]);
	}
}