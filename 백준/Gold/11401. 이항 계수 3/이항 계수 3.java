import java.io.*;
import java.util.*;
import java.util.function.IntPredicate;


class Main {
	public static long value=1000000007;
	public static long[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		dp = new long[n + 1];

		System.out.println(cal(n,k));
	}
	public static long cal(int n,int k) {
		//n! mod * (r!(n-r)!)제곱 (p-2) mod %p
		long second= fac(k)*fac(n-k)%value;
		return (fac(n)*pow(second, value-2))%value;
	}

    public static long fac(int a) {
        if (a == 0 || a == 1) {
            return 1;
        }
        if (dp[a] > 0) {
            return dp[a];
        }

        dp[0] = 1; // 0! = 1
        for (int i = 1; i <= a; i++) {
            dp[i] = (dp[i - 1] * i) % value;
        }

        return dp[a];
    }
	public static long pow(long a,long b) {
		if(b==1) {
			return a;
		}
		if(b==0) {
			return 1;
		}
		long temp=pow(a, b/2);
		temp=temp*temp%value;
		if (b % 2 != 0) {
	            temp = (temp * a) % value;
	    }
	    return temp;
	}
}