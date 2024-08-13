import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb=new StringBuilder();
        int num= Integer.parseInt(br.readLine());
        for(int i=0;i<num;i++) {
        	Stack<String> stack=new Stack<>();
        	String[] string=br.readLine().split("");
        	for(String s: string) {
        		if(s.equals("(")) {
        			stack.push(s);
        		}else {
        			if(!stack.isEmpty()&&stack.pop().equals("(")) {
        				continue;
        			}else {
        				stack.push(s);
						break;
					}
        		}
        		
        	}
        	if(stack.isEmpty()) {
        		sb.append("YES\n");
        	}else {
        		sb.append("NO\n");
        	}
        	
        }
        bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
        
    }
}
