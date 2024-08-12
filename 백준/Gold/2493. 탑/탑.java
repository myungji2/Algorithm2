import java.io.*;
import java.util.*;
class Top {
	int num;
	int height;
	Top(int num, int height){
		this.num= num;
		this.height=height;
	}
}
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Top> stack = new Stack<>();
        int num= Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=1;i<num+1;i++) {
        	int height=Integer.parseInt(st.nextToken());
        	if(stack.isEmpty()) {
        		bw.append('0').append(' ');
            	stack.push(new Top(i,height));
        	}else {
                while (!stack.isEmpty() && stack.peek().height < height) {
        			stack.pop();
        		}
        		if(stack.isEmpty()) {
        			bw.append('0').append(' ');
                	stack.push(new Top(i,height));
        		}else {
        			bw.append(String.valueOf(stack.peek().num)).append(' ');
        			stack.push(new Top(i,height));
        		}
        	
        	}
        }
        bw.flush();
        bw.close();
        br.close();
        
    }
}
