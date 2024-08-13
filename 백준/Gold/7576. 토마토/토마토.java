import java.io.*;
import java.util.*;
class Node{
	int n;
	int m;
	int day;
	Node(int n,int m,int day){
		this.n=n;
		this.m=m;
		this.day=day;
	}
}
class Main {
	public static boolean[][] visited;
	public static int[][] colored;
	public static int n;
	public static int m;
	public static Queue<Node> tmtNodes= new LinkedList<Node>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        visited=new boolean[n][m];
        colored=new int[n][m];
        int tomato=0;
        
        for(int i=0;i<n;i++) {
        	StringTokenizer st2=new StringTokenizer(br.readLine());
        	for(int j=0;j<m;j++) {
        		String string=st2.nextToken();
            	if(string.equals("1")) {
            		colored[i][j]=1;
            		tmtNodes.add(new Node(i, j, 0));
            		visited[i][j]=true;
            	}else if(string.equals("0")){
            		colored[i][j]=0;
            		tomato++;
            	}else {
            		colored[i][j]=-1;
            	}
            }
        }
        if(tomato==0) {
        	bw.append("0");
        }else {
        	int answer=search(tomato);
            bw.append(String.valueOf(answer));

        }
        
        bw.flush();
        bw.close();
        br.close();
        
    }
    public static int search(int tomato) {

        int[] dn = {-1, 1, 0, 0};  // 상하좌우 이동을 위한 델타 배열
        int[] dm = {0, 0, -1, 1};
        int returnday=0;
        while (!tmtNodes.isEmpty()) {
            Node current = tmtNodes.poll();
            int curn = current.n;
            int curm = current.m;
            int curday = current.day;
            if(returnday<curday) {
            	returnday=curday;
            }
            for (int i = 0; i < 4; i++) {
                int nextn = curn + dn[i];
                int nextm = curm + dm[i];

                if (nextn >= 0 && nextn < n && nextm >= 0 && nextm < m && !visited[nextn][nextm] && colored[nextn][nextm]==0) {
                    visited[nextn][nextm] = true;
                    colored[nextn][nextm]=1;
                    tomato--;
                    tmtNodes.add(new Node(nextn, nextm, curday + 1));
                }
            }

        }
        if(tomato==0) {
        	return returnday;
        }else {
        	return -1;
        }
    }
}
