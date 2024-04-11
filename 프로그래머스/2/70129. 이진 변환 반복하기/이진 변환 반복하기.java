import java.util.*;

class Solution {
  public int[] solution(String s) {
    int[] answer = new int[2];
    int zero=0;
    int binary=1;
    while(!s.equals("1")){
      int len1=s.length();
      s=s.replace("0","");
      int len=s.length();
      zero+=len1-len;
      if(!s.equals("1")){
        binary++;
        s=Integer.toBinaryString(len);
      }
      else{
        break;
      }

    }
    answer[0]=binary;

    answer[1]=zero;
//    System.out.println(binary);
//    System.out.println(zero);

    return answer;
  }
}