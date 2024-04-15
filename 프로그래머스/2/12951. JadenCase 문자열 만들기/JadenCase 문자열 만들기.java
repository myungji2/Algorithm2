class Solution {
  public String solution(String s) {
    String answer = "";
    s=s.toLowerCase();

    boolean first=true;
    for(int i=0; i<s.length(); i++) {
      char c = s.charAt(i);
      if(c==' '){
        answer=answer+c;
        first=true;
      }
      else if(first==true&&('a'<=c && c<='z')){
          answer=answer+Character.toUpperCase(c);
          first=false;
      }else if(first==true){
        answer=answer+c;
        first=false;
      }else {
          answer=answer+c;

        }


    }
    return answer;
  }
}