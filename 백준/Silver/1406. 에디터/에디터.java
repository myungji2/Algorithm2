import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) throws IOException {
       
         BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
         String s= br.readLine();
         String[] sarr=s.split("");
         Stack<String> lstack= new Stack<>();
         Stack<String> rStack= new Stack<>();
         for(String string: sarr) {
        	 lstack.push(string);
         }
         int count=Integer.parseInt(br.readLine());
         for(int i=0;i<count;i++) {
        	 String command = br.readLine();
        	 char c = command.charAt(0);
        	 switch(c) {
 			case 'L':
 				if(!lstack.isEmpty())
 					rStack.push(lstack.pop());

 				break;
 			case 'D':
 				if(!rStack.isEmpty())
 					lstack.push(rStack.pop());

 				break;
 			case 'B':
 				if(!lstack.isEmpty()) {
 					lstack.pop();
 				}
 				break;
 			case 'P':
 				char t = command.charAt(2);
 				lstack.push(String.valueOf(t));
 				break;
 			default:
 				break;
 			}
         }
         BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
         while(!lstack.isEmpty())
        	 rStack.push(lstack.pop());
 		
 		while(!rStack.isEmpty())
 			bw.write(rStack.pop());
 		
 		bw.flush();
 		bw.close(); 
         
         
    }
}
