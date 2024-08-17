
import java.io.*;
import java.security.spec.ECFieldFp;
import java.util.*;

class Node {
    int zero=-1;
    int one=-1;
    Node(int zero,int one){
    	this.zero=zero;
    	this.one=one;
    }
}

class Main {
	public static Node[]dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt(br.readLine());

        dp = new Node[41];
        dp[0]=new Node(1, 0);
        dp[1]=new Node(0, 1);
        for(int i=0;i<x;i++) {
        	int n=Integer.parseInt(br.readLine());
        	Node node=find(n);
        	bw.append(String.valueOf(node.zero)).append(' ').append(String.valueOf(node.one)).append('\n');
        }
        bw.flush();
        bw.close();
        br.close();

    }
    public static Node find(int n) {
    	if(dp[n]!=null) {
    		return dp[n];
    	}else {
    		Node prev=find(n-2);
    		Node prev2=find(n-1);
    		dp[n] = new Node(prev.zero+prev2.zero, prev.one+prev2.one);
    		return dp[n];
    	}
    }
}
