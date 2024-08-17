
import java.io.*;
import java.util.*;


class Main {
	public static int value=10007;
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	      StringTokenizer st= new StringTokenizer(br.readLine());
	      int n= Integer.parseInt(st.nextToken());
	      int m= Integer.parseInt(st.nextToken());
	      int[] numbers=new int[n+1];
	      int prev=0;
	      StringTokenizer st3= new StringTokenizer(br.readLine());
	      
	      numbers[0]=0;
	      for(int i=1;i<n+1;i++) {
	    	  prev+=Integer.parseInt(st3.nextToken());
	    	  numbers[i]=prev;
	      }
	      for(int j=0;j<m;j++) {
	    	  StringTokenizer st2=new StringTokenizer(br.readLine());
	    	  int num1=Integer.parseInt(st2.nextToken());
	    	  int num2=Integer.parseInt(st2.nextToken());
	    	  int result= numbers[num2]-numbers[num1-1];
	    	  bw.append(String.valueOf(result)).append('\n');
	      }
	      bw.flush();
	      bw.close();
	      br.close();
	      
	    
	 }

}
