class Solution{
  public int[] solution(String[] park, String[] routes){

    int curi=0,curj=0,flag=0;
    int rows=park.length;
    int cols=park[0].length();
    for(int i=0;i<rows;i++){
      for(int j=0;j<cols;j++){
        if(park[i].charAt(j)=='S') {
          curi = i;
          curj = j;
          flag=1;
          break;
        }
      }
      if(flag==1) {
        break;
      }
    }
    System.out.println("현재 위치: "+curi+" "+curj);
    for(String route: routes){
      flag=0;
      String command[]=route.split(" ");
      int move=Integer.parseInt(command[1]);
      switch(command[0]){
        case "N":
          if(curi-move>=0){
            for(int j=1;j<=move;j++){
              if(park[curi-j].charAt(curj)=='X'){
                flag=1;
                break;
              }
            }
            if(flag==0){
              curi-=move;
              System.out.println("이동: "+curi+" "+curj);
            }

          }
          break;
        case "S":
          if(curi+move<rows){
            for(int j=1;j<=move;j++){
              if(park[curi+j].charAt(curj)=='X'){
                flag=1;
                break;
              }
            }
            if(flag==0){
              curi+=move;
              System.out.println("이동: "+curi+" "+curj);
            }

          }
          break;
        case "W":
          if(curj-move>=0){
            for(int j=1;j<=move;j++){
              if(park[curi].charAt(curj-j)=='X')  {
                flag=1;
                break;
              }
            }
            if(flag==0){
              curj-=move;
              System.out.println("이동: "+curi+" "+curj);
            }

          }
          break;
        case "E":
          if(curj+move<cols){
            for(int j=1;j<=move;j++){
              if(park[curi].charAt(curj+j)=='X')  {
                flag=1;
                break;
              }
            }
            if(flag==0){
              curj+=move;
              System.out.println("이동: "+curi+" "+curj);
            }
          }
          break;
        default:
          break;

      }
    }


    int answer[]={curi,curj};
    return answer;
  }

}