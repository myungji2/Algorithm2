import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Solution solution = new Solution();
    Scanner scanner = new Scanner(System.in);

    int n=Integer.parseInt(scanner.nextLine());
    String pattern=scanner.nextLine();

    String[] titles=new String[n];
    for(int i=0;i<n;i++) {
      titles[i]=scanner.nextLine();
    }
    solution.solution(pattern,titles);

  }
}
class Solution{
  public void solution(String pattern,String[] titles){


    for (int j = 0; j < titles.length; j++) {
      int flag=0;
      int idx=0;
      int length=titles[j].length();
      for(int i=0;i<pattern.length();i++){
        char c=pattern.charAt(i);
        if(c=='*'){
            idx--;
          break;
        }
        if(idx>length||c!=titles[j].charAt(idx)){
          flag=1;
          break;
        }else{
          idx++;
        }
      }

      if(flag==0){
        int newidx=titles[j].length()-1;
        for(int i=pattern.length()-1;i>0;i--){
          char c=pattern.charAt(i);
          if(c=='*'){
            break;
          }
          if(newidx<=idx||c!=titles[j].charAt(newidx)){
            flag=1;
            break;
          }else{
            newidx--;
          }
        }
      }
      if(flag==0){
        System.out.println("DA");
      }else{
        System.out.println("NE");
      }
    }

  }

}