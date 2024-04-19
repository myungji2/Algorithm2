class Solution
{
    public int solution(int n, int a, int b)
  {

    for(int i=1;i<n;i++){
      if(Math.abs(a-b)==1&&Integer.max(a,b)%2==0){
        return i;
      }
      a=(int)Math.ceil(((double)a)/2.0);
      b=(int)Math.ceil(((double)b)/2.0);

      
    }


    return 0;
  }
}