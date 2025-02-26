import java.io.*;
import java.util.*;

class Main{
	
	static int n;
	static int t;
	static int g;
	static int minChance = Integer.MAX_VALUE;
	
	public static String solution() {
		boolean[] visited = new boolean[100000];
		ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
		queue.addLast(new int[] {n, 0});
		
		while(!queue.isEmpty()) {
			int[] node = queue.pollFirst();
			
			int value = node[0];
			int chance = node[1];
			
			if (value == g) {
				return String.valueOf(node[1]);
			}
			
			if (visited[value] || chance >= t) {
				continue;
			}
			
			visited[value] = true;
			
			if (value+1<=99999) {
				queue.addLast(new int[] {value+1, chance+1});
			}
			
			if (2*value<=99999 && value != 0) {
				int num = 10000;
				while((2*value / num) == 0) {
					num/=10;
				}
				queue.addLast(new int[] {2*value-num, chance+1});
			}
		}
		
		return "ANG";
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		t = Integer.parseInt(temp[1]);
		g = Integer.parseInt(temp[2]);
		
		System.out.println(solution());
	}
}
