
import java.io.*;
import java.util.*;


class Main {
	public static int value=10007;
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	       int n=Integer.parseInt(br.readLine());
	       int[] sum=new int[n+1];
	       if(n==1) {
	    	   System.out.println(1);
	       }else {
	    	   sum[1]=1;
		       sum[2]=2;
		       for(int i=3;i<n+1;i++) {
		    	   sum[i]=(sum[i-1]+sum[i-2])%value;
		       }
		       System.out.println(sum[n]);
	       }
	      
	      
	    
	 }

}
