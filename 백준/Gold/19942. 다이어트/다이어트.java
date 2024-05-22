import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormatSymbols;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

class Main
{	
	public static int[][] map;
	public static int n;
	public static boolean[] visited;
	public static int[] targetval= new int[4];
	public static int[] list;
	public static int price_min=100000;
	public static boolean[] min_visited;
	public static void main (String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n= Integer.parseInt(bf.readLine());
		map=new int[n][5];
		visited=new boolean[n];
		String target=bf.readLine();
		String[] targetlist= target.split(" ");
		for(int i=0;i<4;i++) {
			targetval[i]=Integer.parseInt(targetlist[i]);
		}
		for(int i=0;i<n;i++) {
			String s = bf.readLine();
			String[] slist= s.split(" ");
			 for(int j = 0; j < 5; j++) {
	                map[i][j] = Integer.parseInt(slist[j]);
	            }
		}
		min_visited=new boolean[n];
		list=new int[5];
		dfs(0);
		if(price_min==100000) {
			price_min=-1;
		}
		System.out.println(price_min);
		for(int i=0;i<n;i++) {
			if(min_visited[i]) {
				System.out.print(i+1);
				System.out.print(" ");
			}
		}

	}
	public static void dfs(int v) {
		if(list[0]>=targetval[0]&&list[1]>=targetval[1]&&list[2]>=targetval[2]&&list[3]>=targetval[3]) { 
			if(price_min>list[4]) {
				price_min=list[4];
				for(int i=0;i<n;i++) {
					if(visited[i]) {
						min_visited[i]=true;
					}else {
						min_visited[i]=false;
					}
				}
			}
			
			
			return;
		}
		
		for(int i=v;i<n;i++) {
			visited[i]=true;
			sumvalue(i);
			dfs(i+1);
			visited[i]=false;
			subvalue(i);
		}
	}
	public static int[] sumvalue(int v) {
		for(int i=0;i<5;i++) {
			list[i]+=map[v][i];
		}
		return list;
	}
	public static int[] subvalue(int v) {
		for(int i=0;i<5;i++) {
			list[i]-=map[v][i];
		}
		return list;
		
	}
	
	
}
