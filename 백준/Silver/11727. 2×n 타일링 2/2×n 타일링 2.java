
import java.io.*;
import java.security.spec.ECFieldFp;
import java.util.*;


class Main {
	public static int value=10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n= Integer.parseInt(br.readLine());
        int[] arr= new int[n+2];
        arr[0]=0;
        arr[1]=1;
        arr[2]=3;
        if(n<3) {
        	bw.append(String.valueOf(arr[n]));
        }else{
        	for(int i=3;i<n+1;i++) {
        		arr[i]=(arr[i-1]%value+2*arr[i-2]%value)%value;
        	}
        	bw.append(String.valueOf(arr[n]));
        }
		bw.flush();
		bw.close();
		br.close();
			
    }
    
}
