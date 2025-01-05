import java.io.*;
import java.util.*;

class Main {
	
	static class Node {
		long sheep;
		long wolf;
		ArrayList<Node> children; 
	}
	
	static Node[] nodes;
	static long leftSheep;
	
	public static long solution() {
		return rec(nodes[0]);
	}
 	
 	public static long rec(Node node) {
		if(node.children != null) {
			long currentSheep = 0;
			for(Node n : node.children) {
				currentSheep += rec(n);
			}
			currentSheep = Math.max(0, currentSheep - node.wolf);
			return currentSheep += node.sheep;
		}
		return node.sheep;
	}
 	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		nodes = new Node[n];
		
		for(int i=0; i<n; i++) {
			nodes[i] = new Node();
		}
		
		for(int i=1; i<n; i++) {
			String[] temp = br.readLine().split(" ");
			Node node = nodes[i];
			switch(temp[0]) {
				case "S":
					node.sheep = Long.parseLong(temp[1]); break;
				case "W":
					node.wolf = Long.parseLong(temp[1]); break;
			}
			int parentIdx = Integer.parseInt(temp[2])-1;
			if(nodes[parentIdx].children == null) {
				nodes[parentIdx].children = new ArrayList<Node>();
			}
			nodes[parentIdx].children.add(nodes[i]);
		}
		
		System.out.println(solution());
	}
}