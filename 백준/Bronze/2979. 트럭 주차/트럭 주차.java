import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] numbers = scanner.nextLine().split(" ");
    int a = Integer.parseInt(numbers[0]);
    int b = Integer.parseInt(numbers[1]);
    int c = Integer.parseInt(numbers[2]);
    HashMap<Integer, Integer> times = new HashMap<Integer, Integer>( );

    //scanner.nextLine();
    for(int j=0;j<3;j++) {
      String[] pair = scanner.nextLine().split(" ");
      int in = Integer.parseInt(pair[0]);
      int out = Integer.parseInt(pair[1]);
      for(int i=in;i<out;i++){
        if(times.containsKey(i)){
          times.put(i, times.get(i)+1);
        }else{
          times.put(i, 1);
        }
      }

    }
    scanner.close();
    int answer=0;
    for (int key: times.keySet()) {
      int value = times.get(key);
      switch(value){
        case 1:
          answer+=a;
          break;
        case 2:
          answer+=2*b;
          break;
        case 3:
          answer+=3*c;
          break;
      }
    }
    System.out.println(answer);


  }
}
