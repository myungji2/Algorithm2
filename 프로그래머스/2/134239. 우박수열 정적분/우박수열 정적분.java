import java.util.ArrayList;

class Solution {
  public double[] solution(int k, int[][] ranges) {
    double[] answer = new double[ranges.length];
    ArrayList<Double> x = new ArrayList<>();
    ArrayList<Double> area=new ArrayList<>();
    double k2=(double)k;
    x.add(k2);

    while(k2!=1){
      if((int)(k2%2)==1){
        k2=(double)3*k2+(double)1;
      }else{
        k2 = k2/(double)2;

      }
      if(!x.isEmpty()){
        int lastIdx = x.size() - 1;
        double last=x.get(lastIdx);
        area.add((last>k2)?(last-k2)*0.5+k2:(k2-last)*0.5+last);
      }
      x.add(k2);


    }

    int n=0;
    for(int[] range: ranges){
      int start=range[0];
      double sum=0;
      int end=x.size()+range[1]-1;
      if(end<start||start>=x.size()||-1*end>=x.size()){
        answer[n]=-1.0;
        n++;
        continue;
      }
      for(int i=0;i<end-start;i++){
        sum+=area.get(start+i);
      }
      answer[n]=sum;
      n++;

//      System.out.print(sum+" ");

    }
    return answer;
  }
}