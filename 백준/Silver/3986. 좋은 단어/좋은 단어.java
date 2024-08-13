import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb=new StringBuilder();
        int num= Integer.parseInt(br.readLine());
        int answer=0;
        for(int i=0;i<num;i++) {
        	Stack<String> stack=new Stack<>();
        	String[] string=br.readLine().split("");
        	for(String s: string) {
        		if(!stack.isEmpty()&&stack.peek().equals(s)) {
        			stack.pop();
        		}else {
        			stack.push(s);
        		}
        	}
        	if(stack.isEmpty()) {
        		answer++;
        	}
        	
        }
        bw.append(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
        
    }
}
