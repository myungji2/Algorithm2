import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] inputs=br.readLine().split("");
        int laser=0;
        int answer=0;
        Stack<String> stack= new Stack<String>();
        boolean flag=false;
        for(String input: inputs) {
        	if(input.equals("(")) {
        		stack.push("(");
        		flag=true;
        	}else if(input.equals(")")) {
        		stack.pop();
        		if(flag) {
        			answer+=stack.size();
        			flag=!flag;
        			laser++;
        		}
        	}
        }
        answer+=inputs.length/2-laser;
        bw.append(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
        
    }
}
