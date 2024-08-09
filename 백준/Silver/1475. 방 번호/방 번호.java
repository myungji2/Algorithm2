import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) throws IOException {
       
         BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
         int target = Integer.parseInt(br.readLine());
         int[] targetarr= Stream.of(String.valueOf(target).split(""))
        		 .mapToInt(Integer::parseInt)
        		 .toArray();
         int[] answer= new int[10];
         for (int num : targetarr) {
             answer[num]++;
         }
        int sixnnine = (int) Math.ceil((answer[6] + answer[9]) / 2.0);
         answer[6]=sixnnine;
         answer[9]=sixnnine;
         int max=0;
         for(int num: answer) {
        	 if(num>max) {
        		 max=num;
        	 }
         }
         BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
         bw.write(String.valueOf(max));
         bw.flush();
         bw.close();
    }
}
