import java.io.*;
import java.util.*;

class Main{
	
	static int n;
	static int m;
	
	static int[] arr;
	
	static PriorityQueue<Range> squeue = new PriorityQueue<Range>((o1, o2) -> Integer.compare(o1.s, o2.s));
	static PriorityQueue<Range> equeue = new PriorityQueue<Range>((o1, o2) -> Integer.compare(o1.e, o2.e));
	
	static class Range {
		public Range(int s, int e, int k){
			this.s = s;
			this.e = e;
			this.k = k;
		}
		int s;
		int e;
		int k;
	}
	
	public static void solution(){
		StringBuilder sb = new StringBuilder();
		int value=0;
		int i=0;
		
		Range range;
		
		while(i < n){
			while(squeue.peek() != null && squeue.peek().s == i){
				range = squeue.poll();
				value += range.k;
				equeue.add(range);
			}
			arr[i] += value;
			while(equeue.peek() != null && equeue.peek().e == i){
				range = equeue.poll();
				value -= range.k;
			}
			i++;
		}
		
		for(int j=0; j<n; j++)
			sb.append(arr[j]).append(" ");
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		m = Integer.parseInt(temp[1]);
		arr = new int[n];
		
		temp = br.readLine().split(" ");
		
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(temp[i]);
		
		for(int i=0; i<m; i++){
			temp = br.readLine().split(" ");
			int s = Integer.parseInt(temp[0])-1;
			int e = Integer.parseInt(temp[1])-1;
			int k = Integer.parseInt(temp[2]);
			squeue.add(new Range(s, e, k));
		}
		solution();
	}
}