import java.io.*;
import java.util.*;

class Number{
	int value;
	int index;
	Number(int value, int index){
		this.value=value;
		this.index=index;
	}
}
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nums=br.readLine().split(" ");
        int n=Integer.parseInt(nums[0]);
        int l=Integer.parseInt(nums[1]);
        Deque<Number> q= new LinkedList<Number>();
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	int index= i-l+1;
        	int value=Integer.parseInt(st.nextToken());
        	while(!q.isEmpty()&&q.peekLast().value>value) {
        		q.pollLast();
        	}
        	q.add(new Number(value, i));

        	if(q.peekFirst().index<index) {
        		q.pollFirst();
        	}
        	bw.write(q.peek().value+" ");
        }
        bw.flush();
        bw.close();
        br.close();
        
    }
}
