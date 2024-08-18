import java.io.*;
import java.util.*;


class Main {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	       int n=Integer.parseInt(br.readLine());
	       long[] sum=new long[n+1];
	       if(n==1||n==2) {
	    	   System.out.println(1);
	       }else {
	    	   sum[1]=1;
		       sum[2]=1;
		       for(int i=3;i<n+1;i++) {
		    	   sum[i]=(sum[i-1]+sum[i-2]);
		       }
		       System.out.println(sum[n]);
	       }
	      
	      
	    
	 }

}
