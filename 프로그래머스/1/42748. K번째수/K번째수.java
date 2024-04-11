import java.util.*;
class Solution {
  public int[] solution(int[] array, int[][] commands) {
    int[] answer=new int[commands.length];

    int a=0;
    for(int[] command:commands){
      int arr[]=Arrays.copyOfRange(array,command[0]-1,command[1]);
      Arrays.sort(arr);



      answer[a]=arr[command[2]-1];
      a++;
    }
    return answer;
  }
}