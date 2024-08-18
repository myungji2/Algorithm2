import java.io.*;
import java.util.*;


class Main {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	       int n=Integer.parseInt(br.readLine());
	       int[] length= new int[n];
	       int[] value= new int[n];
	       StringTokenizer st=new StringTokenizer(br.readLine());
	       for(int i=0;i<n;i++) {
	    	   int num=Integer.parseInt(st.nextToken());
	    	   length[i]=1;
	    	   value[i]=num;
	    	   for(int j=0;j<i;j++) {
	    		   if(value[j]<num) {
	    			   length[i]=Math.max(length[i], length[j]+1);
	    		   }
	    	   }
	       }
	       int max=0;
	       for(int result: length) {
	    	   if(max<result) {
	    		   max=result;
	    	   }
	       }
	      bw.append(String.valueOf(max));
	      bw.flush();
	      bw.close();
	      br.close();
	      
	    
	 }

}
