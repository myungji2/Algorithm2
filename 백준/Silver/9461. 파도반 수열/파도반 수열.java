import java.io.*;
import java.lang.module.FindException;
import java.util.*;


class Main {
	public static long[] arr;
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	       int n=Integer.parseInt(br.readLine());
	       arr=new long[102];
	       arr[1]=1;
	       arr[2]=1;
	       arr[3]=1;
	     for(int i=0;i<n;i++) {
	    	 int t= Integer.parseInt(br.readLine());
		      bw.append(String.valueOf(find(t))).append('\n');

	     }
	      
	      bw.flush();
	      bw.close();
	      br.close();
	      
	    
	 }
	 public static long find(int n) {
		 long arrn=arr[n];
		 if(arrn>0) {
			 return arrn;
		 }
		 else {
			 long result=find(n-2)+find(n-3);
			 arr[n]=result;
			 return result;
		 }
		 
	 }

}
