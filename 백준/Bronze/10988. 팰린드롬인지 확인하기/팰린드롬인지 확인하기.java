import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    scanner.close();
    Stack<Character> stack = new Stack<Character>();
    int half=s.length()/2;
    for(int i=0;i<half;i++){
      stack.push(s.charAt(i));
    }
    int answer=1;
    half=(s.length()%2==0)?half:half+1;

      for(int i=half;i<s.length();i++) {
        
        if (stack.peek() == s.charAt(i)) {
          stack.pop();
        } else {
          answer = 0;
          break;
        }
        if(stack.isEmpty()&&i!=s.length()-1){
          answer=0;
          break;
        }
      }
    System.out.println(answer);






  }
}
