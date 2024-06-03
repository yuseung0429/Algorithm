import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
	
	static int n;
	static int parents;
	static Node root;
	static Node[] nodes;
	static int result;
	
	static class Node{
		Node(int number, int depth, int time){
			this.number = number;
			this.depth = depth;
			this.time = time;
			children = new ArrayList<Node>();
		}
		int number;
		int depth;
		int time;
		ArrayList<Node> children;
	}
	
	public static int solution() {
		int depth = 0;
		boolean flag = true;
		while(flag) {
			flag = false;
			for(Node node : nodes) {
				if(depth != node.depth)
					continue;
				flag = true;
				if(depth == 0) {
					node.time = 1;
					continue;
				}
				node.children.sort((o1, o2) -> Integer.compare(o2.time, o1.time));
				int time = 0;
				int cnt = 0;
				for(Node child : node.children)
					time = Math.max(time, child.time + ++cnt);
				node.time = time;
			}
			depth++;
		}
		
		return root.time-1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] parents = new int[n];
		nodes = new Node[n];
		String[] temp = br.readLine().split(" ");
		
		for(int i=0; i<n; i++) {
			parents[i] = Integer.parseInt(temp[i]);
			nodes[i] = new Node(i, 0, 0);
		}
		
		for(int i=1; i<n; i++) {
			Node parent = nodes[parents[i]];
			parent.children.add(nodes[i]);
			int cnt = 1;
			while(parent.number != 0) {
				parent.depth = Math.max(parent.depth, cnt++);
				parent = nodes[parents[parent.number]];
			}
			parent.depth = Math.max(parent.depth, cnt++);
		}
		root = nodes[0];
		System.out.println(solution());
	}
}
