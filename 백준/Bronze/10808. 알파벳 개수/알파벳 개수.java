import java.util.*;

public class Main{
  public static void main(String[] args) {
    Solution solution = new Solution();
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    solution.solution(s);

  }
}

class Solution {
  public List<Integer> solution(String s) {
    List<Integer> list = new ArrayList<>(Collections.nCopies(26, 0));

    for(int i=0;i<s.length();i++){
      int index=(int)s.charAt(i)-(int)'a';
      int value=list.get(index);
      list.set(index,value+1);

    }
    for (int i = 0; i < list.size(); i++) {
      int value = list.get(i);
      System.out.printf(value+" ");
    }

    return list;
  }
}