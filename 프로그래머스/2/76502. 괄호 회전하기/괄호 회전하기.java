import java.util.HashMap;
import java.util.Stack;
class Solution {
  public int solution(String s) {
    int answer = 0;
//    Character[] chars = {'(','[','{',')',']','}'};
    String chars="([{)]}";
    Stack<Character> stack = new Stack<>();
    HashMap<Character,Integer> map = new HashMap<Character,Integer>();
    map.put('(',0);
    map.put('[',0);
    map.put('{',0);
    map.put(')',1);
    map.put(']',1);
    map.put('}',1);

    int length=s.length();
    for (int i = 0; i < length; i++) {
      int flag=0;
      for(int j=0;j<length;j++){
        int index=(i+j)%length;
        char c = s.charAt(index);
        if(map.get(c)==0){
          stack.push(c);

        }
        else if(stack.empty()){
          flag=1;
          break;
        }else{
          if(chars.charAt(chars.indexOf(stack.peek())+3)==c){
            stack.pop();
          }else{
            flag=1;
            break;
          }
        }
      }
      if(flag==0&&stack.empty()){
        answer++;
      }

    }
    return answer;
  }
}