
import java.io.*;
import java.util.*;
import java.util.function.IntPredicate;


class Main {
	public static long value=10007;
	public static long[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		map=new long[n+1][k+1];
		System.out.println(cal(n,k));
	}
	public static long cal(int n,int k) {
		if(map[n][k]>0) {
			return map[n][k];
		}
		if(n==k||k==0) {
			return 1;
		}
		
		return map[n][k]=(cal(n-1, k)+cal(n-1, k-1))%value;
	}
}