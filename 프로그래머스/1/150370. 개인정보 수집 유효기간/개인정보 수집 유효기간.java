import java.util.*;
class Solution {
  public int[] solution(String today, String[] terms, String[] privacies) {

    ArrayList<Integer> answer = new ArrayList<>();
    today=today.replace(".","");

    int today_int=Integer.parseInt(today);

    Map<String,Integer> map = new HashMap<String,Integer>();
    for(String term: terms){
      String[] termlist = term.split(" ");
      map.put(termlist[0], Integer.parseInt(termlist[1]));

    }

    for(int j=0;j<privacies.length;j++){
      String privacy=privacies[j];
      String[] privacylist=privacy.split(" ");
      int month= map.get(privacylist[1]);
      String date=privacylist[0];
      date=date.replace(".","");
      int date_int=Integer.parseInt(date);
      date_int+=month/12*10000+month%12*100;

      int temp=((date_int-(date_int/10000)*10000)/100);

      if(temp>12){
        temp=(temp%12==0)?(temp/12)-1:temp/12;
        date_int+=temp*10000-temp*12*100;
      }
      if(date_int<=today_int){
        answer.add(j+1);
      }
    }

    return answer.stream().mapToInt(Integer::intValue).toArray();
  }
}