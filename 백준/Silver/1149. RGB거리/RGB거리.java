
import java.io.*;
import java.util.*;


class Main {
	public static int[][] arr;
	public static int[][] result;
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	       int n=Integer.parseInt(br.readLine());
	       arr=new int[n][3];
	       result=new int[n][3];
	       for(int i=0;i<n;i++) {
	    	   StringTokenizer st= new StringTokenizer(br.readLine());
	    	   for(int j=0;j<3;j++) {
	    		   arr[i][j]=Integer.parseInt(st.nextToken());
	    	   }
	       }
	       for(int k=0;k<3;k++) {
	    	   result[0][k]=arr[0][k];
	       }
	       for(int i=1;i<n;i++) {
	    	   for(int j=0;j<3;j++) {
	    		   result[i][j]=Math.min(result[i-1][(j+1)%3], result[i-1][(j+2)%3])+arr[i][j];
	    	   }
	       }
	       System.out.println(Math.min(result[n-1][0], Math.min(result[n-1][1],result[n-1][2])));
	      
	    
	 }

}
