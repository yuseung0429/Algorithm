import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
			(o1, o2) -> {
				int value = Integer.compare(Math.abs(o1), Math.abs(o2));
				if(value == 0) {
					return Integer.compare(o1, o2);
				} else {
					return value;
				}
			}
		);
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			int value = Integer.parseInt(br.readLine());
			if (value == 0) {
				if(pq.isEmpty()) {
					sb.append("0").append("\n");
				} else {
					sb.append(pq.poll()).append("\n");
				}
			} else {
				pq.add(value);
			}
		}
		System.out.println(sb.toString());
		
	}
}