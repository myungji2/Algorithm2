import java.io.*;
import java.lang.module.FindException;
import java.util.*;

class Node{
	int time;
	int pay;
	int dp;
	Node(int time,int pay,int dp){
		this.time=time;
		this.pay=pay;
		this.dp=dp;
	}
	
}
class Main {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	       int n=Integer.parseInt(br.readLine());
	       Node[] nodes= new Node[n];
	       for(int i=0;i<n;i++) {
	    	   String[] inputStrings=br.readLine().split(" ");
	    	   int time= Integer.parseInt(inputStrings[0]);
	    	   int pay= Integer.parseInt(inputStrings[1]);
	    	   if(time>n-i) {
		    	   pay=0;
	    	   }
	    	   nodes[i]=new Node(time,pay,pay );
	    	   for(int j=0;j<i;j++) {
	    		   Node curNode=nodes[j];
	    		   int endtime=curNode.time+j-1;
	    		   if(endtime<i) {
	    			   nodes[i].dp=Math.max(nodes[i].dp, curNode.dp+pay);
	    		   }
	    	   }
	       }
	       
	       
	      int max=0;
	      for(Node curNode:nodes) {
	    	  if(max<curNode.dp) {
	    		  max=curNode.dp;
	    	  }
	      }
	      bw.append(String.valueOf(max));
	      bw.flush();
	      bw.close();
	      br.close();
	      
	    
	 }


}
