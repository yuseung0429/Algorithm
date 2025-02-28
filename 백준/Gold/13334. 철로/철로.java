import java.io.*;
import java.util.*;

class Main {
	
	static int n;
	static int d;
	static Node[] nodes;
	
	static class Node {
		Node(int start, int end) {
			this.start = start;
			this.end = end;
		}
		int start;
		int end;
	}
	
	public static int solution(int minValue) {
		Arrays.sort(nodes, (o1, o2) -> o1.end - o2.end);
		PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.start - o2.start);
		
		int maxValue = Integer.MIN_VALUE;
		
		int i = 0;
		
		int left = minValue;
		int right = left+d;
		
		while(i<n) {
			while(i<n && nodes[i].end <= right) {
				pq.add(nodes[i]);
				i++;
			}
			
			while(!pq.isEmpty() && pq.peek().start < left) {
				pq.poll();
			}
			
			maxValue = Math.max(maxValue, pq.size());
			
			left += 1;
			right += 1;
		}
		
		return maxValue;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());		
		nodes = new Node[n];
		
		int minValue = Integer.MAX_VALUE;
		
		for (int i=0; i<n; i++) {
			String[] temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			if (a > b) {
				nodes[i] = new Node(b, a);
				minValue = Math.min(minValue, b);
			} else {
				nodes[i] = new Node(a, b);
				minValue = Math.min(minValue, a);
			}
		}
		
		d = Integer.parseInt(br.readLine());
		
		System.out.println(solution(minValue));
	}

}