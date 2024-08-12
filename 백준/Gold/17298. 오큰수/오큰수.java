import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2= new Stack<>();
        int num= Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        int[] answer=new int[num];
        for(int i=0;i<num;i++) {
        	stack.push(Integer.parseInt(st.nextToken()));
        }
        for(int i=num-1;i>-1;i--) {
        	int tar=stack.pop();
        	while(!stack2.empty()&&stack2.peek()<=tar) {
        		stack2.pop();
        	}
        	if(stack2.empty()) {
        		answer[i]=-1;
        		stack2.push(tar);
        	}else {
        		answer[i]=stack2.peek();
        		stack2.push(tar);
        	}
        }
        for(int i=0;i<num;i++) {
        	bw.append(String.valueOf(answer[i])).append(' ');
        }
        bw.flush();
        bw.close();
        br.close();
        
    }
}
