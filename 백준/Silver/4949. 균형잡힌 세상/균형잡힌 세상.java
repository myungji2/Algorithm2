import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb=new StringBuilder();
        while(true) {
        	String string=br.readLine();
        	if(string.equals(".")) {
        		break;
        	}
        	Stack<String> stack=new Stack<String>();
        	string=string.replaceAll("[^()\\[\\]]", "");
        	String[] arr=string.split("");

        	boolean flag=false;
        	for(String s: arr) {
        		switch (s) {
        		case "[":
        			stack.push(s);
        			break;
        		case "(":
        			stack.push(s);
        			break;
        		case "]":

        			if(stack.isEmpty()) {
        				flag=true;
        			}
        			else if(!stack.pop().equals("[")) {
        				flag=true;
        			}
        			break;
        		case ")":

        			if(stack.isEmpty()) {
        				flag=true;
        			}
        			else if(!stack.pop().equals("(")) {
        				flag=true;
        			}
        			break;
        		default:
        			break;
        		}
        		if(flag) {
        			break;
        		}
        		
        	}
        	if(flag||!stack.isEmpty()) {
        		sb.append("no\n");
        	}else {
        		sb.append("yes\n");
        	}
        }
        bw.append(sb);
        bw.flush();
        bw.close();
        br.close();
        
    }
}
