
import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) throws IOException {
       
         BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
         int result=1;
         for(int i=0;i<3;i++) {
        	 result*=Integer.parseInt(br.readLine());
         }
        	 
         int[] resultarr= Stream.of(String.valueOf(result).split(""))
                 .mapToInt(Integer::parseInt)
                 .toArray();
         int[] answer= new int[10];
         for (int num : resultarr) {
             answer[num]++;
         }

         BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
         
         for(int num : answer) {
        	 bw.write(String.valueOf(num));
        	 bw.newLine();
         }
         bw.flush();
         bw.close();
         
         
         
    }
}
