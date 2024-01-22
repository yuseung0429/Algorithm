import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void solution(int n, int k) {
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for(int i=1; i<=n; i++)
			queue.add(i);
		int i = 0;
		while(!queue.isEmpty()) {
			Integer temp = queue.poll();
			if(++i%k == 0) {
				sb.append(temp);
				if(!queue.isEmpty())
					sb.append(", ");
			}
			else
				queue.add(temp);	
		}
		sb.append(">");
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);
		solution(n, k);
	}
}