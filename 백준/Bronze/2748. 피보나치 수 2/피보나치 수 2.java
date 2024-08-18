import java.io.*;

class Main {
	public static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[ n+3];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        
        System.out.println(find(n));
    }
    public static long find(int n) {
    	if(n<3||dp[n]>0) {
    		return dp[n];
    	}else {
    		long result=find(n-1)+find(n-2);
    		dp[n]=result;
    		return result;
    	}
    }
}
