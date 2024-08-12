import java.io.*;
import java.util.*;

class People{
	int num;
	int height;
	People(int num,int height){
		this.num=num;
		this.height=height;
	}
}
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<People> stack = new Stack<>();
        int num= Integer.parseInt(br.readLine());
        long answer=0;
        for(int i=0;i<num;i++) {
        	int val= Integer.parseInt(br.readLine());
        	if(stack.isEmpty()) {
        		stack.push(new People(1, val));
        	}else {
        		if(stack.peek().height<=val) {
        			int count=0;
        			int count2=0;
        			while(!stack.isEmpty()&&stack.peek().height<val) {
        				count+=stack.peek().num;
        				stack.pop();
        				
        			}
        			if(!stack.isEmpty()&&stack.peek().height==val) {
        				count2=stack.peek().num;
        				stack.pop();
        			}
        			
        			if(!stack.isEmpty()&&stack.peek().height>val) {
        				count+=1;
        			}
        			answer+=count+count2;
        			stack.push(new People(count2+1, val));
        			
        		}else {
        			answer+=1;
        			stack.push(new People(1, val));
        		}
        	}
        }
        bw.append(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
        
    }
}
