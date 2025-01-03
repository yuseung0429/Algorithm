import java.io.*;
import java.util.*;

class Main {
	
	static class Node {
		public Node(char value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
		char value;
		Node left;
		Node right;
	}

	public static StringBuilder sb = new StringBuilder();
	
	public static String solution(Node root) { 
		preorder(root);
		sb.append("\n");
		inorder(root);
		sb.append("\n");
		postorder(root);
		return sb.toString();
	}
	
	public static void preorder(Node node) {
		if(node == null) {
			return;
		}
		sb.append(node.value);
		preorder(node.left);
		preorder(node.right);
	}
	
	public static void inorder(Node node) {
		if(node == null) {
			return;
		}
		inorder(node.left);
		sb.append(node.value);
		inorder(node.right);
	}
	
	public static void postorder(Node node) {
		if(node == null) {
			return;
		}
		postorder(node.left);
		postorder(node.right);
		sb.append(node.value);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Node[] nodes = new Node[n];
		
		for (int i=0; i<n; i++) {
			nodes[i] = new Node((char)('A'+ i), null, null);
		}
		
		for (int i=0; i<n; i++) {
			String[] temp = br.readLine().split(" ");
			char parent = temp[0].charAt(0);
			char leftChild = temp[1].charAt(0);
			char rightChild = temp[2].charAt(0);
			
			if (leftChild != '.') {
				nodes[parent-'A'].left = nodes[leftChild-'A'];
			}
			
			if(rightChild != '.') {
				nodes[parent-'A'].right = nodes[rightChild-'A'];
			}
		}
		
		System.out.println(solution(nodes[0]));
	}
	
}
