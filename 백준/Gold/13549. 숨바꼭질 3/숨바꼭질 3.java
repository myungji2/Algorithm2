import java.io.*;
import java.time.temporal.ValueRange;
import java.util.*;



class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[] cost=new int[100001];
        Arrays.fill(cost, 100000);
        Queue<Integer> q= new LinkedList<>();
        q.add(n);
        cost[n]=0;
        while(!q.isEmpty()) {
        	int cur=q.poll();
        	int curcost=cost[cur];
        	int add=cur+1;
        	int sub=cur-1;
        	int move=cur*2;
        	if(add>=0&&add<100001&&cost[add]>curcost+1) {
        		cost[add]=curcost+1;
        		q.add(add);
        	}
        	if(sub>=0&&sub<100001&&cost[sub]>curcost+1) {
        		cost[sub]=curcost+1;
        		q.add(sub);
        	}
        	if(move>=0&&move<100001&&cost[move]>curcost) {
        		cost[move]=curcost;
        		q.add(move);
        	}
        	
        }
        System.out.println(cost[k]);
    }
 }