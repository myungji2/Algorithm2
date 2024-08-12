import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num= Integer.parseInt(br.readLine());
        Deque<String> q= new LinkedList<>();
        for(int i=0;i<num;i++) {
        	String commend= br.readLine();
        	String[] commends= commend.split(" ");
        	switch(commends[0]) {
        	case "push_back":
        		q.addLast(commends[1]);
        		break;
        	case "push_front":
        		q.addFirst(commends[1]);
        		break;
        	case "pop_front":
        		if(q.isEmpty()) {
        			bw.append("-1\n");
        		}else {
        			bw.append(q.pollFirst()).append('\n');
        		}
        		break;
        	case "pop_back":
        		if(q.isEmpty()) {
        			bw.append("-1\n");
        		}else {
        			bw.append(q.pollLast()).append('\n');
        		}
        		break;
        	case "size":
        		bw.append(String.valueOf(q.size())).append('\n');
        		break;
        	case "empty":
        		if(q.isEmpty()) {
        			bw.append("1\n");
        		}else {
        			bw.append("0\n");
        		}
        		break;
        	case "front":
        		if(q.isEmpty()) {
        			bw.append("-1\n");
        		}else {
        			bw.append(q.peekFirst()).append('\n');
        		}
        		break;
        	case "back":
        		if(q.isEmpty()) {
        			bw.append("-1\n");
        		}else {
        			bw.append(q.peekLast()).append('\n');
        		}
        		break;
        	default:
        		break;
        	}
        }
      
        bw.flush();
        bw.close();
        br.close();
        
    }
}
