import java.io.*;
import java.util.*;
class Node{
	int n;
	int m;
	int move;
	Node(int n,int m,int move){
		this.n=n;
		this.m=m;
		this.move=move;
	}
}
class Main {
	public static boolean[][] visited;
	public static boolean[][] colored;
	public static int n;
	public static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        visited=new boolean[n][m];
        colored=new boolean[n][m];
        for(int i=0;i<n;i++) {
        	String[] inputStrings=br.readLine().split("");
        	for(int j=0;j<m;j++) {
            	if(inputStrings[j].equals("1")) {
            		colored[i][j]=true;
            	}else {
            		colored[i][j]=false;
            	}
            }
        }
        int answer=search(new Node(0, 0,1));
        bw.append(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
        
    }
    public static int search(Node start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        visited[start.n][start.m] = true;

        int[] dn = {-1, 1, 0, 0}; 
        int[] dm = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int curn = current.n;
            int curm = current.m;
            int curmove = current.move;

            
            if (curn == n - 1 && curm == m - 1) {
                return curmove;
            }

           
            for (int i = 0; i < 4; i++) {
                int nextn = curn + dn[i];
                int nextm = curm + dm[i];

               
                if (nextn >= 0 && nextn < n && nextm >= 0 && nextm < m && !visited[nextn][nextm] && colored[nextn][nextm]) {
                    visited[nextn][nextm] = true;
                    queue.add(new Node(nextn, nextm, curmove + 1));
                }
            }
        }

        return -1;
    }
}
