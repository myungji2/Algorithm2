import java.io.*;
import java.util.*;


class Main {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	       int n=Integer.parseInt(br.readLine());
	       StringTokenizer st=new StringTokenizer(br.readLine());
	       int max=Integer.MIN_VALUE;
	       int cur=0;
	       for(int i=0;i<n;i++) {
	    	   int num=Integer.parseInt(st.nextToken());
	    	   if(cur+num<num) {
	    		   cur=num;
	    	   }
	    	   else if(cur+num>0) {
	    		   cur=cur+num;  
	    	   }else {
	    			   cur=num;
	    	   }
	    	   if(max<cur) {
    			   max=cur;
    		   }
	       }
	      bw.append(String.valueOf(max));
	      bw.flush();
	      bw.close();
	      br.close();
	      
	    
	 }

}
