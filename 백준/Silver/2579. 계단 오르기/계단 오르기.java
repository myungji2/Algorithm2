
import java.io.*;
import java.util.*;


class Main {
	public static int[]arr;
	public static int[]result;
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        int t = Integer.parseInt(br.readLine());
	        arr=new int[t+1];
	        result=new int[t+1];
	        arr[0]=0;
	        for(int i=0;i<t;i++) {
	        	arr[i+1]=Integer.parseInt(br.readLine());
	        }
	        arr[0]=0;
	        result[0]=0;
	        result[1]=arr[1];
	        if(t>=2) {
		        result[2]=arr[1]+arr[2];

	        }
	
	        System.out.println(find(t));
	      
	    
	 }
	 static int find(int N) {
			if(N==0||result[N]>0) {
				return result[N];
			}else {
				result[N] = Math.max(find(N - 2), find(N - 3) + arr[N - 1]) + arr[N];
				return result[N];
			}
		}
}
