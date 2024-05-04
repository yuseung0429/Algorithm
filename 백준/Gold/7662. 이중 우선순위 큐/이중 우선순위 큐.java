import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
	static TreeSet<Node> set;
	
	static class Node implements Comparable<Node>{
		Node(int value, int seq){
			this.value = value;
			this.seq = seq;
		}
		int value;
		int seq;
		@Override
		public int compareTo(Node o) {
			if(this.value == o.value)
				return this.seq - o.seq;
			return Integer.compare(this.value, o.value);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			set = new TreeSet<>();
			int n = Integer.parseInt(br.readLine());
			int seq = 0;
			for(int j=0; j<n; j++) {
				String[] temp = br.readLine().split(" ");
				if(temp[0].equals("I")) {
					int number = Integer.parseInt(temp[1]);
					set.add(new Node(number, seq++));
					continue;
				}
				if(temp[1].equals("1"))
					set.pollLast();
				else
					set.pollFirst();
			}
			sb.append(((set.isEmpty()) ? "EMPTY\n" : String.format("%d %d\n", set.last().value, set.first().value)));
		}
		System.out.println(sb.toString());
	}
}
