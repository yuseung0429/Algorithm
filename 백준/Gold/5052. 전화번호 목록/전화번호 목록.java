import java.io.*;
import java.util.*;

class Main {
	
	static class Node {
		public Node() {
			children = new Node[10];
		}
		boolean dirty;
		Node[] children;
	}
	
	public static String solution(int n, String[] arr) {
		Node root = new Node();
		for (String str : arr) {
			Node target = root;
			for (char c : str.toCharArray()) {
				Node[] children = target.children;
				if (children[c-'0'] == null) {
					children[c-'0'] = new Node();
					target.dirty = true;
				}
				target = children[c-'0'];
			} 
		}
		for(String str : arr) {
			Node target = root;
			for (char c : str.toCharArray()) {
				target = target.children[c-'0'];
			}
			if(target.dirty) {
				return "NO";
			}
		}
		return "YES";
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for (int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			String[] arr = new String[n];
			for(int j=0; j<n; j++) {
				arr[j] = br.readLine();
			}
			sb.append(solution(n, arr)).append("\n");
		}
		System.out.print(sb);
	}
}