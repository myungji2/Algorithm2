class Solution {
  public long[] solution(long[] numbers) {

    long[] answer = new long[numbers.length];
    int i=0;
    for(long number: numbers){
      String ans="";
      String num="0"+Long.toBinaryString(number);
      int firstone=num.indexOf("1");
      int lastzero=num.lastIndexOf("0");
      
      if(firstone==-1){
        answer[i]=1;
      }else {
         ans= (lastzero<firstone)?num.substring(0,lastzero)+"10"+num.substring(firstone+1):
            (lastzero!=num.length()-1?
                num.substring(0,lastzero)+"10"+num.substring(lastzero+2):
                num.substring(0,lastzero)+"1"+num.substring(lastzero+1));
        answer[i]=Long.parseLong(ans, 2);
      }
     
      i++;


    }
    return answer;
  }
}