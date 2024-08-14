import java.io.*;
import java.util.*;
class Node{
	int loc;
	int time;
	Node(int loc,int time){
		this.loc=loc;
		this.time=time;
	}
}
class Main {
	public static int n;
	public static int k;
	public static boolean[] visited=new boolean[100002];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        int result=search();
        
        bw.append(String.valueOf(result));
        
        bw.flush();
        bw.close();
        br.close();
        
    }
    public static int search() {
    	Queue<Node> queue=new LinkedList<Node>();
    	queue.add(new Node(n, 0));
    	visited[n]=true;
    	while(!queue.isEmpty()) {
    		Node curNode=queue.poll();
    		int curLoc=curNode.loc;
    		int curTime=curNode.time;
    		if(curLoc==k) {
    			return curTime;
    		}else {
    			if(curLoc+1<visited.length&&!visited[curLoc+1]) {
    				visited[curLoc+1]=true;
    				queue.add(new Node(curLoc+1, curTime+1));
    			}
    			if(curLoc-1>=0&&curLoc-1<visited.length&&!visited[curLoc-1]) {
    				visited[curLoc-1]=true;
    				queue.add(new Node(curLoc-1, curTime+1));
    			}
    			if(curLoc*2<visited.length&&!visited[curLoc*2]) {
    				visited[curLoc*2]=true;
    				queue.add(new Node(curLoc*2, curTime+1));
    			}
    		}
    	}
		return -1;
    
    }
    
}
