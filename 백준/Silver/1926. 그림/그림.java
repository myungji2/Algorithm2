import java.io.*;
import java.util.*;
class Node{
	int n;
	int m;
	Node(int n,int m){
		this.n=n;
		this.m=m;
	}
}
class Main {
	public static boolean[][] visited;
	public static boolean[][] colored;
	public static int n;
	public static int m;
    public static Queue<Integer> answerqueue= new PriorityQueue<Integer>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        visited=new boolean[n][m];
        colored=new boolean[n][m];
        for(int i=0;i<n;i++) {
            StringTokenizer st2= new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
            	if(st2.nextToken().equals("1")) {
            		colored[i][j]=true;
            	}else {
            		colored[i][j]=false;
            	}
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
            	if(!visited[i][j]&&colored[i][j]) {
            		visited[i][j]=true;
            		search(new Node(i, j));
            	}
            }
        }
        bw.append(String.valueOf(answerqueue.size())).append('\n');
        if(answerqueue.size()==0) {
        	bw.append("0");
        }else {
            bw.append(String.valueOf(answerqueue.peek()));
        }
        bw.flush();
        bw.close();
        br.close();
        
    }
    public static void search(Node start) {
    	int num=0;
    	Queue<Node> queue= new LinkedList<Node>();
    	queue.add(start);
    	while(queue.size()>0) {
    		Node startNode=queue.poll();
    		int curn=startNode.n;
        	int curm=startNode.m;
    		
        	if(colored[curn][curm]) {
        		num++;
        	}else {
        		continue;
        	}
        	if((curn!=0)&&!visited[curn-1][curm]) {
        		visited[curn-1][curm]=true;
        		queue.add(new Node(curn-1,curm));
        	}
        	if((curn!=n-1&&!visited[curn+1][curm])) {
        		visited[curn+1][curm]=true;
        		queue.add(new Node(curn+1, curm));
        	}
        	if((curm!=0)&&!visited[curn][curm-1]) {
        		visited[curn][curm-1]=true;
        		queue.add(new Node(curn,curm-1));
        	}
        	if((curm!=m-1)&&!visited[curn][curm+1]) {
        		visited[curn][curm+1]=true;
        		queue.add(new Node(curn,curm+1));
        	}
    	}
    	answerqueue.add(num);
    	
    	
    	
    }
}
