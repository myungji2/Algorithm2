
import java.io.*;
import java.security.spec.ECFieldFp;
import java.util.*;


class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n= Integer.parseInt(br.readLine());
        int[] map= new int[(n*(n+1)/2)+1];
        for(int i=1;i<n+1;i++) {
        	StringTokenizer stringTokenizer=new StringTokenizer(br.readLine());
        	if(i==1) {
        		map[1]=Integer.parseInt(stringTokenizer.nextToken());
        	}else {
        		int start= ((i-1)*(i)/2)+1;
        		int end=i*(i+1)/2;
        		for(int j=start;j<end+1;j++) {
        			int num=Integer.parseInt(stringTokenizer.nextToken());
        			int left=j-i;
        			int right=left+1;
        			if(j==start) {
        				map[j]=map[right]+num;
        			}else if(j==end) {
        				map[j]=map[left]+num ;
        			}else {
        				map[j]=Math.max(map[left], map[right])+num;
        			}
        			
        		}
        	}
        }
        
        int max=0;
        int start2= ((n-1)*(n)/2)+1;
		int end2=n*(n+1)/2;
		for(int j=start2;j<end2+1;j++) {
			if(map[j]>max) {
				max=map[j];
			}
		}
		bw.append(String.valueOf(max));
		bw.flush();
		bw.close();
		br.close();
			
    }
    
}
