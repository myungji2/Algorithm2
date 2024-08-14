
import java.io.*;
import java.util.*;

class Node{
	int i;
	int j;
	Node(int i,int j){
		this.i=i;
		this.j=j;
	}
}
class Main {
	public static int n;
	public static String[][] map;
	public static boolean[][] visited;
	public static boolean[][] visited2;
	public static int[] dir1= {1,-1,0,0};
	public static int[] dir2= {0,0,-1,1};
    public static void main(String[] args) throws IOException {     
        input();
        bfs();
    }
	public static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        map=new String[n][n];
        visited=new boolean[n][n];
        visited2=new boolean[n][n];
        for(int i=0;i<n;i++) {
        	String[] input=br.readLine().split("");
        	map[i]=input;
        	
        }

        br.close();
	}
	public static void bfs() throws IOException {
		BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(System.out));
		int result=0;
		int result2=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visited[i][j]) {
					search(new Node(i,j));
					result++;
				}
				if(!visited2[i][j]) {
					search2(new Node(i,j));
					result2++;
				}
			}
		}
		bufferedWriter.append(String.valueOf(result)).append(' ').append(String.valueOf(result2));
		bufferedWriter.close();
		
	}
	public static void search(Node start) {
		Queue<Node>queue=new LinkedList<Node>();
		queue.add(start);
		while(!queue.isEmpty()) {
			Node curNode=queue.poll();
			int curi=curNode.i;
			int curj=curNode.j;
			for(int i=0;i<4;i++) {
				int nexti=curi+dir1[i];
				int nextj=curj+dir2[i];
				if(nexti<n&&nextj<n&&nexti>=0&&nextj>=0&&!visited[nexti][nextj]&&map[nexti][nextj].equals(map[curi][curj])) {
					visited[nexti][nextj]=true;
					queue.add(new Node(nexti, nextj));
				}
			}
		}
	}
	public static void search2(Node start) {
		Queue<Node>queue=new LinkedList<Node>();
		queue.add(start);
		while(!queue.isEmpty()) {
			Node curNode=queue.poll();
			int curi=curNode.i;
			int curj=curNode.j;
			for(int i=0;i<4;i++) {
				int nexti=curi+dir1[i];
				int nextj=curj+dir2[i];

				if(nexti<n&&nextj<n&&nexti>=0&&nextj>=0&&!visited2[nexti][nextj]) {
					if(map[curi][curj].equals("B")&&map[nexti][nextj].equals("B")) {
						visited2[nexti][nextj]=true;
						queue.add(new Node(nexti, nextj));
					}else {
						if(!map[curi][curj].equals("B")&&!map[nexti][nextj].equals("B")) {
							visited2[nexti][nextj]=true;
							queue.add(new Node(nexti, nextj));
						}
					}
				}
			}
		}
	}
    
}
