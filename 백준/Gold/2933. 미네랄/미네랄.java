
import java.io.*;
import java.util.*;
import java.util.function.IntPredicate;


class Main {
	
	static int R;
	static int C;
	static char[][] map;
	static int n;
	static int[] height;
	static Queue<Node> q;
	static int[][] dir= {{-1,0},{1,0},{0,-1},{0,1}};
	static class Node {
		int x, y;
		Node(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new char[R][C];
		for(int i=0;i<R;i++) {
			char[] input=br.readLine().toCharArray();
			for(int j=0;j<C;j++) {
				char c=input[j];
				map[i][j]=c;
			}
		}
		n=Integer.parseInt(br.readLine());
		height=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			height[i]=Integer.parseInt(st.nextToken());
		}
		Solution();
	}
	public static void viewmap() {
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<R;i++) {
			if(i!=0) {
				sb.append("\n");
			}
			for(int j=0;j<C;j++) {
				sb.append(map[i][j]);
			}
		}
		System.out.println(sb);
	}
	public static void rebuildmap(ArrayList<Node> list) {
		
		for(Node node:list){
			map[node.x][node.y]='.';
		}
		int move=0;
		boolean flag=true;
		while(flag) {
			for(Node node:list){
				int x=node.x+move+1;
				if(x>=R) {
					flag=false;
					move--;
					break;
				}
				if(map[x][node.y]=='x') {
					flag=false;
					move--;
					break;
				}
			}
			move++;

		}
		for(Node node:list){
			
			map[node.x+move][node.y]='x';
		}
		
	}
	public static void checkcluster(int i,int j) {
		boolean[][]visited=new boolean[R][C];
		visited[i][j]=true;
		for(int four=0;four<4;four++) {
			int newi=i+dir[four][0];
			int newj=j+dir[four][1];
			if(newi<0||newj<0||newi>=R||newj>=C||visited[newi][newj]) continue;
			//bfs로 바닥에 닿았는지 확인하기
			if(map[newi][newj]=='x') {
				ArrayList<Node> list=new ArrayList<>();
				list.add(new Node(newi,newj));
				boolean floating=true;
				Queue<Node> q=new LinkedList<>() ;
				q.add(new Node(newi,newj));
				while(!q.isEmpty()) {
					Node cur= q.poll();
					
					for(int cnt=0;cnt<4;cnt++) {
						int x=cur.x+dir[cnt][0];
						int y=cur.y+dir[cnt][1];
						
						if(x<0||y<0||x>=R||y>=C||visited[x][y]||map[x][y]!='x') continue;
						visited[x][y]=true;
						if(x==R-1) {
							floating=false;
							
						}
						q.add(new Node(x,y));
						list.add(new Node(x,y));
						
					}
					
				}
				if(floating) {
					rebuildmap(list);
					break;
				}

				
			}
			
		}
	}
	public static void thrstick(int num) {
		
		//짝수면 왼쪽 홀수면 오른쪽에서
		int h=height[num];
		if(num%2==0) {
			for(int i=0;i<C;i++) {
				if(map[R-h][i]=='x') {
					map[R-h][i]='.';
					checkcluster(R-h, i);
					break;
					
				}
			}
		}else {
			for(int i=C-1;i>=0;i--) {
				if(map[R-h][i]=='x') {
					map[R-h][i]='.';
					checkcluster(R-h, i);
					break;
				}
			}
		}
	}
	public static void Solution() {
		
		for(int i=0;i<n;i++) {
			
			thrstick(i);
			
		}
		viewmap();
	}
	
	
}