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
	
	public static int solution() {
		Arrays.sort(nodes, (o1, o2) -> o1.end - o2.end);

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		int maxValue = Integer.MIN_VALUE;
		
		for (Node node : nodes) {
			pq.add(node.start);
			
			while(!pq.isEmpty() && pq.peek() < node.end - d) {
				pq.poll();
			}
			
			maxValue = Math.max(maxValue, pq.size());
		}

		return maxValue;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());		
		nodes = new Node[n];
		
		for (int i=0; i<n; i++) {
			String[] temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			if (a > b) {
				nodes[i] = new Node(b, a);
			} else {
				nodes[i] = new Node(a, b);
			}
		}
		
		d = Integer.parseInt(br.readLine());
		
		System.out.println(solution());
	}

}
