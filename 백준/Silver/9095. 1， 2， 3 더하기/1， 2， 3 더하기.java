
import java.io.*;
import java.util.*;


class Main {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        int dp[]= new int[12];
	        int t = Integer.parseInt(br.readLine());
	        dp[1]=1;
	        dp[2]=2;
	        dp[3]=4;
	        for(int i=4;i<12;i++) {
	        	dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
	        }
	        for(int i=0;i<t;i++) {
	        	int n=Integer.parseInt(br.readLine());
	        	bw.append(String.valueOf(dp[n])).append('\n');
	        }
	        
	        bw.flush();
	        bw.close();
	        br.close();
	      
	    
	 }
    
}
