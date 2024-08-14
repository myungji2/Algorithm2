
import java.io.*;
import java.util.*;
class Node{
	int n;
	int m;
	int time;
	int state;
	Node(int n,int m,int time,int state){
		this.n=n;
		this.m=m;
		this.time=time;
		this.state=state;
	}
}
class Main {
	public static int r;
	public static int c;
	public static int[][] state;
	public static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        state=new int[r][c];
        visited=new boolean[r][c];
    	Node start=null;
    	Deque<Node> queue=new LinkedList<Node>();
        for(int i=0;i<r;i++) {
        	String[] inputs=br.readLine().split("");
        	for(int j=0;j<c;j++) {
        		String input= inputs[j];
        		switch(input) {
        		case "#":
        			state[i][j]=0;
        			visited[i][j]=true;
        			break;
        		case".":
        			state[i][j]=1;
        			break;
        		case"J":
        			state[i][j]=1;
        			visited[i][j]=true;
        			start= new Node(i,j,0,1);
        			break;
        		case"F":
        			queue.add(new Node(i, j,0,2));
        			visited[i][j]=true;
        			state[i][j]=2;
        			break;
        		default:
        			break;
        		}
        	}
        }
        queue.addFirst(start);
        int result=search(queue);
        if(result>0) {
        	bw.append(String.valueOf(result));
        }else {
        	bw.append("IMPOSSIBLE");
        }
        bw.flush();
        bw.close();
        br.close();
        
    }
    public static int search(Deque<Node> queue) {
    	
    	int[] dir1= {-1,1,0,0};
    	int[] dir2= {0,0,-1,1};
    	while(!queue.isEmpty()) {
    		Node curNode=queue.poll();
    		int curn=curNode.n;
    		int curm=curNode.m;
    		int curt= curNode.time;
    		int curs=curNode.state;
    		if(state[curn][curm]==1&&(curn==r-1||curm==c-1||curn==0||curm==0)) {
    			return curt+1;
    		}
    		for(int i=0;i<4;i++) {
    			int nextn=curn+dir1[i];
    			int nextm=curm+dir2[i];
    			if(nextn!=r&&nextm!=c&&nextn>=0&&nextm>=0&&state[nextn][nextm]==1) {
    				if(curs==2) {
    					state[nextn][nextm]=2;
    					queue.add(new Node(nextn, nextm, curt+1, 2));
    				}else {
    					if(!visited[nextn][nextm]) {
    						visited[nextn][nextm]=true;
        					queue.add(new Node(nextn, nextm, curt+1, 1));
    					}
    					
    				}
    			}
    		}
    	}
    	return -1;
    }
    
}
