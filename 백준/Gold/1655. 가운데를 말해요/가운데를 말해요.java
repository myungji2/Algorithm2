
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.IntPredicate;
import java.util.stream.Stream;
class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<Integer> maxheap=new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minheap=new PriorityQueue<>();
		
		int n=Integer.parseInt(br.readLine());
		  StringBuilder sb = new StringBuilder(); 

		for(int i=0;i<n;i++) {
			 st = new StringTokenizer(br.readLine());
	         int num = Integer.parseInt(st.nextToken());
			

	            if (maxheap.size() > minheap.size()) {
	                minheap.add(num);
	            } else {
	                maxheap.add(num);
	            }
			if(!maxheap.isEmpty() && !minheap.isEmpty() &&maxheap.peek()>minheap.peek()) {
				int max=maxheap.poll();
				int min=minheap.poll();
				maxheap.add(min);
				minheap.add(max);			}

			 sb.append(maxheap.peek() + "\n");
		}
		
		 System.out.println(sb);
	}
}