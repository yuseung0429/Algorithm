import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	
	public static Node root = new Node();
	public static StringBuilder sb = new StringBuilder();
	
	static class Node{
		HashMap<String, Node> child;
	}
	
	public static String solution() {
		rec(root, 0);
		return sb.toString();
	}
	
	public static void rec(Node target, int depth) {
		if(target.child == null)
			return;
		ArrayList<String> list = new ArrayList<>(target.child.keySet());
		list.sort(null);
		
		for(String temp : list) {
			for(int i=0; i<depth; i++)
				sb.append("--");
			sb.append(temp).append("\n");
			rec(target.child.get(temp), depth+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			String[] temp = br.readLine().split(" ");
			int n = Integer.parseInt(temp[0]);
			Node target = root;
			for(int j=1; j<=n; j++) {
				String key = temp[j];
				if(target.child == null)
					target.child = new HashMap<>();
				if(!target.child.containsKey(key))
					target.child.put(key ,new Node());
				target = target.child.get(key);
			}
		}
		System.out.println(solution());
	}
}