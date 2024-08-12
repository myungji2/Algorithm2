import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num= Integer.parseInt(br.readLine());
        Deque<Integer> q= new LinkedList<>();
        for(int i=0;i<num;i++) {
        	String string= br.readLine();
        	String[] strings=string.split(" ");
        	switch(strings[0]) {
        	case "push":
        		int val=Integer.parseInt(strings[1]);
        		q.addLast(val);
        		break;
        	case "front":
        		if(q.isEmpty()) {
            		bw.append("-1").append('\n');
        		}else {
        			bw.append(String.valueOf(q.peekFirst())).append('\n');
        		}
        		break;
        	case "back":
        		if(q.isEmpty()) {
        			bw.append("-1").append('\n');
        		}else {
        			bw.append(String.valueOf(q.peekLast())).append('\n');

        		}
        		break;
        	case "size":
        		bw.append(String.valueOf(q.size())).append('\n');
        		break;
        	case "empty":
        		if(q.isEmpty()) {
        			bw.append('1').append('\n');
        		}else {
        			bw.append('0').append('\n');

        		}
        		break;
        	case "pop":
        		if(q.isEmpty()) {
            		bw.append("-1").append('\n');
        		}else {
        			bw.append(String.valueOf(q.poll())).append('\n');
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
