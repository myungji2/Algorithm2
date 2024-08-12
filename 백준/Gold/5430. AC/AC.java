import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcase=Integer.parseInt(br.readLine());
        for(int i=0;i<tcase;i++) {
            Deque<String> q = new LinkedList<>();
        	String[] commends=br.readLine().split("");
        	int length=Integer.parseInt(br.readLine());
        	String s=br.readLine();
        	s=s.replaceAll("[\\[\\]]", ""); 
            String[] arr = s.split(",");
            if(length!=0) {
            	for(String ss: arr) {
                	q.addLast(ss);
                }
            }
            
            boolean reverse=false;
            boolean flag=false;
            for(String c: commends) {
            	if(c.charAt(0)=='R') {
            		reverse=!reverse;
            	}else if(c.charAt(0)=='D') {
            		if(q.isEmpty()) {
            			flag=true;
            			break;
            		}else {
            			if(reverse) {
            				q.pollLast();
            			}else {
                			q.pollFirst();

            			}
            		}
            	}
            }
            if(flag) {
            	bw.append("error\n");
            }else {
            	StringBuilder sb=new StringBuilder();
            	sb.append('[');
            	while(q.size()>1) {
            		if(reverse) {
                		sb.append(q.pollLast()).append(',');
            		}else {
                		sb.append(q.pollFirst()).append(',');
            		}
            	}
            	if(!q.isEmpty()) {
            		sb.append(q.poll());
            	}
            	sb.append("]\n");
            	bw.append(sb);
            }
            
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
