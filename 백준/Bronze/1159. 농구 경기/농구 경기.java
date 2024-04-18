import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n=Integer.parseInt(scanner.nextLine());
    String[] names=new String[n];
    for(int i=0; i<n; i++) {
      names[i]=scanner.nextLine();

    }
    Map<Character,Integer> map = new HashMap<Character,Integer>();
    for(String name: names){
      char c=name.charAt(0);
      if(map.containsKey(c)){
        map.put(c, map.get(c)+1);
      }else{
        map.put(c,1);
      }
    }
    String answer="";
    for (Character key: map.keySet()) {
      int value = map.get(key);
      if(map.get(key)>=5){

        answer=answer+key;
      }
    }
    if(answer.isEmpty()){
      answer="PREDAJA";
    }
    System.out.println(answer);

  }
}
