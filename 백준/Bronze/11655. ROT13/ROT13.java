import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Solution solution = new Solution();
    Scanner scanner = new Scanner(System.in);
    String s=scanner.nextLine();
    String answer = solution.solution(s);
    System.out.println(answer);
  }
}
class Solution{
  public String solution(String s){
    String answer="";
    for (Character key: s.toCharArray()) {
      if('A'<=key&&key<='Z'-13) {
        key= (char)(key+13);
      }
      else if('Z'-12<=key&&key<='Z'){
        key=(char)(key+12-'Z'+'A');
      }
      else if('a'<=key&&key<='z'-13){
        key= (char)(key+13);
      }
      else if('z'-12<=key&&key<='z'){
        key=(char)(key+12-'z'+'a');
      }
      answer+=key;
    }
    return answer;
  }

}