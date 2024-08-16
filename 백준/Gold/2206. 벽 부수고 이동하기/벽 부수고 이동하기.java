
import java.io.*;
import java.util.*;

class Node{
    int i;
    int j;
    int move;
    boolean wall;
    Node(int i,int j,int move, boolean wall){
        this.i=i;
        this.j=j;
        this.move=move;
        this.wall=wall;
    }
}
class Main {

    public static int[] dir1= {1,-1,0,0};
    public static int[] dir2= {0,0,-1,1};
    public static int n;
    public static int m;
    public static boolean[][] map;
    public static boolean[][][] visited; 
    public static void main(String[] args) throws IOException {     
       input();
       BufferedWriter bWriter=new BufferedWriter(new OutputStreamWriter(System.out));
       bWriter.append(String.valueOf(bfs()));
       bWriter.flush();
       bWriter.close();
    }
    
    public static void input() throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer=new StringTokenizer(br.readLine());
        n=Integer.parseInt(stringTokenizer.nextToken());
        m=Integer.parseInt(stringTokenizer.nextToken());
        map=new boolean[n][m];
        visited=new boolean[n][m][2]; // 2는 벽을 부순 여부(0: 안부숨, 1: 부숨)
        for(int i=0;i<n;i++) {
            String[] string=br.readLine().split("");
            int j=0;
            for(String s: string) {
                if(s.equals("1")) {
                    map[i][j]=true;
                }else {
                    map[i][j]=false;
                }
                j++;
            }
        }
        br.close();
    }

    public static int bfs() {
        Queue<Node> queue= new LinkedList<Node>();
        queue.add(new Node(0,0,1,false));
        visited[0][0][0]=true; 

        while(!queue.isEmpty()) {
            Node curNode=queue.poll();
            int curn=curNode.i;
            int curm=curNode.j;
            int curmove=curNode.move;
            boolean wall=curNode.wall;

            if(curn==n-1 && curm==m-1) {
                return curmove;
            }

            for(int i=0;i<4;i++) {
                int nextn=curn+dir1[i];
                int nextm=curm+dir2[i];

                if(nextn>=0 && nextm>=0 && nextn<n && nextm<m) {
                    int wallState = wall ? 1 : 0;
                    if(!map[nextn][nextm] && !visited[nextn][nextm][wallState]) {
                        visited[nextn][nextm][wallState] = true;
                        queue.add(new Node(nextn, nextm, curmove + 1, wall));
                    } else if(map[nextn][nextm] && !wall && !visited[nextn][nextm][1]) {
                        visited[nextn][nextm][1] = true;
                        queue.add(new Node(nextn, nextm, curmove + 1, true));
                    }
                }
            }
        }
        return -1;
    }
}
