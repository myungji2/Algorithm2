import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num= Integer.parseInt(br.readLine());
        Deque<Integer> q= new LinkedList<>();
        for(int i=0;i<num;i++) {
        	q.addLast(i+1);
        }
        while(q.size()>2) {
        	q.poll();
        	q.addLast(q.poll());
        }
        if(q.size()==2) {
        	q.poll();
        }
        bw.append(String.valueOf(q.peek()));
        bw.flush();
        bw.close();
        br.close();
        
    }
}
