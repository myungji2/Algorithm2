
import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) throws IOException {
    
         BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
         int num= Integer.parseInt(br.readLine());
         for(int i=0;i<num;i++) {
        	 String string= br.readLine();
        	 String[] arr=string.split("");
        	 Stack<String> lstack= new Stack<>();
        	 Stack <String> rStack = new Stack<>(); 
        	 for(String s: arr) {
        		 switch(s) {
      			case "<":
      				if(!lstack.isEmpty())
      					rStack.push(lstack.pop());

      				break;
      			case ">":
      				if(!rStack.isEmpty())
      					lstack.push(rStack.pop());

      				break;
      			case "-":
      				if(!lstack.isEmpty()) {
      					lstack.pop();
      				}
      				break;
      			
      			default:
      				lstack.push(s);
      				break;
      			}
        	 }
        	 while(!lstack.isEmpty())
            	 rStack.push(lstack.pop());
     		
     		while(!rStack.isEmpty())
     			bw.write(rStack.pop());
     		bw.newLine();
        	
         }
         bw.flush();
   		bw.close(); 
        
         
    }
}
